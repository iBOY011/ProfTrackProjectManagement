package ma.ac.usms.ensak.util;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.management.DocumentManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;

import java.util.Date;
import ma.ac.usms.ensak.metier.management.WorkSessionManager;

public class Statistics {

    // Méthodes pour calculer les heures de travail total d'un projet
    public int getTotalWorkHoursByProject(String projectId) {
        final int[] TotalHours = {0};
        WorkSessionManager workSessionManager = new WorkSessionManager();
        workSessionManager.listWorkSessionsByIdProject(projectId).forEach(workSession -> {
            if (workSession.getId_project().equals(projectId)) {
                long durationMillis = workSession.getDateFin().getTime() - workSession.getDateDebut().getTime();
                int durationHours = (int) (durationMillis / (1000 * 60 * 60)); // Convert milliseconds to hours
                TotalHours[0] += durationHours;
            }
        });
        return TotalHours[0];
    }

    // Méthodes pour calculer le nombre de documents par projet
    public int getNumberOfDocumentsByProject(String projectId) {
        DocumentManager documentManager = new DocumentManager();
        return documentManager.ListDocumentsByProject(projectId).size();
    }

    // Méthodes pour calculer le nombre d'heures de travail par semaine, mois et année
    public int getTotalWorkHoursByDate(Date start, Date end) {
        final int[] TotalHours = {0};
        WorkSessionManager workSessionManager = new WorkSessionManager();
        workSessionManager.getAllWorkSessions().forEach(workSession -> {
            if (workSession.getDateDebut().after(start) && workSession.getDateFin().before(end)) {
                long durationMillis = workSession.getDateFin().getTime() - workSession.getDateDebut().getTime();
                int durationHours = (int) (durationMillis / (1000 * 60 * 60)); // Convert milliseconds to hours
                TotalHours[0] += durationHours;
            }
        });
        return TotalHours[0];
    }

    // Méthodes pour calculer le pourcentage d'heures de travail par catégorie ou type par semaine, mois et année
    public int getPercentageOfWorkHoursByCategory(Category category, Date start, Date end) {
        int totalHours = getTotalWorkHoursByDate(start, end);
        if (totalHours == 0) {
            return 0; // Avoid division by zero
        }

        final int[] TotalHoursByCategory = {0};
        ProjectManager projectManager = new ProjectManager();
        projectManager.listProjects().forEach(project -> {
            if (project.getCategory().equals(category) && project.getStart_date().after(start) && project.getEnd_date().before(end)){
                TotalHoursByCategory[0] += getTotalWorkHoursByProject(project.getId());
            }
        });
        return (TotalHoursByCategory[0] * 100) / totalHours;
    }

    public int getPercentageOfWorkHoursByType(Type type, Date start, Date end) {
        int totalHours = getTotalWorkHoursByDate(start, end);
        if (totalHours == 0) {
            return 0; // Avoid division by zero
        }

        final int[] TotalHoursByType = {0};
        ProjectManager projectManager = new ProjectManager();
        projectManager.listProjects().forEach(project -> {
            if ((project.getType() == type) && project.getStart_date().after(start) && project.getEnd_date().before(end)){
                TotalHoursByType[0] += getTotalWorkHoursByProject(project.getId());
            }
        });
        return (TotalHoursByType[0] * 100) / totalHours;
    }

    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        System.out.println(statistics.getTotalWorkHoursByProject("9776c3ee-6899-482b-bf96-bc8363556b52"));
        System.out.println(statistics.getNumberOfDocumentsByProject("9776c3ee-6899-482b-bf96-bc8363556b52"));
        System.out.println(statistics.getTotalWorkHoursByDate(new Date(2024 - 1900, 0, 1), new Date(2025 - 1900, 11, 31))); // Adjusting Date constructor
        System.out.println(statistics.getPercentageOfWorkHoursByCategory(Category.ACADEMIC, new Date(2024 - 1900, 0, 1), new Date(2025 - 1900, 11, 31)));
        System.out.println(statistics.getPercentageOfWorkHoursByType(Type.PFE, new Date(2024 - 1900, 0, 1), new Date(2025 - 1900, 11, 31)));
    }

}
