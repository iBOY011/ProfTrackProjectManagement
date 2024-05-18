package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.metier.management.DocumentManager;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.VBoxes.DetailsBox;

import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.units.qual.t;

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

    public static void showDetails(String id, Boolean isList , Boolean isTask) {
        String desc = "";
        if (isList) {
            desc = listToDoManager.searchListeToDoById(id).getDescription();
        } else if (isTask) {
            desc = taskManager.searchTaskById(id).getDescription();
        } else {
            desc = projectManager.searchProjectById(id).getDescription();
        }
        detailsBox.getDescriptionArea().setText(desc);
    }


    public static void addDocument(Boolean isProject , Task task) {
        if (isProject) {
            detailsBox.getAddDocumentButton().setOnAction(e -> {
                AddDocumentController addDocumentController = new AddDocumentController();
                addDocumentController.addDocument();
                addDocumentController.createView();
            });
        } else {
            detailsBox.getAddDocumentButton().setOnAction(e -> {
                AddDocumentController addDocumentController = new AddDocumentController();
                addDocumentController.addDocTask(task);
                addDocumentController.createView();
            });
        }
    }
    public static void showDocument(Boolean isProject , Task task) {
        List<Document> documents = new ArrayList<>();
        if (isProject) {
            documentManager.ListDocumentsByProject(ShowBoxController.getIdProjectSelected()).forEach(doc -> {
                documents.add(doc);
            });
        } else {
            documentManager.ListDocumentsByTask(task.getId()).forEach(doc -> {
                documents.add(doc);
            });
            
        }


        ObservableList<Document> observableDocuments = FXCollections.observableArrayList(documents);
        detailsBox.getDocumentList().setItems(observableDocuments);
        addDocument(isProject, task);
        openDocument();
        deleteDocument(isProject, task);
        
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

    public static void deleteDocument(Boolean isProject , Task task) {
        detailsBox.getDeleteDocumentButton().setOnAction(e -> {
            Document document = detailsBox.getDocumentList().getSelectionModel().getSelectedItem();
            documentManager.deleteDocument(document.getId());
            showDocument(isProject, task);
        });
    }

    public static void DisableDocumentBox(Boolean flag) {
        detailsBox.getDocumentsBox().setVisible(!flag);
    }
}
