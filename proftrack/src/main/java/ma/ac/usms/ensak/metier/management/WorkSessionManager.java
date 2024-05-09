package ma.ac.usms.ensak.metier.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.persistance.impl.ProjectImpl;
import ma.ac.usms.ensak.persistance.impl.WorkSessionImpl;

public class WorkSessionManager {
    private List<WorkSession> workSessions;
    private WorkSessionImpl workSessionImpl;

    public WorkSessionManager() {
        workSessions = new ArrayList<WorkSession>();
        workSessionImpl = new WorkSessionImpl();
    }

    // sort work sessions
    public void sort() {
        // sort the work sessions by dateDebut
        workSessions.sort((WorkSession ws1, WorkSession ws2) -> ws1.getDateDebut().compareTo(ws2.getDateDebut()));
    }

    // validate work session
    public void validate(WorkSession workSession) {
        // check if the work session is not null
        if (workSession == null) {
            throw new IllegalArgumentException("The work session cannot be null.");
        }
        // check if the description is not null
        if (workSession.getDescription() == null) {
            throw new IllegalArgumentException("The description cannot be null.");
        }
        // check if the dateDebut is not null and greater than the current date
        if (workSession.getDateDebut() == null ||
                workSession.getDateDebut().compareTo(new Date()) < 0) {
            throw new IllegalArgumentException("The start date cannot be null.");
        }
        // check if the dateFin is not null and greater than the dateDebut
        if (workSession.getDateFin() == null ||
                workSession.getDateFin().compareTo(workSession.getDateDebut()) < 0) {
            throw new IllegalArgumentException("The end date cannot be null.");
        }
        // check if start date and end date in the same day
        if (workSession.getDateDebut().compareTo(workSession.getDateFin()) == 0) {
            throw new IllegalArgumentException("The start date and end date cannot be the same.");
        }
    }

    // add work session with id project
    public void createWorkSession(
            String description,
            Date dateDebut,
            Date dateFin,
            String note,
            String id_project) {
        // create a new work session
        WorkSession workSession = new WorkSession(description, dateDebut, dateFin, note, id_project);
        // validate the work session
        validate(workSession);
        // add the work session to the database
        workSessionImpl.addWorkSession(workSession);
    }

    // update work session
    public void updateWorkSession(WorkSession workSession) {
        // validate the work session
        validate(workSession);
        // update the work session in the database
        workSessionImpl.updateWorkSession(workSession);
    }

    // delete work session
    public void deleteWorkSession(String idworkSession) {
        // check if idworkSession is not null
        if (idworkSession == null) {
            throw new IllegalArgumentException("The ID of the work session cannot be null.");
        }
        // delete the work session from the database
        workSessionImpl.deleteWorkSession(idworkSession);
    }

    // get work session by ID
    public WorkSession searchWorkSessionById(String idworkSession) {
        // check if idworkSession is not null
        if (idworkSession == null) {
            throw new IllegalArgumentException("The ID of the work session cannot be null.");
        }
        // get the work session from the database
        return workSessionImpl.getWorkSessionById(idworkSession);
    }

    // get all work sessions
    public List<WorkSession> getAllWorkSessions() {
        // get all work sessions from the database
        return workSessionImpl.getAllSeancesTravail();
    }

    // get work sessions by project ID
    public List<WorkSession> listWorkSessionsByIdProject(Project project) {
        // check if the project is not null
        if (project == null) {
            throw new IllegalArgumentException("The project cannot be null.");
        }
        // get all work sessions from the database
        List<WorkSession> workSessions = workSessionImpl.getAllSeancesTravail();
        List<WorkSession> workSessionsByIdProject = new ArrayList<WorkSession>();
        // get the work sessions by project ID
        for (WorkSession workSession : workSessions) {
            if (workSession.getId_project().equals(project.getId())) {
                workSessionsByIdProject.add(workSession);
            }
        }
        return workSessionsByIdProject;
    }

    // get work sessions by project date
    public List<WorkSession> filterWorkSessionsByDate(Date date) {
        // check if the date is not null
        if (date == null) {
            throw new IllegalArgumentException("The date cannot be null.");
        }
        // get all work sessions from the database
        List<WorkSession> workSessions = workSessionImpl.getAllSeancesTravail();
        List<WorkSession> workSessionsByDate = new ArrayList<WorkSession>();
        // get the work sessions by date
        for (WorkSession workSession : workSessions) {
            if (workSession.getDateDebut().compareTo(date) <= 0 &&
                    workSession.getDateFin().compareTo(date) >= 0) {
                workSessionsByDate.add(workSession);
            }
        }
        return workSessionsByDate;
    }

    // get work sessions by project category
    public List<WorkSession> filterWorkSessionsByProjectCategory(String category) {
        // check if the category is not null
        if (category == null) {
            throw new IllegalArgumentException("The category cannot be null.");
        }
        // get all work sessions from the database
        List<WorkSession> workSessions = workSessionImpl.getAllSeancesTravail();
        List<WorkSession> workSessionsByProjectCategory = new ArrayList<WorkSession>();
        // get the work sessions by project category
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