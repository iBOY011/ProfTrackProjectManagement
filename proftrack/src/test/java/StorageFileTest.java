import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.persistance.StorageFile;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

public class StorageFileTest {

    @Test
    public void testSaveToJsonFile() throws IOException, ParseException {
        // Create a test instance
        Document instance = new Document("Test","ghc", "123");
        List<Document> documents = List.of(instance);
        // Save the instance to a JSON file
        StorageFile.saveToJsonFile(documents, "src/main/resources/databases/DocumentTest.json");

        // Read the saved instances from JSON file
        List<Document> instancesRead = StorageFile.readObjectsFromJsonFile("src/main/resources/databases/DocumentTest.json", Document.class);

        // Check if the instance was saved correctly
        assertTrue(instancesRead.contains(instance));
        
    }

}