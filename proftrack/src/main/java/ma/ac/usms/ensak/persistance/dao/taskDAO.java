/**
 * 
 */
package ma.ac.usms.ensak.persistance.dao;

/**
 * 
 */
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Task;

public interface taskDAO {
    void addTask(Task task);
    Task getTaskById(int idtask);
    void updateTask(Task task);
    void deleteTask(int idtask);
    List<Task> getAllTasks();
    List<Task> getTasksByProject(int idProjet);
    List<Task> searchTasksByKeyword(String keyword);
    List<Task> getTasksByCategory(String category);
}
