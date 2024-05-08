package ma.ac.usms.ensak.metier.POJO;

import java.util.Date;
import java.util.UUID;

/**
 * The `task` class represents a task object.
 */
public class Task {
    private String id;
    private String title;
    private String description;
    private Date start_date;
    private Date end_date;
    private String status;
    private String id_project;
    private String id_ListToDo;
    
    public Task() {
    }

    /**
     * Constructs a new task object with the specified parameters.
     *
     * @param title        the title of the task
     * @param description  the description of the task
     * @param start_date   the start date of the task
     * @param end_date     the end date of the task
     * @param status       the status of the task
     * @param id_project   the ID of the project associated with the task
     * @param id_ListToDo  the ID of the to-do list associated with the task
     */
    public Task(String title, String description, Date start_date, Date end_date, String status, String id_project, String id_ListToDo) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.id_project = id_project;
        this.id_ListToDo = id_ListToDo;
    }
    

    /**
     * Returns the ID of the task.
     *
     * @return int the ID of the task
     */
    public String getId() {
        return id;
    }
    
    /**
     * Returns the description of the task.
     *
     * @return String the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the task.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Returns the start date of the task.
     *
     * @return String the start date of the task
     */
    public Date getStart_date() {
        return start_date;
    }

    /**
     * Sets the start date of the task.
     *
     * @param start_date the start date to set
     */
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    /**
     * Returns the end date of the task.
     *
     * @return String the end date of the task
     */
    public Date getEnd_date() {
        return end_date;
    }
    
    /**
     * Sets the end date of the task.
     *
     * @param end_date the end date to set
     */
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
    
    /**
     * Returns the status of the task.
     *
     * @return String the status of the task
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * Sets the status of the task.
     *
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the ID of the project associated with the task.
     *
     * @return int the ID of the project associated with the task
     */
    public String getId_project() {
        return id_project;
    }

    /**
     * Sets the ID of the project associated with the task.
     *
     * @param id_project the ID of the project to set
     */
    public void setId_project(String id_project) {
        this.id_project = id_project;
    }

    /**
     * Returns the ID of the to-do list associated with the task.
     *
     * @return int the ID of the to-do list associated with the task
     */
    public String getId_ListToDo() {
        return id_ListToDo;
    }

    /**
     * Sets the ID of the to-do list associated with the task.
     *
     * @param id_ListToDo the ID of the to-do list to set
     */
    public void setId_ListToDo(String id_ListToDo) {
        this.id_ListToDo = id_ListToDo;
    }

    public boolean isClosed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isClosed'");
    }
}
