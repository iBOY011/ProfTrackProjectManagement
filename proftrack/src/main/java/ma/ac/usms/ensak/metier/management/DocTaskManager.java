package ma.ac.usms.ensak.metier.management;

import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocTask;
import ma.ac.usms.ensak.persistance.impl.DocTaskImpl;

public class DocTaskManager {

    public void createDocTask(String idDocument, String idTask) {
        if (!isValidateSyntax(idDocument, idTask)) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTask docTask = new DocTask(idDocument, idTask);
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            docTaskImpl.addDocTask(docTask);
        }

    }

    public void removeDocTask(String idDocument, String idTask) {
        if (!isValidateSyntax(idDocument, idTask)) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            docTaskImpl.deleteDocTask(idDocument, idTask);
        }
    }

    public void removeDocTaskByDocument(String idDocument) {
        if (idDocument == null || idDocument.isEmpty() || idDocument.isBlank()) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            docTaskImpl.deleteDocTaskByDocument(idDocument);
        }
    }

    public void removeDocTaskByTask(String idTask) {
        if (idTask == null || idTask.isEmpty() || idTask.isBlank()) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            docTaskImpl.deleteDocTaskByTask(idTask);
        }
    }

    public void removeAllDocTask() {
        DocTaskImpl docTaskImpl = new DocTaskImpl();
        docTaskImpl.deleteAllDocTask();
    }

    public void updateDocTask(String idDocument, String idTask) {
        if (!isValidateSyntax(idDocument, idTask)) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTask docTask = new DocTask(idDocument, idTask);
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            docTaskImpl.updateDocTask(docTask);
        }
    }

    private boolean isValidateSyntax(String idDocument, String idTask) {
        // if (idDocument == null || idDocument.isEmpty() || idDocument.isBlank()) {
        //     return false;
        // }
        // return (idTask == null || idTask.isEmpty() || idTask.isBlank());
        return true;
    }

    // Méthodes pour chercher les documents liés à une tâche ou vice versa
    public DocTask searchDocTask(String idDocument, String idTask) {
        if (!isValidateSyntax(idDocument, idTask)) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            return docTaskImpl.getDocTask(idDocument, idTask);
        }
    }

    public List<DocTask> searchDocTaskByDocument(String idDocument) {
        if (idDocument == null || idDocument.isEmpty() || idDocument.isBlank()) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            return docTaskImpl.getDocTaskByDocument(idDocument);
        }
    }

    public List<DocTask> searchDocTaskByTask(String idTask) {
        if (idTask == null || idTask.isEmpty() || idTask.isBlank()) {
            throw new IllegalArgumentException("Invalid syntax");
        } else {
            DocTaskImpl docTaskImpl = new DocTaskImpl();
            return docTaskImpl.getDocTaskByTask(idTask);
        }
    }

}
