package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.metier.POJO.WorkSession;

public class WorkSessionBox extends VBox{
    private Label WorkSessionLabel;
    private static Button AddButton = new Button("Add WorkSession");
    private static Button DeleteButton = new Button("Delete WorkSession");
    private ListView<WorkSession> WorkSessionList;

    public WorkSessionBox() {
        WorkSessionLabel = new Label("Work Sessions:");
        WorkSessionLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: Arial;");
        WorkSessionList = new ListView<WorkSession>();
        HBox buttonsBox = new HBox(AddButton, DeleteButton);
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);
        HBox stackPane = new HBox(WorkSessionLabel, buttonsBox);
        HBox.setHgrow(buttonsBox, Priority.ALWAYS);
        getChildren().addAll(stackPane, WorkSessionList);
    }

    public ListView<WorkSession> getWorkSessionList() {
        return WorkSessionList;
    }

    public Label getWorkSessionLabel() {
        return WorkSessionLabel;
    }

    public Button getAddButton() {
        return AddButton;
    }

    public Button getDeleteButton() {
        return DeleteButton;
    }

    
}
