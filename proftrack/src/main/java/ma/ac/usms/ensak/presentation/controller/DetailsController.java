package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.metier.management.DocumentManager;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.VBoxes.DetailsBox;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DetailsController {
    private static TaskManager taskManager = new TaskManager();
    private static ListToDoManager listToDoManager = new ListToDoManager();
    private static ProjectManager projectManager = new ProjectManager();
    private static DocumentManager documentManager = new DocumentManager();
    private static DetailsBox detailsBox = new DetailsBox();

    public DetailsController() {        

    }

    public DetailsBox getDetailsBox() {
        return detailsBox;
    }

    public static void showDetails(String id, Boolean isList) {
        String desc = "";
        if (isList) {
            desc = listToDoManager.searchListeToDoById(id).getDescription();
        } else {
            desc = projectManager.searchProjectById(id).getDescription();
        }
        detailsBox.getDescriptionArea().setText(desc);
    }


    public static void addDocument() {
        detailsBox.getAddDocumentButton().setOnAction(e -> {
            AddDocumentController addDocumentController = new AddDocumentController();
            addDocumentController.createView();
        });
    }
    public static void showDocument() {
        List<Document> documents = new ArrayList<>();

        documentManager.ListDocumentsByProject(ShowBoxController.getIdProjectSelected()).forEach(doc -> {
            documents.add(doc);
        });

        ObservableList<Document> observableDocuments = FXCollections.observableArrayList(documents);
        detailsBox.getDocumentList().setItems(observableDocuments);
        addDocument();
        openDocument();
        deleteDocument();
        
    }

    private static void openDocument() {
        detailsBox.getDocumentList().setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {  // Check for double-click
                Document document = detailsBox.getDocumentList().getSelectionModel().getSelectedItem();
                if (document != null) {
                    // open document by path
                    String documentPath = documentManager.searchDocumentById(document.getId()).getPath();
                    try {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + documentPath);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public static void deleteDocument() {
        detailsBox.getDeleteDocumentButton().setOnAction(e -> {
            Document document = detailsBox.getDocumentList().getSelectionModel().getSelectedItem();
            documentManager.deleteDocument(document.getId());
            showDocument();
        });
    }

    public static void DisableDocumentBox(Boolean flag) {
        detailsBox.getDocumentsBox().setVisible(!flag);
    }
}
