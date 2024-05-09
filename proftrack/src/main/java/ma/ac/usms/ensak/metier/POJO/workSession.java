package ma.ac.usms.ensak.metier.POJO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;



/**
 * The `workSession` class represents a work session object.
 */
public class WorkSession {
    private String id;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String note;
    private String id_project;
    private Set<String> documentIds;
    private boolean closed;

    public WorkSession() {
    }

    /**
     * Constructs a new work session with the specified parameters.
     *
     * @param description the description of the work session
     * @param dateDebut   the start date of the work session
     * @param dateFin     the end date of the work session
     * @param note        the note for the work session
     * @param id_project  the ID of the project associated with the work session
     */
    public WorkSession(String description, Date dateDebut, Date dateFin, String note, String id_project) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.note = note;
        this.id_project = id_project;
        this.documentIds = new HashSet<>();
    }

    /**
     * @return int return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return String return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return String return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Returns the ID of the project associated with this work session.
     *
     * @return the ID of the project
     */
    public String getId_project() {
        return id_project;
    }

    /**
     * Sets the ID of the project associated with this work session.
     *
     * @param id_project the ID of the project
     */
    public void setId_project(String id_project) {
        this.id_project = id_project;
    }

    /**
     * Returns the set of document IDs associated with this work session.
     *
     * @return the set of document IDs
     */
    public Set<String> getDocumentIds() {
        return documentIds;
    }

    /**
     * Adds a document ID to the set of document IDs associated with this work session.
     *
     * @param documentId the document ID to add
     */
    public void addDocumentId(String documentId) {
        this.documentIds.add(documentId);
    }

    public void setClosed(boolean b) {
        this.closed = b;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setId(String asString) {
        this.id = asString;
    }

}
