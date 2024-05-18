package ma.ac.usms.ensak.presentation.Views.VBoxes;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.metier.POJO.Document;

public class DetailsBox extends VBox{
    private VBox descriptionBox;
    private  DocumentBox DocumentsBox;
    private WorkSessionBox WorkSessionBox;
    private Label descriptionArea;

    public DetailsBox() {
        descriptionBox = new VBox();
        DocumentsBox = new DocumentBox();
        WorkSessionBox = new WorkSessionBox();
        // desing descriptionBox
        Label descriptionLabel = new Label("Description:");
        descriptionLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: Arial;");
        descriptionArea = new Label();
        // set text to be in the top left corner
        descriptionArea.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        descriptionArea.setStyle("-fx-font-size: 15px; -fx-font-family: Arial; -fx-padding: 5;-fx-text-fill: black; -fx-background-color: white; -fx-wrap-text: true; -fx-text-alignment: left; -fx-underline: false; -fx-content-display: TOP;");
        descriptionArea.setPrefHeight(200);
        descriptionArea.setWrapText(true);
        descriptionArea.setMaxWidth(730);
        descriptionBox.getChildren().addAll(descriptionLabel, descriptionArea);
        // DocumentsBox.setVisible(false);
        getChildren().addAll(descriptionBox, DocumentsBox, WorkSessionBox);
    }

    public VBox getDescriptionBox() {
        return descriptionBox;
    }

    public DocumentBox getDocumentsBox() {
        return DocumentsBox;
    }

    public WorkSessionBox getWorkSessionBox() {
        return WorkSessionBox;
    }

    public Label getDescriptionArea() {
        return descriptionArea;
    }

    public Button getAddDocumentButton() {
        return DocumentsBox.getAddButton();
    }
    
    public Button getDeleteDocumentButton() {
        return DocumentsBox.getDeleteButton();
    }

    public ListView<Document> getDocumentList() {
        return DocumentsBox.getDocumentList();
    }

}