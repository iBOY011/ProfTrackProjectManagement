package ma.ac.usms.ensak.metier.POJO;

import java.util.UUID;

/**
 * The `listToDo` class represents a to-do item in a list.
 */
public class ListToDo {
    private String id;
    private String description;
    
    /**
     * Constructs a new `listToDo` object with the specified id and description.
     * 
     * @param description the description of the to-do item
     */
    public ListToDo(String description) {
        this.id = UUID.randomUUID().toString();
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
    public String getId() {
        return id;
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
