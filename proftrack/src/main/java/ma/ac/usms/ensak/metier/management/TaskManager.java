package ma.ac.usms.ensak.metier.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.persistance.impl.ProjectImpl;
import ma.ac.usms.ensak.persistance.impl.TaskImpl;
import ma.ac.usms.ensak.util.Status;
import ma.ac.usms.ensak.util.Category;

public class TaskManager {

    private List<Task> tasks;
    private TaskImpl taskImpl;

    public TaskManager() {
        tasks = new ArrayList<Task>();
        taskImpl = new TaskImpl();
    }

    // sort tasks
    public void sort() {
        // sort the tasks by start_date
        tasks.sort((Task t1, Task t2) -> t1.getStart_date().compareTo(t2.getStart_date()));
    }

    // validate task
    public void validate(Task task) {
        // check if the task is not null
        if (task == null) {
            throw new IllegalArgumentException("The task cannot be null.");
        }
        // check if the title is not null
        if (task.getTitle() == null) {
            throw new IllegalArgumentException("The title cannot be null.");
        }
        // check if the description is not null
        if (task.getDescription() == null) {
            throw new IllegalArgumentException("The description cannot be null.");
        }
        // check if the start_date is not null and greater than the current date
        if (task.getStart_date() == null ||
                task.getStart_date().compareTo(new Date()) < 0) {
            throw new IllegalArgumentException("The start date cannot be null.");
        }
        // check if the end_date is not null and greater than the start_date
        if (task.getEnd_date() == null ||
                task.getEnd_date().compareTo(task.getStart_date()) < 0) {
            throw new IllegalArgumentException("The end date cannot be null.");
        }
    }

    // add task with id project and id list to do
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
        tasks.add(task);
        taskImpl.addTask(task);
    }

    // add task with id project and without id list to do
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
                    null);
            validate(task);
            tasks.add(task);
            taskImpl.addTask(task);
        } else {
            Task task = new Task(
                    title,
                    description,
                    start_date,
                    end_date,
                    status,
                    null,
                    id);
            validate(task);
            taskImpl.addTask(task);
        }
    }

    // update task
    public void updateTask(Task task, String id) {
        validate(task);
        taskImpl.updateTask(task);
    }

    // delete task
    public void removeTask(String id) {
        // check if the id is not null
        if (id == null) {
            throw new IllegalArgumentException("The id cannot be null.");
        }
        // check if the task exists
        Task task = taskImpl.getTaskById(id);
        if (task == null) {
            throw new IllegalArgumentException("The task does not exist.");
        }
        taskImpl.deleteTask(id);
    }

    // get task by id
    public Task searchTaskById(String id) {
        // check if the id is not null
        if (id == null) {
            throw new IllegalArgumentException("The id cannot be null.");
        }
        // check if the task exists
        Task task = taskImpl.getTaskById(id);
        if (task == null) {
            throw new IllegalArgumentException("The task does not exist.");
        }
        return task;
    }

    // get all tasks
    public List<Task> listTasks() {
        return taskImpl.getAllTasks();
    }

    // get all tasks by id project
    public List<Task> listTasksByIdProject(Project project) {
        // check if the project is not null
        if (project == null) {
            throw new IllegalArgumentException("The project cannot be null.");
        }
        // check if the id is not null
        if (project.getId() == null) {
            throw new IllegalArgumentException("The id cannot be null.");
        }
        // check if the project exists
        ProjectImpl projectImpl = new ProjectImpl();
        Project project1 = projectImpl.getProjectById(project.getId());
        if (project1 == null) {
            throw new IllegalArgumentException("The project does not exist.");
        }
        tasks = taskImpl.getAllTasks();
        List<Task> tasks1 = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getId_project() == project.getId()) {
                tasks1.add(task);
            }
        }
        return tasks1;
    }

    // get all tasks by id list to do
    public List<Task> listTasksByIdListToDo(String id) {
        // check if the id is not null
        if (id == null) {
            throw new IllegalArgumentException("The id cannot be null.");
        }
        tasks = taskImpl.getAllTasks();
        List<Task> tasks1 = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getId_ListToDo() == id) {
                tasks1.add(task);
            }
        }
        return tasks1;
    }

    // get all tasks by status
    public List<Task> listTasksByStatus(Status status) {
        // check if the status is not null
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

    // get all tasks by keyword
    public List<Task> searchTasksByKeyword(String keyword) {
        // check if the keyword is not null
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

    // filter tasks by status
    public List<Task> filterTasksByStatus(List<Task> tasks, Status status) {
        // check if the status is not null
        if (status == null) {
            throw new IllegalArgumentException("The status cannot be null.");
        }
        return tasks.stream().filter(task -> task.getStatus() == status).toList();
    }

    // get all tasks by project category
    public List<Task> filterTasksByProjectCategory(Category category) {
        // check if the category is not null
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

    // get all tasks by date
    public List<Task> filterTasksByDate(Date date) {
        // check if the date is not null
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
}
