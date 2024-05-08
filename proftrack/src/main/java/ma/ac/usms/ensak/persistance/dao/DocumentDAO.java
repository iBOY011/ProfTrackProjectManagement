/**
 * 
 */
package ma.ac.usms.ensak.persistance.dao;

/**
 * 
 */
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Document;


public interface DocumentDAO {
    void addDocument(Document document);
    Document getDocumentById(String idDocument);
    void updateDocument(Document document);
    void deleteDocument(String idDocument);
    List<Document> getAllDocuments();
    List<Document> getDocumentsByProject(String idProjet);
    List<Document> searchDocumentsByKeyword(String keyword);
}
