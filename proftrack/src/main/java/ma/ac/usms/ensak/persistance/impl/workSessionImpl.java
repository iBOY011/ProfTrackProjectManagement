package ma.ac.usms.ensak.persistance.impl;
import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.workSession;
import ma.ac.usms.ensak.persistance.dao.workSessionDAO;
import ma.ac.usms.ensak.persistance.StorageFile;
/**
 * Implementation of the workSessionDAO interface.
 * Provides methods to create, read, update, and delete work sessions.
 */
public class workSessionImpl implements workSessionDAO {

    /**
     * Creates a new work session.
     * @param workSession The work session to be created.
     */
    @Override
    public void addWorkSession(workSession workSession) {
        // TODO Auto-generated method stub
        List<workSession> workSessions = StorageFile.readObjectsFromJsonFile("workSessionFile.json");
        if (!workSessions.isEmpty()) {
            workSession.setId(workSessions.get(workSessions.size() - 1).getId() + 1);
        } else {
            workSession.setId(1);
        }
        StorageFile.saveToJsonFile(workSession, "workSessionFile.json");
    }

    /**
     * Reads a work session by its ID.
     * @param idworkSession The ID of the work session to be read.
     * @return The work session with the specified ID, or null if not found.
     */
    @Override
    public workSession getWorkSessionById(int idworkSession) {
        // TODO Auto-generated method stub
        List<workSession> workSessions = StorageFile.readObjectsFromJsonFile("workSessionFile.json");
        for (workSession ws : workSessions) {
            if (ws.getId() == idworkSession) {
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
    public void updateWorkSession(workSession workSession) {
        // TODO Auto-generated method stub
        List<workSession> workSessions = StorageFile.readObjectsFromJsonFile("workSessionFile.json");
   
        for (workSession ws : workSessions) {
            if (ws.getId() == workSession.getId()) {
                ws = workSession;
            }
        }
        StorageFile.saveListToJsonFile(workSessions, "src/main/resources/databases/workSessionFile.json");
    }

    /**
     * Deletes a work session by its ID.
     * @param idworkSession The ID of the work session to be deleted.
     */
    @Override
    public void deleteWorkSession(int idworkSession) {
        // TODO Auto-generated method stub
        List<workSession> workSessions = StorageFile.readObjectsFromJsonFile("src/main/resources/databases/workSessionFile.json");

        for (workSession ws : workSessions) {
            if (ws.getId() == idworkSession) {
                workSessions.remove(ws);
                break;
            }
        }
        StorageFile.saveListToJsonFile(workSessions, "src/main/resources/databases/workSessionFile.json");
    }

    /**
     * Retrieves all work sessions.
     * @return A list of all work sessions.
     */
    @Override
    public List<workSession> getAllSeancesTravail() {
        // TODO Auto-generated method stub
        return StorageFile.readObjectsFromJsonFile("src/main/resources/databases/workSessionFile.json");
    }

    /**
     * Retrieves work sessions by project ID.
     * @param idProjet The ID of the project.
     * @return A list of work sessions associated with the specified project.
     */
    @Override
    public List<workSession> getSeancesTravailByProject(int idProjet) {
        // TODO Auto-generated method stub
        List<workSession> workSessions = StorageFile.readObjectsFromJsonFile("src/main/resources/databases/workSessionFile.json");
        List<workSession> workSessionsByProject = new ArrayList<workSession>();
        for (workSession ws : workSessions) {
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
    public List<workSession> searchSeancesTravailByKeyword(String keyword) {
        // TODO Auto-generated method stub
        List<workSession> workSessions = StorageFile.readObjectsFromJsonFile("src/main/resources/databases/workSessionFile.json");
        List<workSession> workSessionsByKeyword = new ArrayList<workSession>();
        for (workSession ws : workSessions) {
            if (ws.getDescription().contains(keyword)) {
                workSessionsByKeyword.add(ws);
            }
        }
        return workSessionsByKeyword;
    }

}
