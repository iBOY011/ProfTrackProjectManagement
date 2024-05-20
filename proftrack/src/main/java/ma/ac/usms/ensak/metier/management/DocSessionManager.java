package ma.ac.usms.ensak.metier.management;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocSession;
import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.persistance.impl.DocSessionImpl;

/**
 * The `DocSessionManager` class is responsible for managing document sessions.
 * It provides methods to create, update, delete, and retrieve document sessions.
 */
public class DocSessionManager {
    private DocSessionImpl DMI;
    private List<DocSession> docSessions;

    /**
     * Constructs a new `DocSessionManager` object.
     * Initializes the list of document sessions and the `DocSessionImpl` instance.
     */
    public DocSessionManager() {
        this.docSessions = new ArrayList<DocSession>();
        this.DMI = new DocSessionImpl();
    }

    /**
     * Validates a document session.
     * Throws an exception if the document session is null or if the document ID or session ID is null.
     * 
     * @param docSession The document session to validate.
     * @throws IllegalArgumentException If the document session is null or if the document ID or session ID is null.
     */
    public void validate(DocSession docSession) {
        if (docSession == null) {
            throw new IllegalArgumentException("The document session must not be null.");
        }
        if (docSession.getIdDoc() == null || docSession.getIdSession() == null) {
            throw new IllegalArgumentException("The document ID and the session ID must not be null.");
        }
    }

    /**
     * Creates a new document session.
     * 
     * @param ws The work session associated with the document session.
     * @param doc The document associated with the document session.
     */
    public void createDocSession(WorkSession ws, Document doc) {
        DocSession docSession = new DocSession();
        docSession.setIdDoc(doc.getId());
        docSession.setIdSession(ws.getId());
        validate(docSession);
        DMI.addDocSession(docSession);
    }

    /**
     * Updates an existing document session.
     * 
     * @param docSession The document session to update.
     */
    public void updateDocSession(DocSession docSession) {
        validate(docSession);
        DMI.updateDocSession(docSession);
    }

    /**
     * Deletes a document session by its ID.
     * 
     * @param idDocSession The ID of the document session to delete.
     * @throws IllegalArgumentException If the ID of the document session is null.
     */
    public void deleteDocSession(String idDocSession) {
        if (idDocSession == null) {
            throw new IllegalArgumentException("The ID of the document session must not be null.");
        }
        DMI.deleteDocSession(idDocSession);
    }

    /**
     * Retrieves a list of all document sessions.
     * 
     * @return A list of all document sessions.
     */
    public List<DocSession> ListAllDocSessions() {
        return DMI.getAllDocSessions();
    }

    /**
     * Searches for documents associated with a specific session ID.
     * 
     * @param idSession The ID of the session to search for.
     * @return A list of documents associated with the session ID.
     */
    public List<Document> searchDocSessionByIdSession(String idSession) {
        List<Document> docs = new ArrayList<Document>();
        docSessions = DMI.getAllDocSessions();
        for (DocSession docSession : docSessions) {
            if (docSession.getIdSession().equals(idSession)) {
                docs.add(new DocumentManager().searchDocumentById(docSession.getIdDoc()));
            }
        }
        return docs;
    }

    /**
     * Searches for work sessions associated with a specific document ID.
     * 
     * @param idDoc The ID of the document to search for.
     * @return A list of work sessions associated with the document ID.
     */
    public List<WorkSession> searchDocSessionByIdDoc(String idDoc) {
        List<WorkSession> sessions = new ArrayList<WorkSession>();
        docSessions = DMI.getAllDocSessions();
        for (DocSession docSession : docSessions) {
            if (docSession.getIdDoc().equals(idDoc)) {
                sessions.add(new WorkSessionManager().searchWorkSessionById(docSession.getIdSession()));
            }
        }
        return sessions;
    }
}
