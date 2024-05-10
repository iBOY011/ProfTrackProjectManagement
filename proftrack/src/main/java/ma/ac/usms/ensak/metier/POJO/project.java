package ma.ac.usms.ensak.metier.POJO;

import java.util.Date;
import java.util.UUID;

import ma.ac.usms.ensak.util.Category;


/**
 * The `project` class represents a project with various attributes such as id,
 * description, start date, end date, category, and type.
 */
public class Project {
    private String id;
    private String title;
    private String description;
    private Date start_date;
    private Date end_date;
    private Category category;
    private String type;
    private boolean archived;

    public Project() {
    }

    /**
     * Constructs a new `project` object with the specified attributes.
     * 
     * @param title       the title of the project
     * @param description the description of the project
     * @param start_date  the start date of the project
     * @param end_date    the end date of the project
     * @param category    the category of the project
     * @param type        the type of the project
     * @param archived    the status of the project
     */
    public Project(String title, String description, Date start_date, Date end_date, Category category, String type, boolean archived) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.category = category;
        this.type = type;
        this.archived = archived;
    }

    /**
     * Returns the id of the project.
     * 
     * @return the id of the project
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the description of the project.
     * 
     * @return the description of the project
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the project.
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the start date of the project.
     * 
     * @return the start date of the project
     */
    public Date getStart_date() {
        return start_date;
    }

    /**
     * Sets the start date of the project.
     * 
     * @param start_date the start date to set
     */
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    /**
     * Returns the end date of the project.
     * 
     * @return the end date of the project
     */
    public Date getEnd_date() {
        return end_date;
    }

    /**
     * Sets the end date of the project.
     * 
     * @param end_date the end date to set
     */
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    /**
     * Returns the category of the project.
     * 
     * @return the category of the project
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category of the project.
     * 
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Returns the type of the project.
     * 
     * @return the type of the project
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the project.
     * 
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * @return boolean return the archived
     */
    public boolean isArchived() {
        return archived;
    }

    /**
     * @param archived the archived to set
     */
    public void setArchived(boolean archived) {
        this.archived = archived;
    }

}
