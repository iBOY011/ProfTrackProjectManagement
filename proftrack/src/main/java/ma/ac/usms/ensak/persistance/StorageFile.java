package ma.ac.usms.ensak.persistance;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The `StorageFile` class is used to store files.
 */
public class StorageFile {

	/**
     * Writes objects to a JSON file.
     *
     * @param instances the list of instances to be written to the JSON file
     * @param fileName  the name of the JSON file to write to
     * @param <T>       the type of objects to be written
     */
    public static <T> void saveToJsonFile(List<T> instances, String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(fileName), instances);
            System.out.println("Objects saved to JSON file '" + fileName + "'");
        } catch (IOException e) {
            System.err.println("Error writing to JSON file '" + fileName + "': " + e.getMessage());
        }
    }
    
    /**
     * Reads objects from a JSON file and returns a list of objects.
     *
     * @param fileName the name of the JSON file to read from
     * @param clazz    the class type of the objects to read
     * @param <T>      the type of objects to read
     * @return a list of objects read from the JSON file
     * @throws IOException    if an I/O error occurs
     * @throws ParseException if there is an error in parsing the JSON file
     */
    public static <T> List<T> readObjectsFromJsonFile(String fileName, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        List<T> objects = null;
        try {
            File file = new File(fileName);
            objects = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            System.err.println("Error reading from JSON file: " + e.getMessage());
        }
        return objects;
    }
}
