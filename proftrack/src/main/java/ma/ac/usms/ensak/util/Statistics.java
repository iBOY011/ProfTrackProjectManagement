package ma.ac.usms.ensak.util;

import ma.ac.usms.ensak.metier.management.DocumentManager;

import java.util.Date;
import ma.ac.usms.ensak.metier.management.WorkSessionManager;

public class Statistics {

    // On veut visualiser les statistiques suivantes :
    // o Nombre d’heures de travail sur un projet
    // o Nombre de documents par projet
    // o Nombre d’heure de travail par semaine, mois et année
    // o Pourcentage d’heure de travail par catégorie ou type par semaine,
    // mois et année

    // Méthodes pour calculer les heures de travail total d'un projet
    public int getTotalWorkHoursByProject(String projectId) {
        final int[] TotalHours = {0};
        WorkSessionManager workSessionManager = new WorkSessionManager();
        workSessionManager.listWorkSessionsByIdProject(projectId).forEach(workSession -> {
            if (workSession.getId_project().equals(projectId)) {
                int duration = (int) (workSession.getDateFin().getTime() - workSession.getDateDebut().getTime());
                TotalHours[0] += duration;
            }
        });
        return TotalHours[0];
    }

    // Méthodes pour calculer le nombre de documents par projet
    public int getNumberOfDocumentsByProject(String projectId) {
        int numberOfDocuments = 0;
        DocumentManager documentManager = new DocumentManager();
        numberOfDocuments = documentManager.ListDocumentsByProject(projectId).size();
        return numberOfDocuments;
    }

    // Méthodes pour calculer le nombre d'heures de travail par semaine, mois et année
    public int getTotalWorkHoursByDate(Date start, Date end) {
        final int[] TotalHours = {0};
        WorkSessionManager workSessionManager = new WorkSessionManager();
        workSessionManager.getAllWorkSessions().forEach(workSession -> {
            if (workSession.getDateDebut().after(start) && workSession.getDateFin().before(end)) {
                int duration = (int) (workSession.getDateFin().getTime() - workSession.getDateDebut().getTime());
                TotalHours[0] += duration;
            }
        });
        return TotalHours[0];
    }

    // Méthodes pour calculer le pourcentage d'heures de travail par catégorie ou type par semaine, mois et année
    public int getPercentageOfWorkHoursByCategory(String category, Date start, Date end) {
        final int[] TotalHours = {0};
        final int[] TotalHoursByCategory = {0};
        WorkSessionManager workSessionManager = new WorkSessionManager();
        workSessionManager.getAllWorkSessions().forEach(workSession -> {
            if (workSession.getDateDebut().after(start) && workSession.getDateFin().before(end)) {
                int duration = (int) (workSession.getDateFin().getTime() - workSession.getDateDebut().getTime());
                TotalHours[0] += duration;
                if (workSession.getDescription().equals(category)) {
                    TotalHoursByCategory[0] += duration;
                }
            }
        });
        return (TotalHoursByCategory[0] / TotalHours[0]) * 100;
    }


}
