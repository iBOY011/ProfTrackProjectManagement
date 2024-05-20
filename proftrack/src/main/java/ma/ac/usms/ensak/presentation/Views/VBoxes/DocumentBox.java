package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.metier.POJO.Document;

/**
 * A custom JavaFX VBox that represents a document box.
 */
public class DocumentBox extends VBox {
    private Label documentLabel;
    private static Button AddButton = new Button("Add");
    private static Button DeleteButton = new Button("Delete");
    private ListView<Document> documentList;

    /**
     * Constructs a new DocumentBox.
     */
    public DocumentBox() {
        documentLabel = new Label("Documents:");
        documentLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: Arial;");
        documentList = new ListView<Document>();
        documentList.setStyle("-fx-font-size: 15px; -fx-font-family: serif ; -fx-padding: 5;-fx-text-fill: black; -fx-background-color: white; -fx-wrap-text: true; -fx-text-alignment: left; -fx-underline: false; -fx-content-display: TOP;");
        HBox buttonsBox = new HBox(AddButton, DeleteButton);
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);
        HBox stackPane = new HBox(documentLabel, buttonsBox);
        HBox.setHgrow(buttonsBox, Priority.ALWAYS);
        documentList.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1 1 1 1;");
        getChildren().addAll(stackPane, documentList);
        this.setPrefHeight(200);
    }

    /**
     * Returns the ListView of documents.
     * 
     * @return the ListView of documents
     */
    public ListView<Document> getDocumentList() {
        return documentList;
    }

    /**
     * Returns the label for the document box.
     * 
     * @return the label for the document box
     */
    public Label getDocumentLabel() {
        return documentLabel;
    }

    /**
     * Returns the Add button.
     * 
     * @return the Add button
     */
    public Button getAddButton() {
        return AddButton;
    }

    /**
     * Returns the Delete button.
     * 
     * @return the Delete button
     */
    public Button getDeleteButton() {
        return DeleteButton;
    }

    /**
     * Returns the ListView of documents.
     * 
     * @return the ListView of documents
     */
    public ListView<Document> getListView() {
        return documentList;
    }
}
