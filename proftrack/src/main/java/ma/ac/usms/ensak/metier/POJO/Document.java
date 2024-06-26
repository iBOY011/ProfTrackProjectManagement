package ma.ac.usms.ensak.metier.POJO;

import java.util.Date;
import java.util.UUID;



/**
 * The `document` class represents a document object.
 */
public class Document {
    private String id;
    private String title;
    private String description;
    private Date dateAdded;
    private String path;
    private String id_project;
    /**
     * Constructs a new `document` object with the specified parameters.
     * 
     * @param title          the title of the document
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
     * Set the ID of the document.
     * 
     * @param id the ID of the document
     */
    public void setId(String id) {
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
     * Set the ID of the project associated with the document.
     * 
     * @param id_project the ID of the project
     */
    public void setId_project(String id_project) {
        this.id_project = id_project;
    }

    public String getTitle() {
        return this.path.substring(this.path.lastIndexOf("\\") + 1);
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
        * Returns a string representation of the Document object.
        *
        * @return the string representation of the Document object, which includes the title, date added, and description.
        */
    @Override
    public String toString() {
        
        return getTitle() + " | Desc: " + getDescription() + " | Date Added: " + getDateAdded().getDay() + "/" + getDateAdded().getMonth() + "/" + getDateAdded().getYear();
    }

   

    

}
