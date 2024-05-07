package ma.ac.usms.ensak.metier.POJO;

/**
 * The `project` class represents a project with various attributes such as id, description, start date, end date, category, and type.
 */
public class project {
    private int id;
    private String description;
    private String start_date;
    private String end_date;
    private String category;
    private String type;

    public project() {
    }

    /**
     * Constructs a new `project` object with the specified attributes.
     * 
     * @param id          the id of the project
     * @param description the description of the project
     * @param start_date  the start date of the project
     * @param end_date    the end date of the project
     * @param category    the category of the project
     * @param type        the type of the project
     */
    public project(int id, String description, String start_date, String end_date, String category, String type) {
        this.id = id;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.category = category;
        this.type = type;
    }

    /**
     * Returns the id of the project.
     * 
     * @return the id of the project
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the project.
     * 
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
    public String getStart_date() {
        return start_date;
    }

    /**
     * Sets the start date of the project.
     * 
     * @param start_date the start date to set
     */
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    /**
     * Returns the end date of the project.
     * 
     * @return the end date of the project
     */
    public String getEnd_date() {
        return end_date;
    }

    /**
     * Sets the end date of the project.
     * 
     * @param end_date the end date to set
     */
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    /**
     * Returns the category of the project.
     * 
     * @return the category of the project
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the project.
     * 
     * @param category the category to set
     */
    public void setCategory(String category) {
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

}
