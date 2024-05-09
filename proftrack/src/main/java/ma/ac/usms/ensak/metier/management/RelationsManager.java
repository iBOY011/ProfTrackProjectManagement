package ma.ac.usms.ensak.metier.management;

import ma.ac.usms.ensak.metier.POJO.WorkSession;

/**
 * The `RelationsManager` class manages the relations between work sessions and documents.
 */
public class RelationsManager {
    private WorkSessionManager workSessionManager;
    private DocumentManager documentManager;

    /**
     * Constructs a new `RelationsManager` object.
     */
    public RelationsManager() {
        workSessionManager = new WorkSessionManager();
        documentManager = new DocumentManager();
    }
    // Add methods to manage relations between work sessions and documents
    public void addDocumentToWorkSession(String idDocument, String idWorkSession) {
        // Add the document to the work session
        WorkSession workSession = workSessionManager.searchWorkSessionById(idWorkSession);
        workSession.addDocumentId(idDocument);
        
    }
    // Add any additional attributes or methods as needed
}
