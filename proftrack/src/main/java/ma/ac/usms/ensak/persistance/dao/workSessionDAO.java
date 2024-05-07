package ma.ac.usms.ensak.persistance.dao;
/**
 * 
 */
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.WorkSession;

public interface WorkSessionDAO {
    void addWorkSession(WorkSession workSession);
    WorkSession getWorkSessionById(int idworkSession);
    void updateWorkSession(WorkSession workSession);
    void deleteWorkSession(int idworkSession);
    List<WorkSession> getAllSeancesTravail();
    List<WorkSession> getSeancesTravailByProject(int idProjet);
    List<WorkSession> searchSeancesTravailByKeyword(String keyword);
}
