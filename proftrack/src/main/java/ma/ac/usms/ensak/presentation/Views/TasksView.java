package ma.ac.usms.ensak.presentation.Views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.presentation.controller.HomeController;
import ma.ac.usms.ensak.presentation.controller.ShowBoxController;

public class TasksView extends VBox{
    Label headerLabel;
    Button arrowButton;
    ComboBox<String> filterComboBox;
    TextField addTask;
    Button informationButton;
    Label showTask;
    VBox listTasks;
    VBox listWorkSession;
    Button showWorkSession;

    public TasksView() {

        // creating a header container
        HBox header = new HBox();
        arrowButton = new Button("<");
        arrowButton.setOnAction(e ->
        HomeController.getTodayView().getShowBox().setVisible(!HomeController.getTodayView().getShowBox().isVisible()));
        arrowButton.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: black; -fx-font-size: 14px; -fx-cursor: hand;");
        headerLabel = new Label("");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #4CAF50;");
        // create filter buttin with image
        filterComboBox = new ComboBox<>();
        filterComboBox.getItems().addAll("All", "Completed", "Uncompleted");
        filterComboBox.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: black; -fx-font-size: 14px; -fx-cursor: hand;");

        // Create an invisible Region to add space
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Add the spacer to the HBox
        header.getChildren().addAll(arrowButton, headerLabel, spacer, filterComboBox);
        header.setStyle("-fx-spacing: 10px; -fx-alignment: center-left;");

        // create a VBox super container of the header
        VBox headerContainer = new VBox();
        // add Text feil to add tasks
        addTask = new TextField();
        addTask.setPromptText("Add a task ...");

        // Create
        Image image = new Image(getClass().getResource("/Icons/addTask.png").toString());
        informationButton = new Button("",new ImageView(image));
        informationButton.getGraphic().setStyle("-fx-fit-width: 25px; -fx-fit-height: 25px;");
        // Create a HBox to contain the TextField and the Button
        HBox addFeild = new HBox(addTask, informationButton);
        addFeild.setStyle("-fx-spacing: 15px; -fx-alignment: center;");

        headerContainer.getChildren().addAll(header, addFeild);
        // Set the spacing between each child of the VBox
        headerContainer.setSpacing(10);

        // Create a VBox to contain the list of tasks
        listTasks = new VBox();
        showTask = new Label();
        showTask.setStyle("-fx-background-color: transparent; -fx-text-fill: #000000; -fx-font-size: 24px;");
        listTasks.getChildren().add(showTask);
        // Add padding to move the VBox down
        listTasks.setPadding(new Insets(10, 0, 0, 5));

        // Create a VBox to contain the list of work sessions
        listWorkSession = new VBox();
        showWorkSession = new Button("Work Sessions:");
        showWorkSession.setStyle("-fx-background-color: transparent; -fx-text-fill: #000000; -fx-font-size: 24px;");
        listWorkSession.getChildren().add(showWorkSession);
        // Add padding to move the VBox down
        listWorkSession.setPadding(new Insets(10, 0, 0, 5));
        this.getChildren().addAll(headerContainer, listTasks, listWorkSession);

    }

    public Button getArrowButton() {
        return arrowButton;
    }

    public ComboBox<String> getFilterComboBox() {
        return filterComboBox;
    }

    public TextField getAddTask() {
        return addTask;
    }

    public Button getInformationButton() {
        return informationButton;
    }

    public VBox getListTask() {
        return listTasks;
    }

    public VBox getListWorkSession() {
        return listWorkSession;
    }
    
    public Label getShowTask() {
        return showTask;
    }
    
    public Button getShowWorkSession() {
        return showWorkSession;
    }

    public Label getHeaderLabel() {
        return headerLabel;
    }

    public void setVisibleListWorkSession(boolean b) {
        listWorkSession.setVisible(b);
    }
}
