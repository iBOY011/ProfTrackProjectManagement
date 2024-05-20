package ma.ac.usms.ensak.presentation.Views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.exception.*;
import ma.ac.usms.ensak.metier.management.WorkSessionManager;
import ma.ac.usms.ensak.presentation.controller.ControllerUtils;
import ma.ac.usms.ensak.presentation.controller.ShowBoxController;
import ma.ac.usms.ensak.util.TimePicker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


public class AddWorkSessionView {
    private VBox root;
    private TextArea descriptionTextArea;
    private DatePicker datePicker;
    private TimePicker startTimePicker;
    private TimePicker endTimePicker;
    private Button addButton;

    public AddWorkSessionView() {
        initializeComponents();
        setupLayout();
        applyStyles();
    }

    private void initializeComponents() {
        root = new VBox(10);
        descriptionTextArea = new TextArea();
        descriptionTextArea.setPromptText("Enter description");
        datePicker = new DatePicker();
        startTimePicker = new TimePicker();
        endTimePicker = new TimePicker();
        addButton = new Button("Add Work Session");
        addButton.setOnAction(event -> addWorkSession());
    }

    private void setupLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(new Label("Description:"), 0, 0);
        gridPane.add(descriptionTextArea, 1, 0);
        gridPane.add(new Label("Date:"), 0, 1);
        gridPane.add(datePicker, 1, 1);
        gridPane.add(new Label("Start Time:"), 0, 2);
        gridPane.add(startTimePicker, 1, 2);
        gridPane.add(new Label("End Time:"), 2, 2);
        gridPane.add(endTimePicker, 3, 2);

        root.getChildren().addAll(gridPane, addButton);
        VBox.setMargin(gridPane, new Insets(10));
        VBox.setMargin(addButton, new Insets(10));
    }

    private void applyStyles() {
        root.getStyleClass().add("root-container");
        addButton.getStyleClass().add("add-button");
        descriptionTextArea.getStyleClass().add("text-area");
        datePicker.getStyleClass().add("date-picker");
        // Add more styles as needed
    }

    public VBox getRoot() {
        return root;
    }

    private void addWorkSession() {
        String description = descriptionTextArea.getText();
        LocalDate date = datePicker.getValue();

        if (description.isEmpty() || date == null || startTimePicker.getSelectedTime() == null || endTimePicker.getSelectedTime() == null){
            AlertHandler.showFailureAlert("Please fill all fields");
            return;
        }

        LocalTime startTime = startTimePicker.getSelectedTime();
        LocalTime endTime = endTimePicker.getSelectedTime();

        LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(date, endTime);

        // if (!InputValidator.isValidDateRange(startDateTime, endDateTime)) {
        //     return;
        // }

        Date convertedStartDate = ControllerUtils.convertLocalDateTimeToDate(startDateTime);
        Date convertedEndDate = ControllerUtils.convertLocalDateTimeToDate(endDateTime);
        try {
            WorkSessionManager workSessionManager = new WorkSessionManager();
            workSessionManager.createWorkSession(description, convertedStartDate, convertedEndDate, "", ShowBoxController.getIdProjectSelected());
            AlertHandler.showSuccessAlert("Work session added successfully");
        } catch (Exception ex) {
            AlertHandler.showFailureAlert("Failed to add work session");
        }

        // Optionally, you can reset fields after adding the work session
        descriptionTextArea.clear();
        datePicker.setValue(null);
        startTimePicker.reset();
        endTimePicker.reset();

        // Show success message or perform any other actions
    }
}
