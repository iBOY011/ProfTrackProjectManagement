package ma.ac.usms.ensak.persistance.impl;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocSession;
import ma.ac.usms.ensak.persistance.dao.DocSessionDAO;
import ma.ac.usms.ensak.persistance.StorageFile;

public class DocSessionImpl implements DocSessionDAO {
    private final String DOCSESSION_FILE_PATH = "src\\main\\resources\\databases\\DocSession.json";


    @Override
    public void addDocSession(DocSession docSession) {
        List<DocSession> docSessions = getAllDocSessions();
        if (docSessions == null) {
            docSessions = new ArrayList<>(); // Initialize the list if it's null
        }
        docSessions.add(docSession);
        saveToJsonFile(docSessions, DOCSESSION_FILE_PATH);
    }

    @Override
    public DocSession getDocSessionByIdSession(String idDocSession) {
        List<DocSession> docSessions = getAllDocSessions();
        for (DocSession docSession : docSessions) {
            if (docSession.getIdSession().equals(idDocSession)) {
                return docSession;
            }
        }
        return null;
    }

    @Override
    public DocSession getDocSessionByIdDoc(String idDocSession) {
        List<DocSession> docSessions = getAllDocSessions();
        for (DocSession docSession : docSessions) {
            if (docSession.getIdDoc().equals(idDocSession)) {
                return docSession;
            }
        }
        return null;
    }

    @Override
    public void updateDocSession(DocSession docSession) {
        List<DocSession> docSessions = getAllDocSessions();
        for (int i = 0; i < docSessions.size(); i++) {
            DocSession docSession1 = docSessions.get(i);
            if (docSession1.getIdSession().equals(docSession.getIdSession())) {
                docSessions.set(i, docSession);
                break;
            }
        }
        saveToJsonFile(docSessions, DOCSESSION_FILE_PATH);
    }

    @Override
    public void deleteDocSession(String idDocSession) {
        List<DocSession> docSessions = getAllDocSessions();
        docSessions.removeIf(docSession -> docSession.getIdSession().equals(idDocSession));
        saveToJsonFile(docSessions, DOCSESSION_FILE_PATH);
    }

    @Override
    public List<DocSession> getAllDocSessions() {
        return StorageFile.readObjectsFromJsonFile(DOCSESSION_FILE_PATH, DocSession.class);
    }

    private void saveToJsonFile(List<DocSession> docSessions, String filePath) {
        StorageFile.saveToJsonFile(docSessions, filePath);
    }
    
}
