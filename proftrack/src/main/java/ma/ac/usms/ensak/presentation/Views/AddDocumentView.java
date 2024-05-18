package ma.ac.usms.ensak.presentation.Views;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.presentation.controller.DetailsController;
import ma.ac.usms.ensak.presentation.controller.ShowBoxController;

import java.io.File;

public class AddDocumentView extends VBox {

    private TextField descriptionField;
    private TextField pathField;
    private Button addButton;
    private Button chooseFileButton;
    private Button closeButton;

    public AddDocumentView() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
    
        // Add labels and fields for document details
        grid.add(new Label("Description:"), 0, 0);
        descriptionField = new TextField();
        // make the description field take up the remaining space
        descriptionField.prefWidthProperty().bind(grid.heightProperty().subtract(20));
        grid.add(descriptionField, 1, 0);
    
        grid.add(new Label("Path:"), 0, 1);
        pathField = new TextField();
        // make the path can be edited
        pathField.setEditable(false);
        grid.add(pathField, 1, 1);
    
        chooseFileButton = new Button("Choose File");
        grid.add(chooseFileButton, 2, 1);
    
        // Add button
        addButton = new Button("Add");
        grid.add(addButton, 0, 3, 2, 1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.add(closeButton = new Button("Close"), 2, 3);
    
        // Set button actions
        setButtonActions();
        closeButton.setOnAction(e -> closeWindow());

        getChildren().add(grid);
    }


    private void setButtonActions() {
        chooseFileButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Document");
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                pathField.setText(selectedFile.getAbsolutePath());
            }
            // Set the path field to the selected file's path
            if (selectedFile != null) {
                pathField.setText(selectedFile.getAbsolutePath());
            }
        });
    }

    public Document getDocumentFromFields() {
        String description = descriptionField.getText();
        String path = pathField.getText();
        
        // Create and return Document object
        if (description.isEmpty() || path.isEmpty()) {
            return null; 
        }
        return new Document(description, path, ShowBoxController.getIdProjectSelected());
    }

    public Button getAddButton() {
        return addButton;
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

}
