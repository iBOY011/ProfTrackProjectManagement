import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.metier.management.WorkSessionManager;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class WorkSessionManagerTest {

    private WorkSessionManager workSessionManager;

    @BeforeEach
    public void setUp() {
        workSessionManager = new WorkSessionManager();
    }

    @Test
    public void testSort() {
        // generate start date and end date
        Date date = new Date();
        Date startDate1 = new Date(date.getTime() + 1000);
        Date endDate1 = new Date(startDate1.getTime() + 1000);
        // Add some work sessions
        workSessionManager.createWorkSession("Session 1", startDate1, endDate1, "Note 1", "project1");
        workSessionManager.createWorkSession("Session 2", startDate1, endDate1, "Note 2", "project2");

        // Sort the work sessions
        workSessionManager.sort();

        // Get all work sessions
        List<WorkSession> sortedWorkSessions = workSessionManager.getAllWorkSessions();

        // Check if the work sessions are sorted by dateDebut
        for (int i = 0; i < sortedWorkSessions.size() - 1; i++) {
            assertTrue(sortedWorkSessions.get(i).getDateDebut().compareTo(sortedWorkSessions.get(i + 1).getDateDebut()) <= 0);
        }
    }

    @Test
    public void testValidateValidWorkSession() {
        // Create a valid work session
        WorkSession workSession = new WorkSession("Session 1", new Date(), new Date(), "Note 1", "project1");

        // Validate the work session
        assertDoesNotThrow(() -> workSessionManager.validate(workSession));
    }

    @Test
    public void testValidateNullWorkSession() {
        // Validate a null work session
        assertThrows(IllegalArgumentException.class, () -> workSessionManager.validate(null));
    }

    @Test
    public void testValidateNullDescription() {
        // Create a work session with null description
        WorkSession workSession = new WorkSession(null, new Date(), new Date(), "Note 1", "project1");

        // Validate the work session
        assertThrows(IllegalArgumentException.class, () -> workSessionManager.validate(workSession));
    }

    @Test
    public void testAddDocumentsIds() {
        // Create a work session
        WorkSession workSession = workSessionManager.searchWorkSessionById("e1917ba2-96e4-4f87-a4ee-ae52f15de1d5");
        // Check if the work session is created
        assertNotNull(workSession);
        // create documents
        Document doc1 = new Document("doc1", "path1", "project1");
        Document doc2 = new Document("doc2", "path2", "project1");
        // Check if the document IDs are added
        assertTrue(workSession.getDocumentIds().contains("doc1"));
        assertTrue(workSession.getDocumentIds().contains("doc2"));
    }

}