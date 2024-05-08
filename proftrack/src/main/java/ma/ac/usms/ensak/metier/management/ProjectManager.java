package ma.ac.usms.ensak.metier.management;

import java.util.Date;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.persistance.impl.ProjectImpl;

public class ProjectManager {
    private TaskManager taskManager;
    private WorkSessionManager workSessionManager;

    // implementer les methodes CRUD en utilisant les fonctions dans la package DAO

    public void createProject(String title, String description, Date startDate, Date endDate, String category, String type) {
        if (!isValidateSyntax(title, description, startDate, endDate, category, type)) {
            throw new IllegalArgumentException("Invalid syntax");
        }
        else {
            Project project = new Project(title, description, startDate, endDate, category, type, false);
            ProjectImpl projectImpl = new ProjectImpl();
            projectImpl.addProject(project);
        }

    }

    public void updateProject(String title, String description, Date startDate, Date endDate, String category, String type) {
        if (!isValidateSyntax(title, description, startDate, endDate, category, type)) {
            throw new IllegalArgumentException("Invalid syntax");
        }
        else {
            Project project = new Project(title, description, startDate, endDate, category, type, false);
            ProjectImpl projectImpl = new ProjectImpl();
            projectImpl.updateProject(project);
        }
    }

    public void removeProject(Project project) {
        String projectId = String.valueOf(project.getId());
        ProjectImpl projectImpl = new ProjectImpl();
        projectImpl.deleteProject(projectId);
    }

    public Project searchProjectById(String projectId) {
        ProjectImpl projectImpl = new ProjectImpl();
        return projectImpl.getProjectById(projectId);
    }

    public List<Project> listProjects() {
        ProjectImpl projectImpl = new ProjectImpl();
        return projectImpl.getAllProjects();
    }

    public boolean isValidateSyntax(String title, String description, Date startDate, Date endDate, String category, String type) {
        if (title == null || title.isEmpty() || title.isBlank()) {
            return false;
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            return false;
        }
        if (startDate == null || startDate.before(new Date()) || startDate.after(endDate)){
            return false;
        }
        if (endDate == null || (endDate.equals(new Date()) && endDate.before(startDate))) {
            return false;
        }
        if (category == null || category.isEmpty() || category.isBlank()) {
            return false;
        }
        return (type == null || type.isEmpty() || type.isBlank());
    }

    public List<Project> filterProjectsByCategory(List<Project> projects, String category){
        return projects.stream().filter(project -> project.getCategory().equals(category)).toList();
    }

    public List<Project> filterProjectsByType(List<Project> projects, String type){
        return projects.stream().filter(project -> project.getType().equals(type)).toList();
    }

    public List<Project> filterProjectsByDate(List<Project> projects, Date startDate, Date endDate){
        return projects.stream().filter(project -> project.getStart_date().after(startDate) && project.getEnd_date().before(endDate)).toList();
    }

    public List<Project> filterProjectsByStatus(List<Project> projects, boolean archived){
        return projects.stream().filter(project -> project.isArchived() == archived).toList();
    }

    public List<Project> sortProjectsByStartDate(List<Project> projects){
        return projects.stream().sorted((p1, p2) -> p1.getStart_date().compareTo(p2.getStart_date())).toList();
    }

    public List<Project> sortProjectsByEndDate(List<Project> projects){
        return projects.stream().sorted((p1, p2) -> p1.getEnd_date().compareTo(p2.getEnd_date())).toList();
    }

    public List<Project> sortProjectsByCategory(List<Project> projects){
        return projects.stream().sorted((p1, p2) -> p1.getCategory().compareTo(p2.getCategory())).toList();
    }

    public List<Project> sortProjectsByType(List<Project> projects){
        return projects.stream().sorted((p1, p2) -> p1.getType().compareTo(p2.getType())).toList();
    }

    public List<Project> sortProjectsByStatus(List<Project> projects){
        return projects.stream().sorted((p1, p2) -> Boolean.compare(p1.isArchived(), p2.isArchived())).toList();
    }

    // Méthodes pour la recherche
    public boolean containsKeyword(String keyword){
        return listProjects().stream().anyMatch(project -> project.getTitle().contains(keyword) || project.getDescription().contains(keyword) || project.getCategory().contains(keyword) || project.getType().contains(keyword));
    }

    public List<Project> searchProjectsByKeyword(String keyword){
        return listProjects().stream().filter(project -> project.getTitle().contains(keyword) || project.getDescription().contains(keyword) || project.getCategory().contains(keyword) || project.getType().contains(keyword)).toList();
    }

    // Méthodes pour archiver un projet
    private void archiveProject(Project project) {
        project.setArchived(true);
        updateProject(project.getTitle(), project.getDescription(), project.getStart_date(), project.getEnd_date(), project.getCategory(), project.getType());
    }
    
    public void archiveProjectByTasks(Project project){
        List<Task> tasks;
        tasks = taskManager.listTasksByIdProject(project);
        for (Task task : tasks) {
            if (!task.isDone()) {
                throw new IllegalArgumentException("The project cannot be archived because there are still open tasks");
            }
        }
        archiveProject(project);
    }

    public void archiveProjectByWorkSessions(Project project){
        List<WorkSession> workSessions;
        workSessions = workSessionManager.listWorkSessionsByIdProject(project);
        for (WorkSession workSession : workSessions) {
            if (!workSession.isClosed()) {
                throw new IllegalArgumentException("The project cannot be archived because there are still open work sessions");
            }
        }
        archiveProject(project);
    }

    



































































    // implementer les methodes de recherche
    // implementer les methodes de filtrage
    // implementer les methodes de tri
    // implementer les methodes de statistiques
    // implementer les methodes de calculs
    // implementer les methodes de validation
    // implementer les methodes de generation de rapports
    // implementer les methodes de generation de graphiques
    // implementer les methodes de generation de diagrammes
    // implementer les methodes de generation de statistiques
    // implementer les methodes de generation de tableaux de bord
    // implementer les methodes de generation de KPI
    // implementer les methodes de generation de bilans
    // implementer les methodes de generation de synthese
    // implementer les methodes de generation de rapports d'activite

}
