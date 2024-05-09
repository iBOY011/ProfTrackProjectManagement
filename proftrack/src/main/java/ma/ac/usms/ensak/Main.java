package ma.ac.usms.ensak;

import java.util.Date;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.persistance.StorageFile;
import ma.ac.usms.ensak.persistance.impl.WorkSessionImpl;

public class Main {
    public static void main(String[] args) {
        String relativePath = "proftrack\\src\\main\\resources\\databases\\DocumentTest.json";
        // Create a test instance
        // Save the instance to a JSON file

        List<Document> instancesRead = StorageFile.readObjectsFromJsonFile(relativePath, Document.class);
        for (Document d : instancesRead) {
            System.out.println(d.getId());
            System.out.println(d.getDescription());
            System.out.println(d.getDateAdded());
            System.out.println(d.getPath());
            System.out.println(d.getId_project());
        }

        System.out.println("\n\n\n\n");

        WorkSession ws = new WorkSession("Test", new Date(), new Date(), "123", "123");
        ws.getDocumentIds().add("3b915a8c-b087-4774-bdfa-ca1c89c37bdf");
        WorkSessionImpl wsi = new WorkSessionImpl();
        wsi.addWorkSession(ws);
        wsi.getAllSeancesTravail().forEach(w -> {
            System.out.println(w.getId());
            System.out.println(w.getDescription());
            System.out.println(w.getId_project());
        });

    }
}