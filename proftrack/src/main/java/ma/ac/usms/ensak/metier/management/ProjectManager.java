package ma.ac.usms.ensak.metier.management;

import java.util.Date;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.persistance.impl.ProjectImpl;
import ma.ac.usms.ensak.util.Category;
import ma.ac.usms.ensak.util.Type;

/**
 * The ProjectManager class is responsible for managing projects.
 * It provides methods for creating, updating, removing, searching, listing, filtering, sorting, archiving, and cloning projects.
 */
public class ProjectManager {
    private TaskManager taskManager;
    private WorkSessionManager workSessionManager;

    /**
     * Creates a new project with the given details and adds it to the database.
     * 
     * @param title       The title of the project.
     * @param description The description of the project.
     * @param startDate   The start date of the project.
     * @param endDate     The end date of the project.
     * @param category    The category of the project.
     * @param type        The type of the project.
     */
    public void createProject(String title, String description, Date startDate, Date endDate, Category category,
            Type type) {
        Project project = new Project(title, description, startDate, endDate, category, type, false);
        ProjectImpl projectImpl = new ProjectImpl();
        projectImpl.addProject(project);
    }

    /**
     * Updates the details of the given project in the database.
     * 
     * @param project The project to be updated.
     */
    public void updateProject(Project project) {
        ProjectImpl projectImpl = new ProjectImpl();
        projectImpl.updateProject(project);
    }

    /**
     * Removes the project with the given ID from the database.
     * 
     * @param projectId The ID of the project to be removed.
     */
    public void removeProject(String projectId) {
        ProjectImpl projectImpl = new ProjectImpl();
        projectImpl.deleteProject(projectId);
    }

    /**
     * Searches for a project with the given ID in the database.
     * 
     * @param projectId The ID of the project to search for.
     * @return The project with the given ID, or null if not found.
     */
    public Project searchProjectById(String projectId) {
        ProjectImpl projectImpl = new ProjectImpl();
        return projectImpl.getProjectById(projectId);
    }

    /**
     * Lists all projects in the database.
     * 
     * @return A list of all projects.
     */
    public List<Project> listProjects() {
        ProjectImpl projectImpl = new ProjectImpl();
        return projectImpl.getAllProjects();
    }

    /**
     * Checks if the syntax of the project details is valid.
     * 
     * @param title       The title of the project.
     * @param description The description of the project.
     * @param startDate   The start date of the project.
     * @param endDate     The end date of the project.
     * @param category    The category of the project.
     * @param type        The type of the project.
     * @return true if the syntax is valid, false otherwise.
     */
    public boolean isValidateSyntax(String title, String description, Date startDate, Date endDate, Category category,
            String type) {
        if (title == null || title.isEmpty() || title.isBlank()) {
            return false;
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            return false;
        }
        if (startDate == null || startDate.before(new Date()) || startDate.after(endDate)) {
            return false;
        }
        if (endDate == null || (endDate.equals(new Date()) && endDate.before(startDate))) {
            return false;
        }
        if (category == null) {
            return false;
        }
        return (type == null || type.isEmpty() || type.isBlank());
    }

    /**
     * Filters the given list of projects by category.
     * 
     * @param projects The list of projects to be filtered.
     * @param category The category to filter by.
     * @return A new list of projects filtered by category.
     */
    public List<Project> filterProjectsByCategory(List<Project> projects, String category) {
        return projects.stream().filter(project -> project.getCategory().equals(category)).toList();
    }

    /**
     * Filters the given list of projects by type.
     * 
     * @param projects The list of projects to be filtered.
     * @param type     The type to filter by.
     * @return A new list of projects filtered by type.
     */
    public List<Project> filterProjectsByType(List<Project> projects, String type) {
        return projects.stream().filter(project -> project.getType().equals(type)).toList();
    }

    /**
     * Filters the given list of projects by date range.
     * 
     * @param projects  The list of projects to be filtered.
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @return A new list of projects filtered by date range.
     */
    public List<Project> filterProjectsByDate(List<Project> projects, Date startDate, Date endDate) {
        return projects.stream()
                .filter(project -> project.getStart_date().after(startDate) && project.getEnd_date().before(endDate))
                .toList();
    }

