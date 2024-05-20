package ma.ac.usms.ensak.persistance.impl;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocSession;
import ma.ac.usms.ensak.persistance.dao.DocSessionDAO;
import ma.ac.usms.ensak.persistance.StorageFile;

public class DocSessionImpl implements DocSessionDAO {
    private final String DOCSESSION_FILE_PATH = "src\\main\\resources\\databases\\DocSession.json";

    /**
     * Adds a new document session to the database.
     * 
     * @param docSession The document session to be added.
     */
    @Override
    public void addDocSession(DocSession docSession) {
        List<DocSession> docSessions = getAllDocSessions();
        if (docSessions == null) {
            docSessions = new ArrayList<>();
        }
        docSessions.add(docSession);
        saveToJsonFile(docSessions, DOCSESSION_FILE_PATH);
    }

    /**
     * Retrieves a document session by its session ID.
     * 
     * @param idDocSession The session ID of the document session.
     * @return The document session with the specified session ID, or null if not found.
     */
    @Override
    public DocSession getDocSessionByIdSession(String idDocSession) {
        List<DocSession> docSessions = getAllDocSessions();
        for (DocSession docSession : docSessions) {
            if (docSession.getIdSession().equals(idDocSession)) {
                return docSession;
            }
        }
        return null;
    }

    /**
     * Retrieves a document session by its document ID.
     * 
     * @param idDocSession The document ID of the document session.
     * @return The document session with the specified document ID, or null if not found.
     */
    @Override
    public DocSession getDocSessionByIdDoc(String idDocSession) {
        List<DocSession> docSessions = getAllDocSessions();
        for (DocSession docSession : docSessions) {
            if (docSession.getIdDoc().equals(idDocSession)) {
                return docSession;
            }
        }
        return null;
    }

    /**
     * Updates a document session in the database.
     * 
     * @param docSession The updated document session.
     */
    @Override
    public void updateDocSession(DocSession docSession) {
        List<DocSession> docSessions = getAllDocSessions();
        for (int i = 0; i < docSessions.size(); i++) {
            DocSession docSession1 = docSessions.get(i);
            if (docSession1.getIdSession().equals(docSession.getIdSession())) {
                docSessions.set(i, docSession);
                break;
            }
        }
        saveToJsonFile(docSessions, DOCSESSION_FILE_PATH);
    }

    /**
     * Deletes a document session from the database.
     * 
     * @param idDocSession The session ID of the document session to be deleted.
     */
    @Override
    public void deleteDocSession(String idDocSession) {
        List<DocSession> docSessions = getAllDocSessions();
        docSessions.removeIf(docSession -> docSession.getIdSession().equals(idDocSession));
        saveToJsonFile(docSessions, DOCSESSION_FILE_PATH);
    }

    /**
     * Retrieves all document sessions from the database.
     * 
     * @return A list of all document sessions.
     */
    @Override
    public List<DocSession> getAllDocSessions() {
        return StorageFile.readObjectsFromJsonFile(DOCSESSION_FILE_PATH, DocSession.class);
    }

    private void saveToJsonFile(List<DocSession> docSessions, String filePath) {
        StorageFile.saveToJsonFile(docSessions, filePath);
    }
    
}
