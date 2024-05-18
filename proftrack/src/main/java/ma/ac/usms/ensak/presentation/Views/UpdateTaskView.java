package ma.ac.usms.ensak.presentation.Views;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import ma.ac.usms.ensak.util.Status;

public class UpdateTaskView extends GridPane {
    private TextField titleInput;
    private TextArea descriptionInput;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    private ComboBox<Status> statusComboBox;
    private Button updateButton;
    

    public UpdateTaskView() {
        setPadding(new Insets(10, 10, 10, 10));
        setVgap(8);
        setHgap(10);
        // Title
        Label titleLabel = new Label("Title:");
        GridPane.setConstraints(titleLabel, 0, 1);
        titleInput = new TextField();
        GridPane.setConstraints(titleInput, 1, 1);

        // Description
        Label descriptionLabel = new Label("Description:");
        GridPane.setConstraints(descriptionLabel, 0, 2);
        descriptionInput = new TextArea();
        GridPane.setConstraints(descriptionInput, 1, 2);

        // Start Date
        Label startDateLabel = new Label("Start Date:");
        GridPane.setConstraints(startDateLabel, 0, 3);
        startDatePicker = new DatePicker();
        GridPane.setConstraints(startDatePicker, 1, 3);

        // End Date
        Label endDateLabel = new Label("End Date:");
        GridPane.setConstraints(endDateLabel, 0, 4);
        endDatePicker = new DatePicker();
        GridPane.setConstraints(endDatePicker, 1, 4);

        // Status
        Label statusLabel = new Label("Status:");
        GridPane.setConstraints(statusLabel, 0, 5);
        statusComboBox = new ComboBox<>();
        statusComboBox.getItems().setAll(Status.values());
        GridPane.setConstraints(statusComboBox, 1, 5);

        // Update Button
        updateButton = new Button("Update Task");
        GridPane.setConstraints(updateButton, 1, 6);

        getChildren().addAll(titleLabel, titleInput, descriptionLabel, descriptionInput, startDateLabel, startDatePicker, endDateLabel, endDatePicker, statusLabel, statusComboBox, updateButton);

    }
    
    public TextField getTitleInput() {
        return titleInput;
    }

    public TextArea getDescriptionInput() {
        return descriptionInput;
    }

    public DatePicker getStartDatePicker() {
        return startDatePicker;
    }

    public DatePicker getEndDatePicker() {
        return endDatePicker;
    }

    public ComboBox<Status> getStatusComboBox() {
        return statusComboBox;
    }

    public Button getUpdateButton() {
        return updateButton;
    }
}
