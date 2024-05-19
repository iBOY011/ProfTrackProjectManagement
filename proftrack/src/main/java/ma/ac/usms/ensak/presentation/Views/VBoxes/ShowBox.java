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
    private Button addListButton;
    private Button addProjectButton;
    private Button TodayButton;
    private Button filter;

    public ShowBox() {
        this.setId("showbox");
        Today = new VBox();
        List = new VBox();
        Project = new VBox();
        Completed = new VBox();
        addListButton = new Button();
        addProjectButton = new Button();
        // add button of Today
        TodayButton = new Button("Today",
                new ImageView("https://cdn-icons-png.flaticon.com/512/10875/10875695.png"));
        TodayButton.setStyle(
                "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 20px; -fx-padding: 0; -fx-text-fill: black; -fx-font-weight: bold;");
        TodayButton.getGraphic().setStyle("-fx-fit-width: 20px; -fx-fit-height: 20px;");
        Today.getChildren().add(TodayButton);
        Today.setStyle("-fx-border-color: black; -fx-border-width: 0 0 1 0; -fx-background-color: white;");
        List.setStyle("-fx-border-color: black; -fx-border-width: 0 0 1 0; -fx-background-color: #cbe2ff;");
        Project.setStyle("-fx-border-color: black; -fx-border-width: 0 0 1 0; -fx-background-color: #cbe2ff;");
        getChildren().addAll(Today, List, Project, Completed);
        this.setStyle("-fx-spacing: 10; -fx-border-color: black; -fx-border-width: 0 1 0 0; -fx-background-color: #cbe2ff;");

    }

    public HBox createLabel(String text, Boolean isList) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 20px;");
        label.setId("label");

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
            addListButton = button;
            buttonsBox.getChildren().addAll(addListButton);
        } else {
            addProjectButton = button;
            buttonsBox.getChildren().addAll(addProjectButton, filter);
        }
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);

        HBox stackPane = new HBox(label, buttonsBox);
        HBox.setHgrow(buttonsBox, Priority.ALWAYS); // This line makes buttonsBox grow to fill the space
        stackPane.setStyle("-fx-padding: 10 0 10 0; -fx-spacing: 50;");

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
        return addListButton;
    }

    public Button getaddProjectButton() {
        return addProjectButton;
    }

    public Button getFilterButton() {
        return filter;
    }
}
