package ma.ac.usms.ensak.metier.POJO;

public class WorkSession {
    private int id;
    private String description;
    private String dateDebut;
    private String dateFin;
    private String note;
    private int id_project;

    public WorkSession() {
    }

    /**
     * Constructs a new work session with the specified parameters.
     *
     * @param id          the ID of the work session
     * @param description the description of the work session
     * @param dateDebut   the start date of the work session
     * @param dateFin     the end date of the work session
     * @param note        the note for the work session
     * @param id_project  the ID of the project associated with the work session
     */
    public WorkSession(int id, String description, String dateDebut, String dateFin, String note, int id_project) {
        this.id = id;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.note = note;
        this.id_project = id_project;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the dateDebut
     */
    public String getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return String return the dateFin
     */
    public String getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return String return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Returns the ID of the project associated with this work session.
     *
     * @return the ID of the project
     */
    public int getId_project() {
        return id_project;
    }

    /**
     * Sets the ID of the project associated with this work session.
     *
     * @param id_project the ID of the project
     */
    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

}
