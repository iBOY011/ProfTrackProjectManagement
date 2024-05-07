/**
 * 
 */
package ma.ac.usms.ensak.persistance.dao;

/**
 * 
 */
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Task;

public interface TaskDAO {
    void createtask(Task task);
    Task readtask(int idtask);
    void updatetask(Task task);
    void deletetask(int idtask);
    List<Task> getAlltasks();
    List<Task> gettasksByProject(int idProjet);
    List<Task> searchtasksByKeyword(String keyword);
    List<Task> gettasksByCategory(String category);
}
