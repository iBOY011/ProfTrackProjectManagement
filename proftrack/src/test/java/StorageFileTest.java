import org.junit.jupiter.api.Test;

import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.persistance.StorageFile;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class StorageFileTest {

    @Test
    public void testSaveToJsonFile() {
        // Create a test instance
        Document instance = new Document(2, "Test", "123", "ghc", 56, 54, 65);

        // Save the instance to a JSON file
        StorageFile.saveToJsonFile(instance, "documentTest.json");

        // Read the saved instances from JSON file
        List<Document> instancesRead = StorageFile.readObjectsFromJsonFile("documentTest.json");

        // Check if the instance was saved correctly
        // assertTrue(instancesRead.contains(instance));
        
    }

}