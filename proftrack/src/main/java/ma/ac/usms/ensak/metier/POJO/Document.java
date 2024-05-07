package ma.ac.usms.ensak.metier.POJO;

/**
 * The `document` class represents a document object.
 */
public class Document {
    private int id;
    private String description;
    private String dateAdded;
    private String path;
    private int id_task;
    private int id_workSession;
    private int id_project;

    /**
     * Constructs a new `document` object with the specified parameters.
     * 
     * @param id             the ID of the document
     * @param description    the description of the document
     * @param dateAdded      the date when the document was added
     * @param path           the path of the document
     * @param id_task        the ID of the task associated with the document
     * @param id_workSession the ID of the work session associated with the document
     * @param id_project     the ID of the project associated with the document
     */
    public Document(int id, String description, String dateAdded, String path, int id_task, int id_workSession,
            int id_project) {
        this.id = id;
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
    public int getId() {
        return this.id;
    }

    /**
     * Set the ID of the document.
     * 
     * @param id the ID of the document
     */
    public void setId(int id) {
        this.id = id;
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
    public int getId_task() {
        return id_task;
    }

    /**
     * Set the ID of the task associated with the document.
     * 
     * @param id_task the ID of the task
     */
    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    /**
     * Get the ID of the work session associated with the document.
     * 
     * @return the ID of the work session
     */
    public int getId_workSession() {
        return id_workSession;
    }

    /**
     * Set the ID of the work session associated with the document.
     * 
     * @param id_workSession the ID of the work session
     */
    public void setId_workSession(int id_workSession) {
        this.id_workSession = id_workSession;
    }

    /**
     * Get the ID of the project associated with the document.
     * 
     * @return the ID of the project
     */
    public int getId_project() {
        return id_project;
    }

    /**
     * Set the ID of the project associated with the document.
     * 
     * @param id_project the ID of the project
     */
    public void setId_project(int id_project) {
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

    // equals and hashCode methods
    @Override
    public boolean equals(Object obj) {
        // if (this == obj)
        //     return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Document other = (Document) obj;
        if (dateAdded == null) {
            if (other.dateAdded != null)
                return false;
        } else if (!dateAdded.equals(other.dateAdded))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id != other.id)
            return false;
        if (id_project != other.id_project)
            return false;
        if (id_task != other.id_task)
            return false;
        if (id_workSession != other.id_workSession)
            return false;
        if (path == null) {
            if (other.path != null)
                return false;
        } else if (!path.equals(other.path))
            return false;
        return true;
    }
}
