package ma.ac.usms.ensak.metier.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.persistance.impl.taskImpl;

public class TaskManager {
        
        private List<Task> tasks;
        private taskImpl taskImpl;
    
        public TaskManager() {
            tasks = new ArrayList<Task>();
            taskImpl = new taskImpl();
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
                
                Task task = new Task(0, title, description, start_date, end_date, status, id, 0);
                validate(task); 
                tasks.add(task);
                taskImpl.addTask(task);
            } else {
                Task task = new Task(0, title, description, start_date, end_date, status, 0, id );
                validate(task); 
                taskImpl.addTask(task);
            }
        }

        // update task
        public void updateTask(int id, String title, String description, Date start_date, Date end_date, String status, int id_project, int id_ListToDo) {
            Task task = new Task(id, title, description, start_date, end_date, status, id_project, id_ListToDo);
            validate(task);
            taskImpl.updateTask(task);
        }

        public List<Task> listTasksByIdProject(Project project) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'listTasksByIdProject'");
        }
}
