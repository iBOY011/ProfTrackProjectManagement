package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.metier.management.DocumentManager;
import ma.ac.usms.ensak.exception.*;

public class DocumentController {
    private static DocumentManager documentManager = new DocumentManager();
    private static DocumentBoxController documentBox = new DocumentBoxController();

    /**
     * The DocumentController class is responsible for managing documents in the application.
     */
    public DocumentController() {
        deleteDocument();

    }

    public DocumentBoxController getDocumentBox() {
        return documentBox;
    }

    /**
     * Deletes a document from the document box.
     */
    public void deleteDocument() {
        documentBox.getDocumentBox().getDeleteButton().setOnAction(e -> {
            if (ConfirmationDialog.showConfirmationDialog("Are you sure you want to delete this document?")) {
                documentManager.deleteDocument(null);
                AlertHandler.showSuccessAlert("Document deleted successfully");
            } else {
                AlertHandler.showFailureAlert("Document deletion canceled");

            }
        });
    }

}
