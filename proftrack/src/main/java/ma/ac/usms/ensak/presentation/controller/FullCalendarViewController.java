package ma.ac.usms.ensak.presentation.controller;

import java.time.ZoneId;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.FullCalendarView;

/**
 * The controller class for the FullCalendarView.
 */
public class FullCalendarViewController {

    private TaskManager taskManager = new TaskManager();

    private static FullCalendarView fullCalendarView = new FullCalendarView(YearMonth.now());
    private YearMonth currentYearMonth;

    /**
     * Constructs a FullCalendarViewController object.
     * Initializes the FullCalendarView and sets up event handlers for previous and
     * next month buttons.
     */
    public FullCalendarViewController() {

        fullCalendarView.getpreviousMonth().setOnAction(e -> previousMonth());

        fullCalendarView.getnextMonth().setOnAction(e -> nextMonth());

        currentYearMonth = fullCalendarView.getCurrentYearMonth();

        initialize();
    }

    /**
     * Handles the action when the previous month button is clicked.
     * Updates the currentYearMonth to the previous month and updates the calendar
     * view.
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
     * 
     * @return The FullCalendarView object.
     */
    public FullCalendarView getFullCalendarView() {
        return fullCalendarView;
    }

    /**
     * Initializes the FullCalendarView by retrieving the list of tasks from the
     * TaskManager
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
     * 
     * @param date      The date of the task.
     * @param taskTitle The title of the task.
     * @param idTask    The ID of the task.
     */
    public void addTask(LocalDate date, String taskTitle, String idTask) {
        fullCalendarView.addTask(date, taskTitle, idTask);
    }

    /**
     * Adds a multi-day task to the FullCalendarView.
     * 
     * @param startDate The start date of the task.
     * @param endDate   The end date of the task.
     * @param taskTitle The title of the task.
     * @param idTask    The ID of the task.
     */
    public void addMultiDayTask(LocalDate startDate, LocalDate endDate, String taskTitle, String idTask) {
        fullCalendarView.addMultiDayTask(startDate, endDate, taskTitle, idTask);
    }
}