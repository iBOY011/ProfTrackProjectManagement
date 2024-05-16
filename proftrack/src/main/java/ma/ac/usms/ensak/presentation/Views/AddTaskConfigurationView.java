package ma.ac.usms.ensak.presentation.Views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddTaskConfigurationView extends GridPane {

    public AddTaskConfigurationView() {
        setPadding(new Insets(20, 20, 20, 20));
        setVgap(10);
        setHgap(10);

        // Labels
        Label projectLabel = new Label("Project:");
        GridPane.setConstraints(projectLabel, 0, 0);

        Label listLabel = new Label("List:");
        GridPane.setConstraints(listLabel, 0, 1);

        Label startDateLabel = new Label("Start Date:");
        GridPane.setConstraints(startDateLabel, 0, 2);

        Label endDateLabel = new Label("End Date:");
        GridPane.setConstraints(endDateLabel, 0, 3);

        Label descriptionLabel = new Label("Description:");
        GridPane.setConstraints(descriptionLabel, 0, 4);

        // ChoiceBox for projects
        ChoiceBox<String> projectChoiceBox = new ChoiceBox<>();
        projectChoiceBox.getItems().addAll("Project 1", "Project 2", "Project 3");
        GridPane.setConstraints(projectChoiceBox, 1, 0);

        // ChoiceBox for lists
        ChoiceBox<String> listChoiceBox = new ChoiceBox<>();
        listChoiceBox.getItems().addAll("List 1", "List 2", "List 3");
        GridPane.setConstraints(listChoiceBox, 1, 1);

        // DatePickers for start and end dates
        DatePicker startDatePicker = new DatePicker();
        GridPane.setConstraints(startDatePicker, 1, 2);

        DatePicker endDatePicker = new DatePicker();
        GridPane.setConstraints(endDatePicker, 1, 3);

        // TextField for description
        TextField descriptionTextField = new TextField();
        descriptionTextField.setPromptText("Enter description");
        GridPane.setConstraints(descriptionTextField, 1, 4);

        // Buttons
        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 0, 5);

        Button cancelButton = new Button("Cancel");
        GridPane.setConstraints(cancelButton, 1, 5);

        // Add elements to grid
        getChildren().addAll(projectLabel, projectChoiceBox, listLabel, listChoiceBox,
                startDateLabel, startDatePicker, endDateLabel, endDatePicker,
                descriptionLabel, descriptionTextField, submitButton, cancelButton);

        // Styling
        setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10px;");
        submitButton.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white;");
        cancelButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
    }
}
