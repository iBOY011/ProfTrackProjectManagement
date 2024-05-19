package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.metier.management.DocumentManager;


public class DocumentController {
    private static DocumentManager documentManager = new DocumentManager();
    private static DocumentBoxController documentBox = new DocumentBoxController();

    public DocumentController() {
        deleteDocument();

    }

    public DocumentBoxController getDocumentBox() {
        return documentBox;
    }

    

    public void deleteDocument() {
        documentBox.getDocumentBox().getDeleteButton().setOnAction(e -> {
            documentManager.deleteDocument(null);
        });
    }

}
