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
    ComboBox<String> filterComboBox;
    TextField addTask;
    Button informationButton;
    Button showListOfToday;
    VBox listToday;
    VBox projectToday;
    Button showProjectOfToday;

    public TodayBox() {
        this.setId("todayBox");

        // creating a header container
        HBox header = new HBox();
        Label headerLabel = new Label("Today");
        headerLabel.setStyle(
                "-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: black; -fx-padding: 0 0 0 5; -fx-font-family: 'Arial';");
        // create filter buttin with image
        filterComboBox = new ComboBox<>();
        filterComboBox.getItems().addAll("All", "Completed", "Uncompleted");
        filterComboBox.setStyle(
                "-fx-background-color: transparent; -fx-text-fill: black; -fx-font-size: 14px; -fx-cursor: hand;");

        // Create an invisible Region to add space
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Add the spacer to the HBox
        header.getChildren().addAll(headerLabel, spacer, filterComboBox);
        header.setStyle(
                "-fx-spacing: 10px; -fx-alignment: center-left; -fx-background-color: white;");

        // create a VBox super container of the header
        VBox headerContainer = new VBox();
        // add Text feil to add tasks
        addTask = new TextField();
        addTask.setPromptText("+Add a task on \"Today\"");
        addTask.setStyle("-fx-background-color: white; -fx-border-color: black;");

        // Create
        informationButton = new Button("+");
        informationButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        // Create a HBox to contain the TextField and the Button
        HBox addFeild = new HBox(addTask, informationButton);
        addFeild.setStyle("-fx-spacing: 15px; -fx-alignment: center; -fx-background-color: white; -fx-padding: 5;");

        headerContainer.getChildren().addAll(header, addFeild);
        // Set the spacing between each child of the VBox
        headerContainer.setSpacing(10);

        listToday = new VBox();
        showListOfToday = new Button("List of Today");
        showListOfToday.setStyle("-fx-background-color: transparent; -fx-text-fill: #04ECFF; -fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Arial';");
        listToday.getChildren().add(showListOfToday);
        // Add padding to move the VBox down
        listToday.setPadding(new Insets(10, 0, 0, 5)); // Top, Right, Bottom, Left

        // all i did for showing the tasks of lists , iwant to di it for projects
        projectToday = new VBox();
        showProjectOfToday = new Button("Project of Today");
        showProjectOfToday.setStyle("-fx-background-color: transparent; -fx-text-fill: #04ECFF; -fx-font-size: 24px; -fx-font-weight: bold; -fx-font-family: 'Arial';");
        projectToday.getChildren().add(showProjectOfToday);
        // Add padding to move the VBox down
        projectToday.setPadding(new Insets(10, 0, 0, 5)); // Top, Right, Bottom, Left
        addTask.setId("addTask");
        filterComboBox.setId("filterComboBox");
        informationButton.setId("informationButton");
        showListOfToday.setId("showListOfToday");

        this.getChildren().addAll(headerContainer, listToday, projectToday);
        this.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 0 1 0 0;");

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

    public Button getShowListOfToday() {
        return showListOfToday;
    }

    public VBox getListToday() {
        return listToday;
    }

    public VBox getProjectToday() {
        return projectToday;
    }

    public Button getShowProjectOfToday() {
        return showProjectOfToday;
    }
}