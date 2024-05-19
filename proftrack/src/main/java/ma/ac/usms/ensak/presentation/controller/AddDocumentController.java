package ma.ac.usms.ensak.presentation.controller;


import org.checkerframework.checker.units.qual.A;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.management.DocTaskManager;
import ma.ac.usms.ensak.metier.management.DocumentManager;
import ma.ac.usms.ensak.presentation.Views.AddDocumentView;
import ma.ac.usms.ensak.metier.POJO.Task;

public class AddDocumentController {
    private static DocumentManager documentManager = new DocumentManager();
    private static AddDocumentView addDocumentvView;

    public AddDocumentController() {
        addDocumentvView = new AddDocumentView();
    }

    public static boolean addDocument() {
        try {
            addDocumentvView.getAddButton().setOnAction(e -> {
                Document document = addDocumentvView.getDocumentFromFields();
                documentManager.createDocument(document.getDescription(), document.getPath(), document.getId_project());
                DetailsController.showDocument(true, null);
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void addDocTask(Task task) {
        AddDocumentController addDocumentController = new AddDocumentController();
        AddDocumentView addDocumentvView = addDocumentController.getAddDocumentView();
        addDocumentvView.getAddButton().setOnAction(e -> {
            Document document = addDocumentvView.getDocumentFromFields();
            documentManager.createDocument(document);
            DocTaskManager docTaskManager = new DocTaskManager();
            docTaskManager.createDocTask(document.getId(), task.getId());
            DetailsController.showDocument(false, task);
        });
    }

    public AddDocumentView getAddDocumentView() {
        return addDocumentvView;
    }

    public void createView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(addDocumentvView, 400, 200));
        stage.getScene().getStylesheets().add("/Css/Home.css");
        stage.setTitle("Add Document");
        stage.setResizable(false);
        stage.show();
    }

}
