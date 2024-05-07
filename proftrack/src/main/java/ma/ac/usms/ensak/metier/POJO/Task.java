package ma.ac.usms.ensak.metier.POJO;

/**
 * The `task` class represents a task object.
 */
public class Task {
    private int id;
    private String description;
    private String start_date;
    private String end_date;
    private String status;
    private int id_project;
    private int id_ListToDo;

    public Task() {
    }

    /**
     * Constructs a new task object with the specified parameters.
     *
     * @param id           the ID of the task
     * @param description  the description of the task
     * @param start_date   the start date of the task
     * @param end_date     the end date of the task
     * @param status       the status of the task
     * @param id_project   the ID of the project associated with the task
     * @param id_ListToDo  the ID of the to-do list associated with the task
     */
    public Task(int id, String description, String start_date, String end_date, String status, int id_project, int id_ListToDo) {
        this.id = id;
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
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the task.
     *
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
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
    public String getStart_date() {
        return start_date;
    }

    /**
     * Sets the start date of the task.
     *
     * @param start_date the start date to set
     */
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    /**
     * Returns the end date of the task.
     *
     * @return String the end date of the task
     */
    public String getEnd_date() {
        return end_date;
    }

    /**
     * Sets the end date of the task.
     *
     * @param end_date the end date to set
     */
    public void setEnd_date(String end_date) {
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

    /**
     * Returns the ID of the project associated with the task.
     *
     * @return int the ID of the project associated with the task
     */
    public int getId_project() {
        return id_project;
    }

    /**
     * Sets the ID of the project associated with the task.
     *
     * @param id_project the ID of the project to set
     */
    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    /**
     * Returns the ID of the to-do list associated with the task.
     *
     * @return int the ID of the to-do list associated with the task
     */
    public int getId_ListToDo() {
        return id_ListToDo;
    }

    /**
     * Sets the ID of the to-do list associated with the task.
     *
     * @param id_ListToDo the ID of the to-do list to set
     */
    public void setId_ListToDo(int id_ListToDo) {
        this.id_ListToDo = id_ListToDo;
    }
}
