package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TodayBox extends VBox {
    Button arrowButton;
    ComboBox<String> filterComboBox;
    TextField addTask;
    Button informationButton;
    Button addButton;
    Button showListOfToday;
    VBox listToday;

    public TodayBox() {

        // creating a header container
        HBox header = new HBox();
        arrowButton = new Button("<");
        arrowButton.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: black; -fx-font-size: 14px; -fx-cursor: hand;");
        Label headerLabel = new Label("Today");
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
        addTask.setPromptText("+Add a task on \"Today\"");

        // Create
        informationButton = new Button("+");
        addButton = new Button("Add");

        // Create a HBox to contain the TextField and the Button
        HBox addFeild = new HBox(addTask, informationButton, addButton);
        addFeild.setStyle("-fx-spacing: 15px; -fx-alignment: center;");

        headerContainer.getChildren().addAll(header, addFeild);
        // Set the spacing between each child of the VBox
        headerContainer.setSpacing(10);

        listToday = new VBox();
        showListOfToday = new Button("List of Today");
        showListOfToday.setStyle("-fx-background-color: transparent; -fx-text-fill: #000000; -fx-font-size: 24px;");
        listToday.getChildren().add(showListOfToday);
        // Add padding to move the VBox down
        listToday.setPadding(new Insets(10, 0, 0, 5)); // Top, Right, Bottom, Left
        

        this.getChildren().addAll(headerContainer, listToday);

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

    public Button getAddButton() {
        return addButton;
    }

    public Button getShowListOfToday() {
        return showListOfToday;
    }

    public VBox getListToday() {
        return listToday;
    }
}