package ma.ac.usms.ensak.metier.POJO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.google.gson.annotations.JsonAdapter;


/**
 * The `document` class represents a document object.
 */
public class Document {
    private String id;
    private String description;
    private Date dateAdded;
    private String path;
    private String id_project;
    /**
     * Constructs a new `document` object with the specified parameters.
     * 
     * @param description    the description of the document
     * @param dateAdded      the date when the document was added
     * @param path           the path of the document
     * @param id_project     the ID of the project associated with the document
     */
    public Document(String description,  String path, String id_project) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.dateAdded = new Date();
        this.path = path;
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
    public Date getDateAdded() {
        return this.dateAdded;
    }

    /**
     * Set the date when the document was added.
     * 
     * @param dateAdded the date when the document was added
     */
    public void setDateAdded(Date dateAdded) {
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
     * Get the ID of the project associated with the document.
     * 
     * @return the ID of the project
     */
    public String getId_project() {
        return id_project;
    }

   

    /**
     * Returns a string representation of the `document` object.
     * 
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Document [id=" + id + ", description=" + description + ", dateAdded=" + dateAdded + ", path=" + path
                + ", id_project=" + id_project + "]";
    }

}
