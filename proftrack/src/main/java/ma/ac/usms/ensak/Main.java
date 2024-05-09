package ma.ac.usms.ensak;

import java.util.Date;
import java.util.List;

import javax.print.Doc;

import ma.ac.usms.ensak.metier.POJO.DocSession;
import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
<<<<<<< HEAD
import ma.ac.usms.ensak.metier.management.DocSessionManager;
import ma.ac.usms.ensak.metier.management.DocumentManager;
import ma.ac.usms.ensak.metier.management.WorkSessionManager;
=======
>>>>>>> 2a9206bf8a9708c5c56b79d80cf06f0ee0f81ee7
import ma.ac.usms.ensak.persistance.StorageFile;
import ma.ac.usms.ensak.persistance.impl.WorkSessionImpl;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        DocumentManager documentManager = new DocumentManager();
        WorkSessionManager workSessionManager = new WorkSessionManager();
        DocSessionManager docSessionManager = new DocSessionManager();
        // create a document & a work session
        documentManager.createDocument("description", "path\\to\\yourfile.pdf", "id_project");
        workSessionManager.createWorkSession("description", new Date(), new Date(), "note", "id_project");
        List<Document> documents = documentManager.ListAllDocuments();
        List<WorkSession> workSessions = workSessionManager.getAllWorkSessions();
        Document documentload = documents.get(0);
        WorkSession workSessionload = workSessions.get(0);
        docSessionManager.createDocSession(workSessionload, documentload);
=======
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
>>>>>>> 2a9206bf8a9708c5c56b79d80cf06f0ee0f81ee7

    }
}