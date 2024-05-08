package ma.ac.usms.ensak.metier.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.persistance.impl.ProjectImpl;
import ma.ac.usms.ensak.persistance.impl.TaskImpl;

public class TaskManager {
        
        private List<Task> tasks;
        private TaskImpl taskImpl;
    
        public TaskManager() {
            tasks = new ArrayList<Task>();
            taskImpl = new TaskImpl();
        }
    
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
            if (task.getStart_date() == null || task.getStart_date().compareTo(new Date()) < 0) {
                throw new IllegalArgumentException("The start date cannot be null.");
            }
            // check if the end_date is not null and greater than the start_date
            if (task.getEnd_date() == null || task.getEnd_date().compareTo(task.getStart_date()) < 0){
                throw new IllegalArgumentException("The end date cannot be null.");
            }
        }

        // add task with id project and id list to do
        public void createTask(String title, String description, Date start_date, Date end_date, String status, int id_project, int id_ListToDo) {
            Task task = new Task(0, title, description, start_date, end_date, status, id_project, id_ListToDo);
            validate(task);
            tasks.add(task);
            taskImpl.addTask(task);
        }

        // add task with id project and without id list to do
        public void createTask(String title, String description, Date start_date, Date end_date, String status, int id, boolean FLAG) {
            if (FLAG==true) {
                
                Task task = new Task(title, description, start_date, end_date, status, id, 0);
                validate(task); 
                tasks.add(task);
                taskImpl.addTask(task);
            } else {
                Task task = new Task(title, description, start_date, end_date, status, 0, id );
                validate(task); 
                taskImpl.addTask(task);
            }
        }

        // update task
        public void updateTask(Task task, int id) {
            validate(task);
            taskImpl.updateTask(task);
        }

        // delete task
        public void removeTask(int id) {
            // check if the id is not null or less than 0
            if (id <= 0) {
                throw new IllegalArgumentException("The id cannot be less than 0.");
            }
            // check if the task exists
            Task task = taskImpl.getTaskById(id);
            if (task == null) {
                throw new IllegalArgumentException("The task does not exist.");
            }
            taskImpl.deleteTask(id);
        }

        // get task by id
        public Task searchTaskById(int id) {
            // check if the id is not null or less than 0
            if (id <= 0) {
                throw new IllegalArgumentException("The id cannot be less than 0.");
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
            // check if the id is not null or less than 0
            if (project.getId() <= 0) {
                throw new IllegalArgumentException("The id cannot be less than 0.");
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
        public List<Task> listTasksByIdListToDo(int id) {
            // check if the id is not null or less than 0
            if (id <= 0) {
                throw new IllegalArgumentException("The id cannot be less than 0.");
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

}
