package ma.ac.usms.ensak.metier.POJO;

import java.util.UUID;

/**
 * The `document` class represents a document object.
 */
public class Document {
    private String id;
    private String description;
    private String dateAdded;
    private String path;
    private String id_task;
    private String id_workSession;
    private String id_project;

    /**
     * Constructs a new `document` object with the specified parameters.
     * 
     * @param description    the description of the document
     * @param dateAdded      the date when the document was added
     * @param path           the path of the document
     * @param id_task        the ID of the task associated with the document
     * @param id_workSession the ID of the work session associated with the document
     * @param id_project     the ID of the project associated with the document
     */
    public Document(String description, String dateAdded, String path, String id_task, String id_workSession,
    String id_project) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.dateAdded = dateAdded;
        this.path = path;
        this.id_task = id_task;
        this.id_workSession = id_workSession;
        this.id_project = id_project;
    }

    /**
     * Default constructor for the `document` class.
     */
    public Document() {
    }

    /**
     * Get the ID of the document.
     * 
     * @return the ID of the document
     */
    public String getId() {
        return this.id;
    }

    /**
     * Get the description of the document.
     * 
     * @return the description of the document
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description of the document.
     * 
     * @param description the description of the document
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the date when the document was added.
     * 
     * @return the date when the document was added
     */
    public String getDateAdded() {
        return this.dateAdded;
    }

    /**
     * Set the date when the document was added.
     * 
     * @param dateAdded the date when the document was added
     */
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    /**
     * Get the path of the document.
     * 
     * @return the path of the document
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Set the path of the document.
     * 
     * @param path the path of the document
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the ID of the task associated with the document.
     * 
     * @return the ID of the task
     */
    public String getId_task() {
        return id_task;
    }

    /**
     * Set the ID of the task associated with the document.
     * 
     * @param id_task the ID of the task
     */
    public void setId_task(String id_task) {
        this.id_task = id_task;
    }

    /**
     * Get the ID of the work session associated with the document.
     * 
     * @return the ID of the work session
     */
    public String getId_workSession() {
        return id_workSession;
    }

    /**
     * Set the ID of the work session associated with the document.
     * 
     * @param id_workSession the ID of the work session
     */
    public void setId_workSession(String id_workSession) {
        this.id_workSession = id_workSession;
    }

    /**
     * Get the ID of the project associated with the document.
     * 
     * @return the ID of the project
     */
    public String getId_project() {
        return id_project;
    }

    /**
     * Set the ID of the project associated with the document.
     * 
     * @param id_project the ID of the project
     */
    public void setId_project(String id_project) {
        this.id_project = id_project;
    }

    /**
     * Returns a string representation of the `document` object.
     * 
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "document [id=" + id + ", description=" + description + ", dateAdded=" + dateAdded + ", path=" + path
                + ", id_task=" + id_task + ", id_workSession=" + id_workSession + ", id_project=" + id_project + "]";
    }

}
