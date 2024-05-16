package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.util.ListItem;

public class DocumentBox extends VBox{
    private Label documentLabel;
    private Button AddButton;
    private Button DeleteButton;
    private ListView<ListItem> documentList;

    public DocumentBox() {
        documentLabel = new Label("Documents:");
        documentLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: Arial;");
        AddButton = new Button("Add Document");
        DeleteButton = new Button("Delete Document");
        documentList = new ListView<ListItem>();
        HBox buttonsBox = new HBox(AddButton, DeleteButton);
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);
        HBox stackPane = new HBox(documentLabel, buttonsBox);
        HBox.setHgrow(buttonsBox, Priority.ALWAYS);
        getChildren().addAll(stackPane, documentList);
    }

    public Label getDocumentLabel() {
        return documentLabel;
    }

    public Button getAddButton() {
        return AddButton;
    }

    public Button getDeleteButton() {
        return DeleteButton;
    }
    
}
