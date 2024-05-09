package ma.ac.usms.ensak.persistance.impl;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.persistance.dao.WorkSessionDAO;
import ma.ac.usms.ensak.persistance.StorageFile;
/**
 * Implementation of the workSessionDAO interface.
 * Provides methods to create, read, update, and delete work sessions.
 */
public class WorkSessionImpl implements WorkSessionDAO {
    private static final String WORK_SESSION_FILE = "proftrack\\src\\main\\resources\\databases\\WorkSessionFile.json";

    /**
     * Creates a new work session.
     * @param workSession The work session to be created.
     */
    @Override
    public void addWorkSession(WorkSession workSession) {
        // check if the file exists, if not create it
        List<WorkSession> workSessions = new ArrayList<WorkSession>();
        workSessions = StorageFile.readObjectsFromJsonFile(WORK_SESSION_FILE, WorkSession.class);
        if (workSessions == null) {
            workSessions = new ArrayList<WorkSession>();
        }
        workSessions.add(workSession);
        StorageFile.saveToJsonFile(workSessions, WORK_SESSION_FILE);
    }

    /**
     * Reads a work session by its ID.
     * @param idworkSession The ID of the work session to be read.
     * @return The work session with the specified ID, or null if not found.
     */
    @Override
    public WorkSession getWorkSessionById(String idworkSession) {
        List<WorkSession> workSessions = StorageFile.readObjectsFromJsonFile(WORK_SESSION_FILE, WorkSession.class);
        for (WorkSession ws : workSessions) {
            if (ws.getId().contentEquals(idworkSession)) {
                return ws;
            }
        }
        return null;
    }

    /**
     * Updates a work session.
     * @param workSession The work session to be updated.
     */
    @Override
    public void updateWorkSession(WorkSession workSession) {
        // TODO Auto-generated method stub
        List<WorkSession> workSessions = StorageFile.readObjectsFromJsonFile(WORK_SESSION_FILE, WorkSession.class);
   
        for (int i = 0; i < workSessions.size(); i++) {
            WorkSession ws = workSessions.get(i);
            if (ws.getId() == workSession.getId()) {
                workSessions.set(i, workSession);
                break;
            }
        }
        StorageFile.saveToJsonFile(workSessions, WORK_SESSION_FILE);
    }

    /**
     * Deletes a work session by its ID.
     * @param idworkSession The ID of the work session to be deleted.
     */
    @Override
    public void deleteWorkSession(String idworkSession) {
        // TODO Auto-generated method stub
        List<WorkSession> workSessions = StorageFile.readObjectsFromJsonFile(WORK_SESSION_FILE, WorkSession.class);

        for (WorkSession ws : workSessions) {
            if (ws.getId() == idworkSession) {
                workSessions.remove(ws);
                break;
            }
        }
        StorageFile.saveToJsonFile(workSessions, WORK_SESSION_FILE);
    }

    /**
     * Retrieves all work sessions.
     * @return A list of all work sessions.
     */
    @Override
    public List<WorkSession> getAllSeancesTravail() {
        // TODO Auto-generated method stub
        return StorageFile.readObjectsFromJsonFile(WORK_SESSION_FILE, WorkSession.class);
    }

    /**
     * Retrieves work sessions by project ID.
     * @param idProjet The ID of the project.
     * @return A list of work sessions associated with the specified project.
     */
    @Override
    public List<WorkSession> getSeancesTravailByProject(String idProjet) {
        // TODO Auto-generated method stub
        List<WorkSession> workSessions = StorageFile.readObjectsFromJsonFile(WORK_SESSION_FILE, WorkSession.class);
        List<WorkSession> workSessionsByProject = new ArrayList<WorkSession>();
        for (WorkSession ws : workSessions) {
            if (ws.getId_project() == idProjet) {
                workSessionsByProject.add(ws);
            }
        }
        return workSessionsByProject;
    }

    /**
     * Searches work sessions by keyword in the description.
     * @param keyword The keyword to search for.
     * @return A list of work sessions that contain the specified keyword in the description.
     */
    @Override
    public List<WorkSession> searchSeancesTravailByKeyword(String keyword) {
        // TODO Auto-generated method stub
        List<WorkSession> workSessions = StorageFile.readObjectsFromJsonFile(WORK_SESSION_FILE, WorkSession.class);
        List<WorkSession> workSessionsByKeyword = new ArrayList<WorkSession>();
        for (WorkSession ws : workSessions) {
            if (ws.getDescription().contains(keyword)) {
                workSessionsByKeyword.add(ws);
            }
        }
        return workSessionsByKeyword;
    }

}
