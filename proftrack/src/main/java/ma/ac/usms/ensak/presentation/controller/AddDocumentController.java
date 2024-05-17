package ma.ac.usms.ensak.presentation.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.management.DocumentManager;
import ma.ac.usms.ensak.presentation.Views.AddDocumentView;

public class AddDocumentController {
    private static DocumentManager documentManager = new DocumentManager();
    private static AddDocumentView addDocumentvView;

    public AddDocumentController() {
        addDocumentvView = new AddDocumentView();
        addDocument();
    }

    public boolean addDocument() {
        try {
            addDocumentvView.getAddButton().setOnAction(e -> {
                Document document = addDocumentvView.getDocumentFromFields();
                documentManager.createDocument(document.getDescription(), document.getPath(), document.getId_project());
                DetailsController.showDocument();
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public AddDocumentView getAddDocumentView() {
        return addDocumentvView;
    }

    public void createView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(addDocumentvView, 400, 200));
        stage.setTitle("Add Document");
        stage.setResizable(false);
        stage.show();
    }

}
