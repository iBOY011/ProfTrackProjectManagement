package ma.ac.usms.ensak.metier.management;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocSession;
import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.persistance.impl.DocSessionImpl;

public class DocSessionManager {
        private DocSessionImpl DMI;
        private List<DocSession> docSessions;

        public DocSessionManager() {
            this.docSessions = new ArrayList<DocSession>();
            this.DMI = new DocSessionImpl();
        }

        public void validate(DocSession docSession) {
            if (docSession == null) {
                throw new IllegalArgumentException("The document session must not be null.");
            }
            if (docSession.getIdDoc() == null || docSession.getIdSession() == null) {
                throw new IllegalArgumentException("The document ID and the session ID must not be null.");
            }
        }

        public void createDocSession(WorkSession ws, Document doc) {
            DocSession docSession = new DocSession();
            docSession.setIdDoc(doc.getId());
            docSession.setIdSession(ws.getId());
            validate(docSession);
            DMI.addDocSession(docSession);
        }
    
        public void updateDocSession(DocSession docSession) {
            validate(docSession);
            DMI.updateDocSession(docSession);;
        }
    
        public void deleteDocSession(String idDocSession) {
            if (idDocSession == null) {
                throw new IllegalArgumentException("The ID of the document session must not be null.");
                
            }
            DMI.deleteDocSession(idDocSession);
        }
    
        public List<DocSession> ListAllDocSessions() {
            return DMI.getAllDocSessions();
        }

        // list of all docs have id session
        public List<Document> searchDocSessionByIdSession(String idSession) {
            List<Document> docs = new ArrayList<Document>();
            docSessions = DMI.getAllDocSessions();
            for (DocSession docSession : docSessions) {
                if (docSession.getIdSession().equals(idSession)) {
                    docs.add(new DocumentManager().searchDocumentById(docSession.getIdDoc()));
                }
            }
            return docs;
        }

        // list of all sessions have id doc
        public List<WorkSession> searchDocSessionByIdDoc(String idDoc) {
            List<WorkSession> sessions = new ArrayList<WorkSession>();
            docSessions = DMI.getAllDocSessions();
            for (DocSession docSession : docSessions) {
                if (docSession.getIdDoc().equals(idDoc)) {
                    sessions.add(new WorkSessionManager().searchWorkSessionById(docSession.getIdSession()));
                }
            }
            return sessions;
        }
}
