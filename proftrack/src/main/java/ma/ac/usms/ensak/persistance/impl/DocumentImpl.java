
package ma.ac.usms.ensak.persistance.impl;
import java.util.ArrayList;
import java.util.List;
import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.persistance.dao.DocumentDAO;
import ma.ac.usms.ensak.persistance.StorageFile;




/**
 * Implementation of the DocumentDAO interface that provides methods to create, read, update, and delete documents.
 */
public class DocumentImpl implements DocumentDAO {
    private static final String DOCUMENT_FILE = "src/main/resources/databases/DocumentFile.json";

    /**
     * Creates a new document and saves it to the storage file.
     *
     * @param document The document to be created.
     */
    @Override
    public void addDocument(Document document) {
        StorageFile.saveToJsonFile(document, DOCUMENT_FILE);
    }

    /**
     * Reads a document with the specified ID from the storage file.
     *
     * @param idDocument The ID of the document to be read.
     * @return The document with the specified ID, or null if not found.
     */
    @Override
    public Document getDocumentById(String idDocument) {
        List<Document> documents = StorageFile.readObjectsFromJsonFile(DOCUMENT_FILE);
        for (Document d : documents) {
            if (d.getId() == idDocument) {
                return d;
            }
        }
        return null;
    }

    /**
     * Updates an existing document in the storage file.
     *
     * @param document The document to be updated.
     */
    @Override
    public void updateDocument(Document document) {
        List<Document> documents = StorageFile.readObjectsFromJsonFile(DOCUMENT_FILE);
        for (Document d : documents) {
            if (d.getId() == document.getId()) {
                d = document;
            }
        }
        StorageFile.saveListToJsonFile(documents, DOCUMENT_FILE);
    }

    /**
     * Deletes a document with the specified ID from the storage file.
     *
     * @param idDocument The ID of the document to be deleted.
     */
    @Override
    public void deleteDocument(String idDocument) {
        List<Document> documents = StorageFile.readObjectsFromJsonFile(DOCUMENT_FILE);

        for (Document d : documents) {
            if (d.getId() == idDocument) {
                documents.remove(d);
                break;
            }
        }
        StorageFile.saveListToJsonFile(documents, "src/main/resources/databases/DocumentFile.json");
    }

    /**
     * Retrieves all documents from the storage file.
     *
     * @return A list of all documents.
     */
    @Override
    public List<Document> getAllDocuments() {
        return StorageFile.readObjectsFromJsonFile("src/main/resources/databases/DocumentFile.json");
    }

    /**
     * Retrieves all documents associated with a specific project from the storage file.
     *
     * @param idProjet The ID of the project.
     * @return A list of documents associated with the specified project.
     */
    @Override
    public List<Document> getDocumentsByProject(String idProjet) {
        List<Document> documents = StorageFile.readObjectsFromJsonFile("src/main/resources/databases/DocumentFile.json");
        List<Document> documentsByProject = new ArrayList<>();
        for (Document d : documents) {
            if (d.getId_project() == idProjet) {
                documentsByProject.add(d);
            }
        }
        return documentsByProject;
    }

    /**
     * Searches for documents containing a specific keyword in their description.
     *
     * @param keyword The keyword to search for.
     * @return A list of documents containing the specified keyword in their description.
     */
    @Override
    public List<Document> searchDocumentsByKeyword(String keyword) {
        List<Document> documents = StorageFile.readObjectsFromJsonFile("src/main/resources/databases/DocumentFile.json");
        List<Document> documentsByKeyword = new ArrayList<>();
        for (Document d : documents) {
            if (d.getDescription().contains(keyword)) {
                documentsByKeyword.add(d);
            }
        }
        return documentsByKeyword;
    }
}