    /**
     * Filters the given list of projects by status (archived or not).
     * 
     * @param projects The list of projects to be filtered.
     * @param archived The status to filter by (true for archived, false for not archived).
     * @return A new list of projects filtered by status.
     */
    public List<Project> filterProjectsByStatus(List<Project> projects, boolean archived) {
        return projects.stream().filter(project -> project.isArchived() == archived).toList();
    }

    /**
     * Sorts the given list of projects by start date in ascending order.
     * 
     * @param projects The list of projects to be sorted.
     * @return A new list of projects sorted by start date.
     */
    public List<Project> sortProjectsByStartDate(List<Project> projects) {
        return projects.stream().sorted((p1, p2) -> p1.getStart_date().compareTo(p2.getStart_date())).toList();
    }

    /**
     * Sorts the given list of projects by end date in ascending order.
     * 
     * @param projects The list of projects to be sorted.
     * @return A new list of projects sorted by end date.
     */
    public List<Project> sortProjectsByEndDate(List<Project> projects) {
        return projects.stream().sorted((p1, p2) -> p1.getEnd_date().compareTo(p2.getEnd_date())).toList();
    }

    /**
     * Sorts the given list of projects by category in ascending order.
     * 
     * @param projects The list of projects to be sorted.
     * @return A new list of projects sorted by category.
     */
    public List<Project> sortProjectsByCategory(List<Project> projects) {
        return projects.stream().sorted((p1, p2) -> p1.getCategory().compareTo(p2.getCategory())).toList();
    }

    /**
     * Sorts the given list of projects by type in ascending order.
     * 
     * @param projects The list of projects to be sorted.
     * @return A new list of projects sorted by type.
     */
    public List<Project> sortProjectsByType(List<Project> projects) {
        return projects.stream().sorted((p1, p2) -> p1.getType().compareTo(p2.getType())).toList();
    }

    /**
     * Archives the given project by setting its archived status to true and updating it in the database.
     * 
     * @param project The project to be archived.
     */
    public void archiveProject(Project project) {
        project.setArchived(true);
        updateProject(project);
    }

    /**
     * Archives the project with the given ID by checking if all its tasks are done.
     * If there are still open tasks, an exception is thrown.
     * 
     * @param id The ID of the project to be archived.
     * @throws IllegalArgumentException If there are still open tasks in the project.
     */
    public void archiveProjectByTasks(String id) {
        List<Task> tasks;
        tasks = taskManager.listTasksByIdProject(id);
        for (Task task : tasks) {
            if (!task.wasDone()) {
                throw new IllegalArgumentException("The project cannot be archived because there are still open tasks");
            }
        }
        archiveProject(searchProjectById(id));
    }

    /**
     * Archives the project by checking if all its work sessions are closed.
     * If there are still open work sessions, an exception is thrown.
     * 
     * @param project The project to be archived.
     * @throws IllegalArgumentException If there are still open work sessions in the project.
     */
    public void archiveProjectByWorkSessions(Project project) {
        List<WorkSession> workSessions;
        workSessions = workSessionManager.listWorkSessionsByIdProject(project.getId());
        for (WorkSession workSession : workSessions) {
            if (!workSession.isClosed()) {
                throw new IllegalArgumentException(
                        "The project cannot be archived because there are still open work sessions");
            }
        }
        archiveProject(project);
    }

    /**
     * Clones the given project by creating a new project with the same details and adding it to the database.
     * 
     * @param project The project to be cloned.
     */
    public void cloneProject(Project project) {
        createProject(project.getTitle(), project.getDescription(), project.getStart_date(), project.getEnd_date(),
                project.getCategory(), project.getType());
    }

    /**
     * The main method is used for testing the ProjectManager class.
     * It creates a new project, lists all projects, and prints their titles.
     * 
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        ProjectManager projectManager = new ProjectManager();
        projectManager.createProject("Test", "Test", new Date(), new Date(), Category.ACADEMIC, Type.PFE);
        projectManager.listProjects().forEach(project -> {
            System.out.println(project.getTitle());
        });
    }
}
