import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.persistance.impl.WorkSessionImpl;

import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

public class WorkSessionImplTest {

    private WorkSessionImpl workSessionImpl;

    @BeforeEach
    public void setUp() {
        workSessionImpl = new WorkSessionImpl();
    }

    @Test
    public void testAddWorkSession() {
        // Create a new work session
        WorkSession workSession = new WorkSession("Session 1", new Date(), new Date(), "Note 1", "project1");

        assertNotNull(workSession);

        // Add the work session
        workSessionImpl.addWorkSession(workSession);

        // Retrieve the work session by ID
        WorkSession retrievedWorkSession = workSessionImpl.getWorkSessionById(workSession.getId());

        // Check if the retrieved work session is not null
        assertNotNull(retrievedWorkSession);
        // Check if the retrieved work session is the same as the added work session
        assertEquals(workSession, retrievedWorkSession);
    }

    @Test
    public void testGetWorkSessionById() {
        // Retrieve a work session by ID
        WorkSession workSession = workSessionImpl.getWorkSessionById("319ea34b-0205-4dca-86db-272385e37503");

        // Check if the retrieved work session is not null
        assertNotNull(workSession);
    }

    @Test
    public void testUpdateWorkSession() {
        // Retrieve a work session by ID
        WorkSession workSession = workSessionImpl.getWorkSessionById("319ea34b-0205-4dca-86db-272385e37503");

        // Update the work session
        workSession.setDescription("Updated description");
        workSessionImpl.updateWorkSession(workSession);

        // Retrieve the updated work session by ID
        WorkSession updatedWorkSession = workSessionImpl.getWorkSessionById(workSession.getId());

        // Check if the retrieved work session has the updated description
        assertEquals("Updated description", updatedWorkSession.getDescription());
    }

    @Test
    public void testDeleteWorkSession() {
        // Retrieve a work session by ID
        WorkSession workSession = workSessionImpl.getWorkSessionById("e1917ba2-96e4-4f87-a4ee-ae52f15de1d5");

        // Delete the work session
        workSessionImpl.deleteWorkSession(workSession.getId());

        // Try to retrieve the deleted work session by ID
        WorkSession deletedWorkSession = workSessionImpl.getWorkSessionById(workSession.getId());

        // Check if the retrieved work session is null
        assertNull(deletedWorkSession);
    }

    @Test
    public void testGetAllSeancesTravail() {
        // Retrieve all work sessions
        List<WorkSession> workSessions = workSessionImpl.getAllSeancesTravail();


    }

    @Test
    public void testGetSeancesTravailByProject() {
        // Retrieve work sessions by project ID
        List<WorkSession> workSessions = workSessionImpl.getSeancesTravailByProject("project1");

        // Check if the list is not null
        assertNotNull(workSessions);
    }

    @Test
    public void testSearchSeancesTravailByKeyword() {
        // Search work sessions by keyword
        List<WorkSession> workSessions = workSessionImpl.searchSeancesTravailByKeyword("keyword");

        // Check if the list is not null
        assertNotNull(workSessions);
    }
}