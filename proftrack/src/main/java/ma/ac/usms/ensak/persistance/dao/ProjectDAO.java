package ma.ac.usms.ensak.persistance.dao;

import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Project;

public interface ProjectDAO {

    void addProject(Project project);

    Project getProjectById(String projetId);

    List<Project> getAllProjects();

    void updateProject(Project updatedProjet);

    void deleteProject(String projetId);

}