package ma.ac.usms.ensak.metier.POJO;

/**
 * The `listToDo` class represents a to-do item in a list.
 */
public class ListToDo {
    private int id;
    private String description;
    
    /**
     * Constructs a new `listToDo` object with the specified id and description.
     * 
     * @param id          the id of the to-do item
     * @param description the description of the to-do item
     */
    public ListToDo(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * Constructs a new empty `listToDo` object.
     */
    public ListToDo() {
    }
    
    /**
     * Returns the id of the to-do item.
     * 
     * @return the id of the to-do item
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the to-do item.
     * 
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the description of the to-do item.
     * 
     * @return the description of the to-do item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the to-do item.
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
