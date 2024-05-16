
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
    private static final String TASK_FILE_PATH = "src\\main\\resources\\databases\\TaskFile.json";
<<<<<<< HEAD
=======

>>>>>>> 45a786bfa39adcf625216e588c4d78f45c8d147a

    /**
     * Creates a new task and saves it to the storage file.
     *
     * @param task The task to be created.
     */
    @Override
    public void addTask(Task task) {
        List<Task> tasks = StorageFile.readObjectsFromJsonFile(TASK_FILE_PATH, Task.class);
        if (tasks == null) {
            tasks = new ArrayList<>(); // Initialize the list if it's null
        }
        tasks.add(task);
        StorageFile.saveToJsonFile(tasks, TASK_FILE_PATH);
    }

    /**
     * Reads a task with the specified ID from the storage file.
     *
     * @param idtask The ID of the task to be read.
     * @return The task with the specified ID, or null if not found.
     */
    @Override
    public Task getTaskById(String idtask) {
        List<Task> tasks = StorageFile.readObjectsFromJsonFile(TASK_FILE_PATH, Task.class);

        for (Task t : tasks) {
            if (t.getId().contentEquals(idtask)) {
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
    public void updateTask(Task task) {
        List<Task> tasks = getAllTasks();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == task.getId()) {
                tasks.set(i, task);
                break;
            }
        }

        StorageFile.saveToJsonFile(tasks, TASK_FILE_PATH);
    }

    /**
     * Deletes a task with the specified ID from the storage file.
     *
     * @param idtask The ID of the task to be deleted.
     */
    @Override
    public void deleteTask(String idtask) {
        List<Task> tasks = getAllTasks();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == idtask) {
                tasks.remove(i);
                break;
            }
        }

        StorageFile.saveToJsonFile(tasks, TASK_FILE_PATH);
    }

    /**
     * Retrieves all tasks from the storage file.
     *
     * @return A list of all tasks.
     */
    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = StorageFile.readObjectsFromJsonFile(TASK_FILE_PATH, Task.class);

        return tasks;
    }

    /**
     * Retrieves tasks associated with a specific project from the storage file.
     *
     * @param idProjet The ID of the project.
     * @return A list of tasks associated with the specified project.
     */
    @Override
    public List<Task> getTasksByProject(String idProjet) {
        List<Task> tasks = getAllTasks();

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
     * @return A list of tasks containing the specified keyword in their
     *         description.
     */
    @Override
    public List<Task> searchTasksByKeyword(String keyword) {
        List<Task> tasks = getAllTasks();

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
    public List<Task> getTasksByCategory(String category) {
        return null;
    }
}
