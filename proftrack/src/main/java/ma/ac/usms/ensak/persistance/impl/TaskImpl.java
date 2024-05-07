
package ma.ac.usms.ensak.persistance.impl;
import java.util.List;
import java.util.ArrayList;
import ma.ac.usms.ensak.persistance.StorageFile;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.persistance.dao.TaskDAO;


/**
 * Implementation of the taskDAO interface for managing tasks.
 */
public class TaskImpl implements TaskDAO {

    private int lastTaskId = 0;

    /**
     * Creates a new task and saves it to the storage file.
     *
     * @param task The task to be created.
     */
    @Override
    public void createtask(Task task) {
        List<Task> tasks = getAlltasks();

        if (!tasks.isEmpty()) {
            Task lastTask = tasks.get(tasks.size() - 1);
            lastTaskId = lastTask.getId();
        }

        lastTaskId++;
        task.setId(lastTaskId);

        tasks.add(task);

        StorageFile.saveToJsonFile(tasks, "TaskFile.json");
    }

    /**
     * Reads a task with the specified ID from the storage file.
     *
     * @param idtask The ID of the task to be read.
     * @return The task with the specified ID, or null if not found.
     */
    @Override
    public Task readtask(int idtask) {
        List<Task> tasks = StorageFile.readObjectsFromJsonFile("TaskFile.json");

        for (Task t : tasks) {
            if (t.getId() == idtask) {
                return t;
            }
        }
        return null;
    }

    /**
     * Updates an existing task and saves it to the storage file.
     *
     * @param task The task to be updated.
     */
    @Override
    public void updatetask(Task task) {
        List<Task> tasks = getAlltasks();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == task.getId()) {
                tasks.set(i, task);
                break;
            }
        }

        StorageFile.saveToJsonFile(tasks, "TaskFile.json");
    }

    /**
     * Deletes a task with the specified ID from the storage file.
     *
     * @param idtask The ID of the task to be deleted.
     */
    @Override
    public void deletetask(int idtask) {
        List<Task> tasks = getAlltasks();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == idtask) {
                tasks.remove(i);
                break;
            }
        }

        StorageFile.saveToJsonFile(tasks, "TaskFile.json");
    }

    /**
     * Retrieves all tasks from the storage file.
     *
     * @return A list of all tasks.
     */
    @Override
    public List<Task> getAlltasks() {
        List<Task> tasks = StorageFile.readObjectsFromJsonFile("TaskFile.json");

        return tasks;
    }

    /**
     * Retrieves tasks associated with a specific project from the storage file.
     *
     * @param idProjet The ID of the project.
     * @return A list of tasks associated with the specified project.
     */
    @Override
    public List<Task> gettasksByProject(int idProjet) {
        List<Task> tasks = getAlltasks();

        List<Task> tasksByProject = new ArrayList<>();

        for (Task t : tasks) {
            if (t.getId_project() == idProjet) {
                tasksByProject.add(t);
            }
        }

        return tasksByProject;
    }

    /**
     * Searches for tasks containing a specific keyword in their description.
     *
     * @param keyword The keyword to search for.
     * @return A list of tasks containing the specified keyword in their description.
     */
    @Override
    public List<Task> searchtasksByKeyword(String keyword) {
        List<Task> tasks = getAlltasks();

        List<Task> tasksByKeyword = new ArrayList<>();

        for (Task t : tasks) {
            if (t.getDescription().contains(keyword)) {
                tasksByKeyword.add(t);
            }
        }

        return tasksByKeyword;
    }

    /**
     * Retrieves tasks associated with a specific category from the storage file.
     *
     * @param category The category of the tasks.
     * @return A list of tasks associated with the specified category.
     */
    @Override
    public List<Task> gettasksByCategory(String category) {
        return null;
    }
}
