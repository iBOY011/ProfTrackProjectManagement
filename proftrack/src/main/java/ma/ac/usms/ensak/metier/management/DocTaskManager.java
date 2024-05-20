package ma.ac.usms.ensak.metier.management;

import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocTask;
import ma.ac.usms.ensak.persistance.impl.DocTaskImpl;

public class DocTaskManager {

    /**
     * Creates a new document-task association.
     * 
     * @param idDocument The ID of the document.
     * @param idTask     The ID of the task.
     */
    public void createDocTask(String idDocument, String idTask) {
        DocTask docTask = new DocTask(idDocument, idTask);
        DocTaskImpl docTaskImpl = new DocTaskImpl();
        docTaskImpl.addDocTask(docTask);
    }

    /**
     * Removes the document-task association.
     * 
     * @param idDocument The ID of the document.
     * @param idTask     The ID of the task.
     */
    public void removeDocTask(String idDocument, String idTask) {
        DocTaskImpl docTaskImpl = new DocTaskImpl();
        docTaskImpl.deleteDocTask(idDocument, idTask);
    }

    /**
     * Removes all document-task associations for a specific document.
     * 
     * @param idDocument The ID of the document.
     * @throws IllegalArgumentException if the ID is null, empty, or blank.
     */
    public void removeDocTaskByDocument(String idDocument) {
        if (idDocument == null || idDocument.isEmpty() || idDocument.isBlank()) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            docTaskImpl.deleteDocTaskByDocument(idDocument);
        }
    }

    /**
     * Removes all document-task associations for a specific task.
     * 
     * @param idTask The ID of the task.
     * @throws IllegalArgumentException if the ID is null, empty, or blank.
     */
    public void removeDocTaskByTask(String idTask) {
        if (idTask == null || idTask.isEmpty() || idTask.isBlank()) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            docTaskImpl.deleteDocTaskByTask(idTask);
        }
    }

    /**
     * Removes all document-task associations.
     */
    public void removeAllDocTask() {
        DocTaskImpl docTaskImpl = new DocTaskImpl();
        docTaskImpl.deleteAllDocTask();
    }

    /**
     * Updates the document-task association.
     * 
     * @param idDocument The ID of the document.
     * @param idTask     The ID of the task.
     */
    public void updateDocTask(String idDocument, String idTask) {
        DocTask docTask = new DocTask(idDocument, idTask);
        DocTaskImpl docTaskImpl = new DocTaskImpl();
        docTaskImpl.updateDocTask(docTask);
    }

    /**
     * Searches for a specific document-task association.
     * 
     * @param idDocument The ID of the document.
     * @param idTask     The ID of the task.
     * @return The document-task association, or null if not found.
     */
    public DocTask searchDocTask(String idDocument, String idTask) {
        DocTaskImpl docTaskImpl = new DocTaskImpl();
        return docTaskImpl.getDocTask(idDocument, idTask);
    }

    /**
     * Searches for all document-task associations for a specific document.
     * 
     * @param idDocument The ID of the document.
     * @return A list of document-task associations, or an empty list if not found.
     * @throws IllegalArgumentException if the ID is null, empty, or blank.
     */
    public List<DocTask> searchDocTaskByDocument(String idDocument) {
        if (idDocument == null || idDocument.isEmpty() || idDocument.isBlank()) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            return docTaskImpl.getDocTaskByDocument(idDocument);
        }
    }

    /**
     * Searches for all document-task associations for a specific task.
     * 
     * @param idTask The ID of the task.
     * @return A list of document-task associations, or an empty list if not found.
     * @throws IllegalArgumentException if the ID is null, empty, or blank.
     */
    public List<DocTask> searchDocTaskByTask(String idTask) {
        if (idTask == null || idTask.isEmpty() || idTask.isBlank()) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            return docTaskImpl.getDocTaskByTask(idTask);
        }
    }

}
