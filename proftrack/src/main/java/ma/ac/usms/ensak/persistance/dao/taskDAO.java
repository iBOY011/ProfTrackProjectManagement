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
    void addTask(Task task);
    Task getTaskById(String idtask);
    void updateTask(Task task);
    void deleteTask(String idtask);
    List<Task> getAllTasks();
    List<Task> getTasksByProject(String idProjet);
    List<Task> searchTasksByKeyword(String keyword);
    List<Task> getTasksByCategory(String category);
}
