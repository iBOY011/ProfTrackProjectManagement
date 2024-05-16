package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.presentation.controller.DocumentController;

public class DetailsBox extends VBox{
    private VBox descriptionBox;
    private VBox DocumentsBox;
    private VBox WorkSessionBox;
    private Label descriptionArea;

    public DetailsBox() {
        DocumentController d = new DocumentController();
        descriptionBox = new VBox();
        DocumentsBox = d.getDocumentBox();
        WorkSessionBox = new VBox();
        // desing descriptionBox
        Label descriptionLabel = new Label("Description:");
        descriptionLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-font-family: Arial;");
        descriptionArea = new Label();
        descriptionArea.setStyle("-fx-font-size: 15px; -fx-font-family: Arial; -fx-padding: 5;-fx-text-fill: black; -fx-background-color: white; -fx-wrap-text: true; -fx-text-alignment: left; -fx-underline: false; -fx-content-display: TOP;");
        descriptionArea.setPrefHeight(200);
        descriptionArea.setWrapText(true);
        descriptionArea.setMaxWidth(730);
        descriptionBox.getChildren().addAll(descriptionLabel, descriptionArea);
        getChildren().addAll(descriptionBox, DocumentsBox, WorkSessionBox);
    }

    public VBox getDescriptionBox() {
        return descriptionBox;
    }

    public VBox getDocumentsBox() {
        return DocumentsBox;
    }

    public VBox getWorkSessionBox() {
        return WorkSessionBox;
    }

    public Label getDescriptionArea() {
        return descriptionArea;
    }
    
}
