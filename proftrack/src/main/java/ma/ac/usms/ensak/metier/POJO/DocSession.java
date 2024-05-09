package ma.ac.usms.ensak.metier.POJO;


/**
 * The `DocSession` class represents a document session.
 */
/**
 * The DocSession class represents a document-session mapping.
 */
public class DocSession {
    private String idDoc;
    private String idSession;

    /**
     * Gets the ID of the document.
     * 
     * @return The ID of the document.
     */
    public String getIdDoc() {
        return idDoc;
    }

    /**
     * Sets the ID of the document.
     * 
     * @param idDoc The ID of the document.
     */
    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    /**
     * Gets the ID of the session.
     * 
     * @return The ID of the session.
     */
    public String getIdSession() {
        return idSession;
    }

    /**
     * Sets the ID of the session.
     * 
     * @param idSession The ID of the session.
     */
    public void setIdSession(String idSession) {
        this.idSession = idSession;
    }
}
