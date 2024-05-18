package ma.ac.usms.ensak.presentation.Views.VBoxes;

import org.checkerframework.checker.units.qual.t;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ShowBox extends VBox {
    private VBox Today;
    private VBox List;
    private VBox Project;
    private VBox Completed;
    private Button addButton;
    private Button projectButton;
    private Button TodayButton;
    private Button filter;

    public ShowBox() {
        Today = new VBox();
        List = new VBox();
        Project = new VBox();
        Completed = new VBox();
        addButton = new Button();
        projectButton = new Button();
        // add button of Today
        TodayButton = new Button("Today",
                new ImageView("https://cdn-icons-png.flaticon.com/512/10875/10875695.png"));
        TodayButton.setStyle(
                "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 20px;");
        TodayButton.getGraphic().setStyle("-fx-fit-width: 20px; -fx-fit-height: 20px;");
        Today.getChildren().add(TodayButton);
        Today.setStyle("-fx-border-color: black; -fx-border-width: 0 0 1 0;");
        List.setStyle("-fx-border-color: black; -fx-border-width: 0 0 1 0;");
        getChildren().addAll(Today, List, Project, Completed);

    }

    public HBox createLabel(String text, Boolean isList) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 20px;");

        Image addImage = new Image(getClass().getResource("/Icons/add.png").toString());
        Button button = new Button("", new ImageView(addImage));
        button = new Button("", new ImageView(addImage));
        button.setStyle(
                "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 20px; -fx-padding: 0;");
        button.getGraphic().setStyle("-fx-fit-width: 20px; -fx-fit-height: 20px;");

        Image arrowDownImage = new Image(getClass().getResource("/Icons/filter.png").toString());
        filter = new Button("", new ImageView(arrowDownImage));
        filter.setStyle(
                "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 20px; -fx-padding: 0;");
        filter.getGraphic().setStyle("-fx-fit-width: 20px; -fx-fit-height: 20px;");
        HBox buttonsBox = new HBox();
            if (isList) {
                addButton = button;
                buttonsBox.getChildren().addAll(addButton);
            } else {
                projectButton = button;
                buttonsBox.getChildren().addAll(projectButton, filter);
            }
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);

        HBox stackPane = new HBox(label, buttonsBox);
        HBox.setHgrow(buttonsBox, Priority.ALWAYS); // This line makes buttonsBox grow to fill the space
        stackPane.setStyle("-fx-padding: 10 0 10 0; -fx-spacing: 100;");

        return stackPane;
    }

    public Button getToday() {
        return this.TodayButton;
    }

    public VBox getList() {
        return List;
    }

    public VBox getProject() {
        return Project;
    }

    public VBox getCompleted() {
        return Completed;
    }

    public Button getListButton() {
        return addButton;
    }

    public Button getProjectButton() {
        return projectButton;
    }

    public Button getFilterButton() {
        return filter;
    }
}
