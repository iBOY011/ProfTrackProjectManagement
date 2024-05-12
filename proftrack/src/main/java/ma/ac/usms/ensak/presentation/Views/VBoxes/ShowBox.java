package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import ma.ac.usms.ensak.metier.management.ListToDoManager;

public class ShowBox extends VBox {
    private VBox Today;
    private VBox List;
    private VBox Project;
    private VBox Completed;

    public ShowBox() {
        Today = new VBox();
        List = new VBox();
        Project = new VBox();
        Completed = new VBox();
        // add button of Today
        Button TodayButton = new Button("Today",
                new ImageView("https://cdn-icons-png.flaticon.com/512/10875/10875695.png"));
        TodayButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 20px;");
        TodayButton.getGraphic().setStyle("-fx-fit-width: 20px; -fx-fit-height: 20px;");
        Today.getChildren().add(TodayButton);
        Today.setStyle("-fx-border-color: black; -fx-border-width: 0 0 1 0;");
        // add button of List
        Label ListLabel = new Label("List",
                new ImageView("https://cdn-icons-png.flaticon.com/512/10875/10875695.png"));
                ListLabel.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 20px;");
                ListLabel.getGraphic().setStyle("-fx-fit-width: 20px; -fx-fit-height: 20px;");
        // add button of each list exist in the database
        List.getChildren().add(ListLabel);
        ListToDoManager listToDoManager = new ListToDoManager();
        listToDoManager.listListToDo().forEach(listToDo -> {
            Button button = new Button(listToDo.getTitle());
            button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 20px;");
            List.getChildren().add(button);
        });
        List.setStyle("-fx-border-color: black; -fx-border-width: 0 0 1 0;");
        getChildren().addAll(Today, List, Project, Completed);

    }
}
