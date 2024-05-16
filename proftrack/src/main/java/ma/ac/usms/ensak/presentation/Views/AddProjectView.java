package ma.ac.usms.ensak.presentation.Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.util.Category;

public class AddProjectView {

    private TextField titleField;
    private TextField descriptionField;
    private TextField startDateField;
    private TextField endDateField;
    private TextField categoryField;
    private TextField typeField;
    private Button addButton;

    public AddProjectView() {
        initialize();
    }

    private void initialize() {
        Stage stage = new Stage();
        stage.setTitle("Add Project");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        // Add labels and fields
        grid.add(new Label("Title:"), 0, 0);
        titleField = new TextField();
        grid.add(titleField, 1, 0);

        grid.add(new Label("Description:"), 0, 1);
        descriptionField = new TextField();
        grid.add(descriptionField, 1, 1);

        // Add other fields similarly...

        // Add button
        addButton = new Button("Add");
        grid.add(addButton, 0, 6, 2, 1);

        Scene scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public Project getProjectFromFields() {
        String title = titleField.getText();
        String description = descriptionField.getText();
        // Extract other fields similarly...

        // Create and return Project object
        return new Project(title, description, null, null, Category.ACADEMIC, null, false);
    }

    public void setAddButtonAction(Runnable action) {
        addButton.setOnAction(event -> action.run());
    }
}
