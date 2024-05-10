package ma.ac.usms.ensak.persistance.dao;

import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocSession;

public interface DocSessionDAO {
    
    void addDocSession(DocSession docSession);
    
    DocSession getDocSessionByIdSession(String idDocSession);
    DocSession getDocSessionByIdDoc(String idDocSession);
    
    void updateDocSession(DocSession docSession);
    
    void deleteDocSession(String idDocSession);
    
    List<DocSession> getAllDocSessions();
}
