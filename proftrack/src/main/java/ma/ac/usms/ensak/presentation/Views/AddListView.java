package ma.ac.usms.ensak.presentation.Views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddListView extends BorderPane {

    private TextField nameField;
    private TextArea descriptionArea;
    private Button submitButton;
    private Button closeButton;

    public AddListView() {
        // Create the UI components
        Label nameLabel = new Label("List Name:");
        nameField = new TextField();

        Label descriptionLabel = new Label("Description:");
        descriptionArea = new TextArea();

        submitButton = new Button("Add List");
        submitButton.getStyleClass().add("addListViewButton");
        closeButton = new Button("Close");
        closeButton.getStyleClass().add("addListViewButton");

        // Layout using GridPane for the form
        GridPane formGrid = new GridPane();
        formGrid.getStyleClass().add("addListViewForm");
        formGrid.setPadding(new Insets(10));
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        formGrid.add(nameLabel, 0, 0);
        formGrid.add(nameField, 1, 0);
        formGrid.add(descriptionLabel, 0, 1);
        formGrid.add(descriptionArea, 1, 1);

        // HBox for the buttons
        HBox buttonBox = new HBox(10, submitButton, closeButton);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setSpacing(10);

        // Add form and buttons to BorderPane
        setCenter(formGrid);
        setBottom(buttonBox);

        // Add some padding to the BorderPane
        setPadding(new Insets(20));

        // Close button action
        closeButton.setOnAction(e -> closeWindow());
    }

    private boolean closeWindow() {
        // Assuming this view is in a separate stage, get the stage and close it
        try {
            Stage stage = (Stage) getScene().getWindow();
            stage.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextArea getDescriptionArea() {
        return descriptionArea;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public Button getCloseButton() {
        return closeButton;
    }
}
