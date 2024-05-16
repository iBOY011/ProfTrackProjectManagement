package ma.ac.usms.ensak.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import ma.ac.usms.ensak.metier.management.DocumentManager;
import ma.ac.usms.ensak.presentation.Views.VBoxes.DocumentBox;
import ma.ac.usms.ensak.util.ListItem;

public class DocumentController {
    private static DocumentManager documentManager = new DocumentManager();
    private static DocumentBox documentBox = new DocumentBox();

    public DocumentController() {

        addDocument();
        deleteDocument();

    }

    public DocumentBox getDocumentBox() {
        return documentBox;
    }

    public void showDocument(ListView<ListItem> documentList, String idTask) {
        documentList.getItems().clear();
        ObservableList<ListItem> items = FXCollections.observableArrayList();
        documentManager.ListDocumentsByTask(idTask).forEach(document -> {
            ListItem listItem = new ListItem(document.getId(), document.getTitle());
            items.add(listItem);
        });
        documentList.setItems(items);
    }

    public void addDocument() {
        documentBox.getAddButton().setOnAction(e -> {
            AddDocumentController addDocumentController = new AddDocumentController();
            addDocumentController.createView();
        });
    }

    public void deleteDocument() {
        documentBox.getDeleteButton().setOnAction(e -> {
            documentManager.deleteDocument(null);
        });
    }
}
