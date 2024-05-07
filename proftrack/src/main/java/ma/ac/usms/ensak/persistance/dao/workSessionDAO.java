package ma.ac.usms.ensak.persistance.dao;
/**
 * 
 */
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.workSession;

public interface workSessionDAO {
    void addWorkSession(workSession workSession);
    workSession getWorkSessionById(int idworkSession);
    void updateWorkSession(workSession workSession);
    void deleteWorkSession(int idworkSession);
    List<workSession> getAllSeancesTravail();
    List<workSession> getSeancesTravailByProject(int idProjet);
    List<workSession> searchSeancesTravailByKeyword(String keyword);
}
