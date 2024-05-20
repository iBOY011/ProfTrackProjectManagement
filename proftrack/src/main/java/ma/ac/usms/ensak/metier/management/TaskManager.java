package ma.ac.usms.ensak.metier.management;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.persistance.impl.ProjectImpl;
import ma.ac.usms.ensak.persistance.impl.TaskImpl;
import ma.ac.usms.ensak.util.Status;
import ma.ac.usms.ensak.util.Category;
import java.util.List;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.persistance.impl.ProjectImpl;
import ma.ac.usms.ensak.persistance.impl.TaskImpl;
import ma.ac.usms.ensak.util.Status;
import ma.ac.usms.ensak.util.Category;


/**
 * The TaskManager class is responsible for managing tasks in a project management system.
 * It provides methods for creating, updating, and deleting tasks, as well as searching and filtering tasks based on various criteria.
 * The TaskManager class uses a TaskImpl object to interact with the underlying data storage.
 */

public class TaskManager {

    private List<Task> tasks;
    private TaskImpl taskImpl;

    public TaskManager() {
        tasks = new ArrayList<Task>();
        taskImpl = new TaskImpl();
    }

    /**
     * Sorts the tasks in ascending order based on their start dates.
     */
    public void sort() {
        tasks.sort((Task t1, Task t2) -> t1.getStart_date().compareTo(t2.getStart_date()));
    }

