package ma.ac.usms.ensak.presentation.controller;

import java.time.ZoneId;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Collections;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.FullCalendarView;

import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.io.InputStreamReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.http.HttpTransport;


/**
 * The controller class for the FullCalendarView.
 */
public class FullCalendarViewController {

    private TaskManager taskManager = new TaskManager();

    private static FullCalendarView fullCalendarView = new FullCalendarView(YearMonth.now());
    private YearMonth currentYearMonth;
    private VBox vbox;
    private static final String APPLICATION_NAME = "ProfTrack";
    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".credentials/calendar-java-quickstart");
    private static FileDataStoreFactory DATA_STORE_FACTORY;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static HttpTransport HTTP_TRANSPORT;
    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_READONLY);


    /**
     * Constructs a FullCalendarViewController object.
     * Initializes the FullCalendarView and sets up event handlers for previous and next month buttons.
     */
    public FullCalendarViewController() {

        vbox = new VBox();

        Button importButton = new Button("Import from Google Calendar");
        importButton.setOnAction(e -> {
            try {
                // Initialize Calendar service with valid OAuth credentials
                Calendar service = getCalendarService();

                // List the next 10 events from the primary calendar.
                DateTime now = new DateTime(System.currentTimeMillis());
                Events events = service.events().list("primary")
                    .setMaxResults(10)
                    .setTimeMin(now)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();
                List<Event> items = events.getItems();

                for (Event event : items) {
                    addMultiDayTask(
                        LocalDate.ofInstant(Instant.ofEpochMilli(event.getStart().getDate().getValue()), ZoneId.systemDefault()),
                        LocalDate.ofInstant(Instant.ofEpochMilli(event.getEnd().getDate().getValue()), ZoneId.systemDefault()),
                        event.getSummary(),
                        event.getId()
                    );
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        vbox.getChildren().add(importButton);


        fullCalendarView.getpreviousMonth().setOnAction(e -> previousMonth());

        fullCalendarView.getnextMonth().setOnAction(e -> nextMonth());

        currentYearMonth = fullCalendarView.getCurrentYearMonth();

        initialize();
    }

    /**
     * Handles the action when the previous month button is clicked.
     * Updates the currentYearMonth to the previous month and updates the calendar view.
     */
    private void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        fullCalendarView.populateCalendar(currentYearMonth);
        initialize();

    }

    /**
     * Handles the action when the next month button is clicked.
     * Updates the currentYearMonth to the next month and updates the calendar view.
     */
    private void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
        fullCalendarView.populateCalendar(currentYearMonth);
        initialize();

    }

    /**
     * Gets the FullCalendarView object associated with this controller.
     * @return The FullCalendarView object.
     */
    public FullCalendarView getFullCalendarView() {
        return fullCalendarView;
    }

    /**
     * Initializes the FullCalendarView by retrieving the list of tasks from the TaskManager
     * and adding them to the calendar view.
     */
    public void initialize() {
        List<Task> tasks = taskManager.listTasks();
        for (Task task : tasks) {
            LocalDate startDate = task.getStart_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endDate = task.getEnd_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (task.getStart_date().equals(task.getEnd_date())) {
                addTask(startDate, task.getTitle(), task.getId());
            } else {
                addMultiDayTask(startDate, endDate, task.getTitle(), task.getId());
            }
        }
    }

    /**
     * Adds a task to the FullCalendarView for a specific date.
     * @param date The date of the task.
     * @param taskTitle The title of the task.
     * @param idTask The ID of the task.
     */
    public void addTask(LocalDate date, String taskTitle, String idTask) {
        fullCalendarView.addTask(date, taskTitle, idTask);
    }

    /**
     * Adds a multi-day task to the FullCalendarView.
     * @param startDate The start date of the task.
     * @param endDate The end date of the task.
     * @param taskTitle The title of the task.
     * @param idTask The ID of the task.
     */
    public void addMultiDayTask(LocalDate startDate, LocalDate endDate, String taskTitle, String idTask) {
        fullCalendarView.addMultiDayTask(startDate, endDate, taskTitle, idTask);
    }
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in = FullCalendarViewController.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    public static Calendar getCalendarService() throws IOException {
        Credential credential = authorize();
        return new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}