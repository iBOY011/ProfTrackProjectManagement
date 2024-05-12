package ma.ac.usms.ensak.metier.management;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.persistance.impl.DocumentImpl;

/**
 * 
 */
public class DocumentManager {
    
    private ArrayList<Document> documents;
    private DocumentImpl documentImpl;

    public DocumentManager() {
        documents = new ArrayList<Document>();
        documentImpl = new DocumentImpl();
    }

    public void sort() {
        // sort the documents by date
        documents.sort((Document d1, Document d2) -> d1.getDateAdded().compareTo(d2.getDateAdded()));
    }

    // validate
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
        // path regex
        // if (!document.getPath().matches("^(?:[a-zA-Z]\\:|\\\\)\\\\[a-zA-Z0-9\\.]+(\\\\[a-zA-Z0-9\\.]+)*$")) {
        //     throw new IllegalArgumentException("The path is not valid.");
        // }
    }

    // add document
    public void createDocument(String description, String path, String id_project) {
        // create a new document
        Document document = new Document(description, path, id_project);
        // validate the document
        validate(document);
        // add the document to the database
        documentImpl.addDocument(document);
    }

    // update document
    public void updateDocument(Document document) {
        // validate the document
        validate(document);
        // update the document in the database
        documentImpl.updateDocument(document);
    }

    // delete document
    public void deleteDocument(String idDocument) {
        // check if the idDocument is not null
        if (idDocument == null) {
            throw new IllegalArgumentException("The id document cannot be null.");
        }
        // delete the document from the database
        documentImpl.deleteDocument(idDocument);
    }

    // get document by id
    public Document searchDocumentById(String idDocument) {
        // check if the idDocument is not null
        if (idDocument == null) {
            throw new IllegalArgumentException("The id document cannot be null.");
        }
        return documentImpl.getDocumentById(idDocument);
    }

    // get all documents
    public List<Document> ListAllDocuments() {
        return documentImpl.getAllDocuments();
    }

    // get documents by project
    public List<Document> ListDocumentsByProject(String idProjet) {
        return documentImpl.getDocumentsByProject(idProjet);
    }

}