    /**
     * @param task
     */
    public void validate(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("The task cannot be null.");
        }
        if (task.getTitle() == null) {
            throw new IllegalArgumentException("The title cannot be null.");
        }
        if (task.getDescription() == null) {
            throw new IllegalArgumentException("The description cannot be null.");
        }
    }

    /**
     * @param title
     * @param description
     * @param start_date
     * @param end_date
     * @param status
     * @param id_project
     * @param id_ListToDo
     */
    public void createTask(
            String title,
            String description,
            Date start_date,
            Date end_date,
            Status status,
            String id_project,
            String id_ListToDo) {
        Task task = new Task(
                title,
                description,
                start_date,
                end_date,
                status,
                id_project,
                id_ListToDo);
        validate(task);
        taskImpl.addTask(task);
    }

    public void createTask(
            String title,
            String description,
            Date start_date,
            Date end_date,
            Status status,
            String id,
            boolean FLAG) {
        if (FLAG == true) {
            Task task = new Task(
                    title,
                    description,
                    start_date,
                    end_date,
                    status,
                    id,
                    "");
            validate(task);
            taskImpl.addTask(task);
        } else {
            Task task = new Task(
                    title,
                    description,
                    start_date,
                    end_date,
                    status,
                    "",
                    id);
            validate(task);
            taskImpl.addTask(task);
        }
    }

    /**
     * Updates the given task.
     *
     * @param task The task to be updated.
     */
    public void updateTask(Task task) {
        validate(task);
        taskImpl.updateTask(task);
    }

    /**
     * Removes a task with the specified ID.
     *
     * @param id the ID of the task to be removed
     * @throws IllegalArgumentException if the ID is null or if the task does not exist
     */
    public void removeTask(String id) {
        if (id == null) {
            throw new IllegalArgumentException("The id cannot be null.");
        }
        Task task = taskImpl.getTaskById(id);
        if (task == null) {
            throw new IllegalArgumentException("The task does not exist.");
        }
        taskImpl.deleteTask(id);
    }

    /**
     * Represents a task in the project management system.
     */
    public Task searchTaskById(String id) {
        if (id == null) {
            throw new IllegalArgumentException("The id cannot be null.");
        }
        Task task = taskImpl.getTaskById(id);
        if (task == null) {
            throw new IllegalArgumentException("The task does not exist.");
        }
        return task;
    }

    /**
     * Retrieves a list of all tasks.
     *
     * @return a list of Task objects representing all tasks.
     */
    public List<Task> listTasks() {
        return taskImpl.getAllTasks();
    }

    /**
     * Retrieves a list of tasks associated with a specific project ID.
     *
     * @param id The ID of the project.
     * @return A list of tasks associated with the specified project ID.
     * @throws IllegalArgumentException If the provided project ID is null or if the project does not exist.
     */
    public List<Task> listTasksByIdProject(String id) {
        if (id == null) {
            throw new IllegalArgumentException("The id cannot be null.");
        }
        ProjectImpl projectImpl = new ProjectImpl();
        Project project1 = projectImpl.getProjectById(id);
        if (project1 == null) {
            throw new IllegalArgumentException("The project does not exist.");
        }
        tasks = taskImpl.getAllTasks();
        List<Task> tasks1 = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getId_project().contentEquals(id)) {
                tasks1.add(task);
            }
        }
        return tasks1;
    }

    /**
     * Retrieves a list of tasks based on the provided id of the list to do.
     *
     * @param id The id of the list to do.
     * @return A list of tasks associated with the provided id.
     * @throws IllegalArgumentException if the id is null.
     */
    public List<Task> listTasksByIdListToDo(String id) {
        if (id == null) {
            throw new IllegalArgumentException("The id cannot be null.");
        }
        tasks = taskImpl.getAllTasks();
        List<Task> tasks1 = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getId_ListToDo().contentEquals(id)) {
                tasks1.add(task);
            }
        }
        return tasks1;
    }

    /**
     * Returns a list of tasks with the specified status.
     *
     * @param status the status of the tasks to retrieve
     * @return a list of tasks with the specified status
     * @throws IllegalArgumentException if the status is null
     */
    public List<Task> listTasksByStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("The status cannot be null.");
        }
        tasks = taskImpl.getAllTasks();
        List<Task> tasks1 = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getStatus() == status) {
                tasks1.add(task);
            }
        }
        return tasks1;
    }

    /**
     * Searches for tasks that contain a specific keyword in their description.
     *
     * @param keyword the keyword to search for in task descriptions
     * @return a list of tasks that contain the specified keyword in their description
     * @throws IllegalArgumentException if the keyword is null
     */
    public List<Task> searchTasksByKeyword(String keyword) {
        if (keyword == null) {
            throw new IllegalArgumentException("The keyword cannot be null.");
        }
        tasks = taskImpl.getAllTasks();
        List<Task> tasks1 = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                tasks1.add(task);
            }
        }
        return tasks1;
    }

    /**
     * Filters a list of tasks based on the specified status.
     *
     * @param tasks  the list of tasks to filter
     * @param status the status to filter the tasks by
     * @return a new list containing only the tasks with the specified status
     * @throws IllegalArgumentException if the status is null
     */
    public List<Task> filterTasksByStatus(List<Task> tasks, Status status) {
        if (status == null) {
            throw new IllegalArgumentException("The status cannot be null.");
        }
        return tasks.stream().filter(task -> task.getStatus() == status).toList();
    }

    /**
     * Filters the tasks by the specified project category.
     *
     * @param category the category to filter the tasks by
     * @return a list of tasks that belong to the specified category
     * @throws IllegalArgumentException if the category is null
     */
    public List<Task> filterTasksByProjectCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("The category cannot be null.");
        }
        tasks = taskImpl.getAllTasks();
        List<Task> tasks1 = new ArrayList<Task>();
        for (Task task : tasks) {
            ProjectImpl projectImpl = new ProjectImpl();
            Project project = projectImpl.getProjectById(task.getId_project());
            if (project.getCategory() == category) {
                tasks1.add(task);
            }
        }
        return tasks1;
    }

    /**
     * Filters the tasks based on the given date.
     *
     * @param date The date to filter the tasks by.
     * @return A list of tasks that have the same start date as the given date.
     * @throws IllegalArgumentException if the date is null.
     */
    public List<Task> filterTasksByDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date cannot be null.");
        }
        tasks = taskImpl.getAllTasks();
        List<Task> tasks1 = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getStart_date().compareTo(date) == 0) {
                tasks1.add(task);
            }
        }
        return tasks1;
    }

    /**
     * Retrieves a list of tasks that are scheduled for today.
     *
     * @return A list of tasks scheduled for today.
     */
    public List<Task> getTasksOfToday() {
        List<Task> tasks = taskImpl.getAllTasks();
        List<Task> result = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (Task task : tasks) {
            Date startDate = task.getStart_date();
            Date endDate = task.getEnd_date();

            LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if ((startLocalDate.equals(today) || startLocalDate.isBefore(today)) &&
                    (endLocalDate.equals(today) || endLocalDate.isAfter(today))) {
                result.add(task);
            }
        }

        return result;
    }

}
