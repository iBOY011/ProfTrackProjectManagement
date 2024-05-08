package ma.ac.usms.ensak.persistance.dao;
/**
 * 
 */
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.WorkSession;

public interface WorkSessionDAO {
    void addWorkSession(WorkSession workSession);
    WorkSession getWorkSessionById(String idworkSession);
    void updateWorkSession(WorkSession workSession);
    void deleteWorkSession(String idworkSession);
    List<WorkSession> getAllSeancesTravail();
    List<WorkSession> getSeancesTravailByProject(String idProjet);
    List<WorkSession> searchSeancesTravailByKeyword(String keyword);
}
