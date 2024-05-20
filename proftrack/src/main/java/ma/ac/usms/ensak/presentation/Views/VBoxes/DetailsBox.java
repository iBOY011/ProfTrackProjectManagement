package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.POJO.WorkSession;

/**
 * The DetailsBox class represents a custom JavaFX VBox that displays the details of a specific item.
 * It contains a description area, a document box, and a work session box.
 */
public class DetailsBox extends VBox{
    private VBox descriptionBox;
    private  DocumentBox DocumentsBox;
    private WorkSessionBox WorkSessionBox;
    private Label descriptionArea;

    /**
     * Constructs a new DetailsBox object.
     * Initializes the description box, document box, and work session box.
     * Sets the style and properties of the description area.
     */
    public DetailsBox() {
        this.setId("detailsBox");
        descriptionBox = new VBox();
        DocumentsBox = new DocumentBox();
        WorkSessionBox = new WorkSessionBox();
        Label descriptionLabel = new Label("Description:");
        descriptionLabel.setId("label");
        descriptionArea = new Label();
        descriptionArea.setStyle("-fx-font-size: 15px; -fx-font-family: Arial; -fx-padding: 5;-fx-text-fill: black; -fx-background-color: #F0F0F0; -fx-wrap-text: true; -fx-text-alignment: left; -fx-underline: false; -fx-content-display: TOP;");
        descriptionArea.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        descriptionArea.setId("descriptionArea");
        descriptionArea.setPrefHeight(200);
        descriptionArea.setWrapText(true);
        descriptionArea.setMaxWidth(730);
        descriptionBox.getChildren().addAll(descriptionLabel, descriptionArea);
        getChildren().addAll(descriptionBox, DocumentsBox, WorkSessionBox);
        this.setStyle("-fx-background-color: white; -fx-spacing: 10; -fx-border-color: black; -fx-border-width: 0 1 0 0;");
    }

    /**
     * Returns the description box.
     * @return the description box
     */
    public VBox getDescriptionBox() {
        return descriptionBox;
    }

    /**
     * Returns the document box.
     * @return the document box
     */
    public DocumentBox getDocumentsBox() {
        return DocumentsBox;
    }

    /**
     * Returns the work session box.
     * @return the work session box
     */
    public WorkSessionBox getWorkSessionBox() {
        return WorkSessionBox;
    }

    /**
     * Returns the description area label.
     * @return the description area label
     */
    public Label getDescriptionArea() {
        return descriptionArea;
    }

    /**
     * Returns the add document button from the document box.
     * @return the add document button
     */
    public Button getAddDocumentButton() {
        return DocumentsBox.getAddButton();
    }
    
    /**
     * Returns the delete document button from the document box.
     * @return the delete document button
     */
    public Button getDeleteDocumentButton() {
        return DocumentsBox.getDeleteButton();
    }

    /**
     * Returns the document list from the document box.
     * @return the document list
     */
    public ListView<Document> getDocumentList() {
        return DocumentsBox.getDocumentList();
    }

    /**
     * Returns the work session list from the work session box.
     * @return the work session list
     */
    public ListView<WorkSession> getWorkSessionList() {
        return WorkSessionBox.getWorkSessionList();
    }

}