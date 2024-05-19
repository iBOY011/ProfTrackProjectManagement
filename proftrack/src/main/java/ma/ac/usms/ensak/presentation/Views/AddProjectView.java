package ma.ac.usms.ensak.presentation.Views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.util.Category;
import ma.ac.usms.ensak.util.Type;

import java.util.Date;

public class AddProjectView {

    private TextField titleField;
    private TextArea descriptionField;
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
        titleField.setPromptText("Enter project title");
        titleField.setPrefWidth(200);
        grid.add(titleField, 1, 0);

        grid.add(new Label("Description:"), 0, 1);
        descriptionField = new TextArea();
        descriptionField.setPromptText("Enter project description");
        descriptionField.setPrefWidth(200);
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

        // Add button and cancel button
        addButton = new Button("Add");
        grid.add(addButton, 0, 7, 2, 1);
        // Inside the initialize() method
        grid.setStyle("-fx-background-color: #f0f0f0;");

        // Add styles for individual components
        titleField.setStyle("-fx-background-color: white;");
        descriptionField.setStyle("-fx-background-color: white;");
        startDatePicker.setStyle("-fx-background-color: white;");
        endDatePicker.setStyle("-fx-background-color: white;");
        categoryComboBox.setStyle("-fx-background-color: white;");
        typeComboBox.setStyle("-fx-background-color: white;");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        // Optional: Add padding to the buttons
        GridPane.setMargin(addButton, new Insets(10, 0, 0, 0));

        // Add borders to the fields
        titleField.setStyle("-fx-border-color: #ccc;");
        descriptionField.setStyle("-fx-border-color: #ccc;");
        startDatePicker.setStyle("-fx-border-color: #ccc;");
        endDatePicker.setStyle("-fx-border-color: #ccc;");
        categoryComboBox.setStyle("-fx-border-color: #ccc;");
        typeComboBox.setStyle("-fx-border-color: #ccc;");

        GridPane.setMargin(titleField, new Insets(0, 0, 10, 0));
        GridPane.setMargin(descriptionField, new Insets(0, 0, 10, 0));
        GridPane.setMargin(startDatePicker, new Insets(0, 0, 10, 0));
        GridPane.setMargin(endDatePicker, new Insets(0, 0, 10, 0));
        GridPane.setMargin(categoryComboBox, new Insets(0, 0, 10, 0));
        GridPane.setMargin(typeComboBox, new Insets(0, 0, 10, 0));
        GridPane.setMargin(addButton, new Insets(0, 0, 10, 0));

        Scene scene = new Scene(grid, 400, 360);
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
