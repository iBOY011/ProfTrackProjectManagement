package ma.ac.usms.ensak.util;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.management.ProjectManager;

public class Statistics {
    private ProjectManager projectManager;


    // On veut visualiser les statistiques suivantes :
    // o Nombre d’heures de travail sur un projet
    // o Nombre de documents par projet
    // o Nombre d’heure de travail par semaine, mois et année
    // o Pourcentage d’heure de travail par catégorie ou type par semaine,
    // mois et année

    // Méthodes pour calculer les heures de travail total d'un projet
    public int getTotalWorkHoursByProject(String projectId) {
        int TotalHours = 0;
        projectManager = new ProjectManager();
        // Project project = projectManager.searchProjectById(projectId);
        
        
        return TotalHours;
    }
}
