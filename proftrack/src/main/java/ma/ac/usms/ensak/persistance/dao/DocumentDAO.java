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
    Document getDocumentById(int idDocument);
    void updateDocument(Document document);
    void deleteDocument(int idDocument);
    List<Document> getAllDocuments();
    List<Document> getDocumentsByProject(int idProjet);
    List<Document> searchDocumentsByKeyword(String keyword);
}
