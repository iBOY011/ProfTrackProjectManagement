package ma.ac.usms.ensak.metier.management;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocTask;
import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.persistance.impl.DocumentImpl;

/**
 * 
 */
/**
 * The DocumentManager class is responsible for managing documents in the system.
 */
public class DocumentManager {
    
    private ArrayList<Document> documents;
    private DocumentImpl documentImpl;

    /**
     * Constructs a new DocumentManager object.
     */
    public DocumentManager() {
        documents = new ArrayList<Document>();
        documentImpl = new DocumentImpl();
    }

    /**
     * Sorts the documents by date.
     */
    public void sort() {
        // sort the documents by date
        documents.sort((Document d1, Document d2) -> d1.getDateAdded().compareTo(d2.getDateAdded()));
    }

    /**
     * Validates a document.
     * 
     * @param document The document to validate.
     * @throws IllegalArgumentException If the document or any of its properties are null.
     */
    public void validate(Document document) {
        // check if the document is not null
        if (document == null) {
            throw new IllegalArgumentException("The document cannot be null.");
        }        
        // check if the description is not null
        if (document.getDescription() == null) {
            throw new IllegalArgumentException("The description cannot be null.");
        }
        // check if the dateAdded is not null
        if (document.getDateAdded() == null) {
            throw new IllegalArgumentException("The date added cannot be null.");
        }
        // check if the path is not null
        if (document.getPath() == null) {
            throw new IllegalArgumentException("The path cannot be null.");
        }
        // check if the id_project is not null
        if (document.getId_project() == null) {
            throw new IllegalArgumentException("The id project cannot be null.");
        }
    }

    /**
     * Creates a new document with the given description, path, and project ID.
     * 
     * @param description The description of the document.
     * @param path The path of the document.
     * @param id_project The ID of the project the document belongs to.
     */
    public void createDocument(String description, String path, String id_project) {
        // create a new document
        Document document = new Document(description, path, id_project);
        // validate the document
        validate(document);
        // add the document to the database
        documentImpl.addDocument(document);
    }

    /**
     * Updates an existing document.
     * 
     * @param document The document to update.
     */
    public void updateDocument(Document document) {
        // validate the document
        validate(document);
        // update the document in the database
        documentImpl.updateDocument(document);
    }

    /**
     * Deletes a document with the given ID.
     * 
     * @param idDocument The ID of the document to delete.
     * @throws IllegalArgumentException If the ID is null.
     */
    public void deleteDocument(String idDocument) {
        // check if the idDocument is not null
        if (idDocument == null) {
            throw new IllegalArgumentException("The id document cannot be null.");
        }
        // delete the document from the database
        documentImpl.deleteDocument(idDocument);
    }

    /**
     * Searches for a document with the given ID.
     * 
     * @param idDocument The ID of the document to search for.
     * @return The document with the given ID, or null if not found.
     * @throws IllegalArgumentException If the ID is null.
     */
    public Document searchDocumentById(String idDocument) {
        // check if the idDocument is not null
        if (idDocument == null) {
            throw new IllegalArgumentException("The id document cannot be null.");
        }
        return documentImpl.getDocumentById(idDocument);
    }

    /**
     * Retrieves a list of all documents.
     * 
     * @return A list of all documents.
     */
    public List<Document> ListAllDocuments() {
        return documentImpl.getAllDocuments();
    }

    /**
     * Retrieves a list of documents belonging to a specific project.
     * 
     * @param idProjet The ID of the project.
     * @return A list of documents belonging to the specified project.
     */
    public List<Document> ListDocumentsByProject(String idProjet) {
        return documentImpl.getDocumentsByProject(idProjet);
    }

    /**
     * Retrieves a list of documents associated with a specific task.
     * 
     * @param idTask The ID of the task.
     * @return A list of documents associated with the specified task.
     */
    public List<Document> ListDocumentsByTask(String idTask) {
        DocTaskManager docTaskManager = new DocTaskManager();
        List<DocTask> Ids = docTaskManager.searchDocTaskByTask(idTask);
        List<Document> documents = new ArrayList<Document>();
        for (DocTask docTask : Ids) {
            documents.add(documentImpl.getDocumentById(docTask.getIdDocument()));
        }
        return documents;
    }

    /**
     * Creates a new document.
     * 
     * @param document The document to create.
     */
    public void createDocument(Document document) {
        documentImpl.addDocument(document);
    }

}
