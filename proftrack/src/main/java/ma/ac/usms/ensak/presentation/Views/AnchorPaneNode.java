package ma.ac.usms.ensak.presentation.Views;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.management.TaskManager;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// /**
//  * Create an anchor pane that can store additional data.
//  */
// public class AnchorPaneNode extends AnchorPane {

//     // Date associated with this pane
//     private LocalDate date;

//     /**
//      * Create a anchor pane node. Date is not assigned in the constructor.
//      * @param children children of the anchor pane
//      */
//     public AnchorPaneNode(Node... children) {
//         super(children);
//         // Add action handler for mouse clicked
//         this.setOnMouseClicked(e -> System.out.println("This pane's date is: " + date));
//     }

//     public LocalDate getDate() {
//         return date;
//     }

//     public void setDate(LocalDate date) {
//         this.date = date;
//     }
// }

public class AnchorPaneNode extends AnchorPane {
    private LocalDate date;
    private final Map<String, String> tasks = new HashMap<>(); // Store task title and color

    public AnchorPaneNode(Node... children) {
        super(children);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void addTask(String taskTitle, String idTask) {
        tasks.put(taskTitle, idTask);
        updateTasksDisplay();
    }

    private void updateTasksDisplay() {
        this.getChildren().clear();
        VBox vbox = new VBox(5);
        for (Map.Entry<String, String> entry : tasks.entrySet()) {
            String taskTitlString = entry.getKey();
            String idTask = entry.getValue();
            Button taskButton = new Button(taskTitlString);
            taskButton.setStyle("-fx-background-color: blue" +
                    "; -fx-text-fill: white;" +
                    " -fx-border-color: black;" +
                    " -fx-border-radius: 5;" +
                    " -fx-background-radius: 5;" +
                    " -fx-alignment: center;" +
                    " -fx-font-family: 'Arial';" +
                    " -fx-font-size: 14px;" +
                    " -fx-font-weight: bold;");

            // Search task by getIDtask

            taskButton.setOnAction(event -> {
                TaskManager taskmanager = new TaskManager();
                Task task = taskmanager.searchTaskById(idTask);
                showTaskDetails(taskTitlString, task.getDescription(), task.getStart_date(), task.getEnd_date());
            });
            vbox.getChildren().add(taskButton);
        }
        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        AnchorPane.setTopAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(scrollPane, 0.0);
        AnchorPane.setLeftAnchor(scrollPane, 0.0);
        AnchorPane.setRightAnchor(scrollPane, 0.0);
        this.getChildren().add(scrollPane);
    }

    private void showTaskDetails(String taskName, String description, Date startDate, Date endDate) {

        // Convert the Date start and end to a readable string
        String startDateString = startDate.toString();
        String endDateString = endDate.toString();

        // Create a new Stage and show the task details
        Stage stage = new Stage();
        stage.setTitle(taskName);

        Label nameLabel = new Label("Task: " + taskName);
        nameLabel.setTextFill(Color.BLACK);

        Label descriptionLabel = new Label("Description: " + description);
        descriptionLabel.setTextFill(Color.BLACK);

        Label startDateLabel = new Label("Start Date: " + startDateString);
        startDateLabel.setTextFill(Color.BLACK);

        Label endDateLabel = new Label("End Date: " + endDateString);
        endDateLabel.setTextFill(Color.BLACK);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(nameLabel, descriptionLabel, startDateLabel, endDateLabel);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

}