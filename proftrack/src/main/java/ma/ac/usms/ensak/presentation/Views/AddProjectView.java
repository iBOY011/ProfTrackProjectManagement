package ma.ac.usms.ensak.presentation.Views;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.util.Category;
import ma.ac.usms.ensak.util.Type;

import java.util.Date;

public class AddProjectView {

    private TextField titleField;
    private TextField descriptionField;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    private ComboBox<Category> categoryComboBox;
    private ComboBox<Type> typeComboBox;
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

        grid.add(new Label("Start Date:"), 0, 2);
        startDatePicker = new DatePicker();
        grid.add(startDatePicker, 1, 2);

        grid.add(new Label("End Date:"), 0, 3);
        endDatePicker = new DatePicker();
        grid.add(endDatePicker, 1, 3);

        grid.add(new Label("Category:"), 0, 4);
        ObservableList<Category> categories = FXCollections.observableArrayList(Category.values());
        categoryComboBox = new ComboBox<>(categories);
        categoryComboBox.setValue(Category.ACADEMIC); // Set default value
        grid.add(categoryComboBox, 1, 4);

        grid.add(new Label("Type:"), 0, 5);
        ObservableList<Type> types = FXCollections.observableArrayList(Type.values());
        typeComboBox = new ComboBox<>(types);
        typeComboBox.setValue(Type.PFE); // Set default value
        grid.add(typeComboBox, 1, 5);

        // Add button
        addButton = new Button("Add");
        grid.add(addButton, 0, 7, 2, 1);

        Scene scene = new Scene(grid, 400, 350);
        stage.setScene(scene);
        stage.show();
    }

    public Project getProjectFromFields() {
        String title = titleField.getText();
        String description = descriptionField.getText();
        Date startDate = java.sql.Date.valueOf(startDatePicker.getValue());
        Date endDate = java.sql.Date.valueOf(endDatePicker.getValue());
        Category category = categoryComboBox.getValue();
        Type type = typeComboBox.getValue();
        // Extract other fields similarly...

        // Create and return Project object
        return new Project(title, description, startDate, endDate, category, type.name(), false);
    }

    public void setAddButtonAction(Runnable action) {
        addButton.setOnAction(event -> action.run());
    }

    public Button getAddButton() {
        return addButton;
    }

    public Stage getStage() {
        return (Stage) addButton.getScene().getWindow();
    }
}
