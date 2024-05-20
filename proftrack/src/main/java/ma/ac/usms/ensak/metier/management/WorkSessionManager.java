package ma.ac.usms.ensak.metier.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.persistance.impl.ProjectImpl;
import ma.ac.usms.ensak.persistance.impl.WorkSessionImpl;

/**
 * The WorkSessionManager class manages work sessions and provides various operations related to work sessions.
 */
public class WorkSessionManager {
    private List<WorkSession> workSessions;
    private WorkSessionImpl workSessionImpl;

    /**
     * Constructs a new WorkSessionManager object.
     */
    public WorkSessionManager() {
        workSessions = new ArrayList<WorkSession>();
        workSessionImpl = new WorkSessionImpl();
    }

    /**
     * Sorts the work sessions by dateDebut.
     */
    public void sort() {
        workSessions.sort((WorkSession ws1, WorkSession ws2) -> ws1.getDateDebut().compareTo(ws2.getDateDebut()));
    }

    /**
     * Validates a work session.
     *
     * @param workSession The work session to validate.
     * @throws IllegalArgumentException If the work session is null or if the description is null.
     */
    public void validate(WorkSession workSession) {
        if (workSession == null) {
            throw new IllegalArgumentException("The work session cannot be null.");
        }
        if (workSession.getDescription() == null) {
            throw new IllegalArgumentException("The description cannot be null.");
        }
    }

    /**
     * Creates a new work session with the given parameters and adds it to the database.
     *
     * @param description The description of the work session.
     * @param dateDebut   The start date of the work session.
     * @param dateFin     The end date of the work session.
     * @param note        The note of the work session.
     * @param id_project  The ID of the project associated with the work session.
     */
    public void createWorkSession(String description, Date dateDebut, Date dateFin, String note, String id_project) {
        WorkSession workSession = new WorkSession(description, dateDebut, dateFin, note, id_project);
        validate(workSession);
        workSessionImpl.addWorkSession(workSession);
    }

    /**
     * Updates a work session in the database.
     *
     * @param workSession The work session to update.
     */
    public void updateWorkSession(WorkSession workSession) {
        validate(workSession);
        workSessionImpl.updateWorkSession(workSession);
    }

    /**
     * Deletes a work session from the database.
     *
     * @param idworkSession The ID of the work session to delete.
     * @throws IllegalArgumentException If the ID of the work session is null.
     */
    public void deleteWorkSession(String idworkSession) {
        if (idworkSession == null) {
            throw new IllegalArgumentException("The ID of the work session cannot be null.");
        }
        workSessionImpl.deleteWorkSession(idworkSession);
    }

    /**
     * Searches for a work session by its ID.
     *
     * @param idworkSession The ID of the work session to search for.
     * @return The work session with the specified ID, or null if not found.
     * @throws IllegalArgumentException If the ID of the work session is null.
     */
    public WorkSession searchWorkSessionById(String idworkSession) {
        if (idworkSession == null) {
            throw new IllegalArgumentException("The ID of the work session cannot be null.");
        }
        return workSessionImpl.getWorkSessionById(idworkSession);
    }

    /**
     * Retrieves all work sessions from the database.
     *
     * @return A list of all work sessions.
     */
    public List<WorkSession> getAllWorkSessions() {
        return workSessionImpl.getAllSeancesTravail();
    }

    /**
     * Retrieves work sessions by project ID.
     *
     * @param Id The ID of the project.
     * @return A list of work sessions associated with the specified project ID.
     * @throws IllegalArgumentException If the project ID is null.
     */
    public List<WorkSession> listWorkSessionsByIdProject(String Id) {
        if (Id == null) {
            throw new IllegalArgumentException("The project cannot be null.");
        }
        List<WorkSession> workSessions = workSessionImpl.getAllSeancesTravail();
        List<WorkSession> workSessionsByIdProject = new ArrayList<WorkSession>();
        for (WorkSession workSession : workSessions) {
            if (workSession.getId_project().equals(Id)) {
                workSessionsByIdProject.add(workSession);
            }
        }
        return workSessionsByIdProject;
    }

    /**
     * Filters work sessions by date.
     *
     * @param date The date to filter work sessions by.
     * @return A list of work sessions that fall within the specified date range.
     * @throws IllegalArgumentException If the date is null.
     */
    public List<WorkSession> filterWorkSessionsByDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date cannot be null.");
        }
        List<WorkSession> workSessions = workSessionImpl.getAllSeancesTravail();
        List<WorkSession> workSessionsByDate = new ArrayList<WorkSession>();
        for (WorkSession workSession : workSessions) {
            if (workSession.getDateDebut().compareTo(date) <= 0 &&
                    workSession.getDateFin().compareTo(date) >= 0) {
                workSessionsByDate.add(workSession);
            }
        }
        return workSessionsByDate;
    }

    /**
     * Filters work sessions by project category.
     *
     * @param category The category to filter work sessions by.
     * @return A list of work sessions that belong to projects with the specified category.
     * @throws IllegalArgumentException If the category is null.
     */
    public List<WorkSession> filterWorkSessionsByProjectCategory(String category) {
        if (category == null) {
            throw new IllegalArgumentException("The category cannot be null.");
        }
        List<WorkSession> workSessions = workSessionImpl.getAllSeancesTravail();
        List<WorkSession> workSessionsByProjectCategory = new ArrayList<WorkSession>();
        for (WorkSession workSession : workSessions) {
            ProjectImpl projectImpl = new ProjectImpl();
            Project project = projectImpl.getProjectById(workSession.getId_project());
            if (project.getCategory().equals(category)) {
                workSessionsByProjectCategory.add(workSession);
            }
        }
        return workSessionsByProjectCategory;
    }
}