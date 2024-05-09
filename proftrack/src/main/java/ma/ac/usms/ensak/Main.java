package ma.ac.usms.ensak;

import java.util.Date;
import java.util.List;


import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.metier.management.DocSessionManager;
import ma.ac.usms.ensak.metier.management.DocumentManager;
import ma.ac.usms.ensak.metier.management.WorkSessionManager;


public class Main {
    public static void main(String[] args) {
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

    }
}