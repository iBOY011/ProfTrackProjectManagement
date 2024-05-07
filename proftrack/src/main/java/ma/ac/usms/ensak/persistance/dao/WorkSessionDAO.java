package ma.ac.usms.ensak.persistance.dao;
/**
 * 
 */
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.WorkSession;

public interface WorkSessionDAO {
    void createworkSession(WorkSession workSession);
    WorkSession readworkSession(int idworkSession);
    void updateworkSession(WorkSession workSession);
    void deleteworkSession(int idworkSession);
    List<WorkSession> getAllSeancesTravail();
    List<WorkSession> getSeancesTravailByProject(int idProjet);
    List<WorkSession> searchSeancesTravailByKeyword(String keyword);
}
