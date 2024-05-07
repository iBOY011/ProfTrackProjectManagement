package ma.ac.usms.ensak.persistance.impl;

import java.util.List;

import com.google.gson.Gson;

import ma.ac.usms.ensak.metier.POJO.Project;
import static ma.ac.usms.ensak.persistance.StorageFile.readObjectsFromJsonFile;
import static ma.ac.usms.ensak.persistance.StorageFile.saveListToJsonFile;
import static ma.ac.usms.ensak.persistance.StorageFile.saveToJsonFile;
import ma.ac.usms.ensak.persistance.dao.ProjectDAO;

public class ProjectImpl implements ProjectDAO {
    private static final String JSON_FILE_PATH = "projects.json";
    private final Gson gson;

    public ProjectImpl() {
        gson = new Gson();
    }

    @Override
    public void addProject(Project project) {
        List<Project> projects = readObjectsFromJsonFile(JSON_FILE_PATH);
        if (!projects.isEmpty()) {
            project.setId(projects.get(projects.size() - 1).getId() + 1);
        } else {
            project.setId(1);
        }
        saveToJsonFile(project, JSON_FILE_PATH);
    }

    @Override
    public Project getProjectById(String projectId) {
        List<Project> projects = readObjectsFromJsonFile(JSON_FILE_PATH);
        for (Project project : projects) {
            if (String.valueOf(project.getId()).equals(projectId)) {
                return project;
            }
        }
        return null; // Project not found
    }

    @Override
    public List<Project> getAllProjects() {
        return readObjectsFromJsonFile(JSON_FILE_PATH);
    }

    @Override
    public void updateProject(Project updatedProjet) {
        List<Project> projets = readObjectsFromJsonFile(JSON_FILE_PATH);
        for (int i = 0; i < projets.size(); i++) {
            Project project = projets.get(i);
            if (project.getId() == updatedProjet.getId()) {
                projets.set(i, updatedProjet);
                saveToJsonFile(projets, JSON_FILE_PATH);
                return;
            }
        }
        // Projet not found, do nothing or throw an exception
    }

    @Override
    public void deleteProject(String projetId) {
        List<Project> projets = readObjectsFromJsonFile(JSON_FILE_PATH);
        int id = Integer.parseInt(projetId); // Convert projetId to integer
        projets.removeIf(projet -> projet.getId() == id); // Compare with the id property
        saveListToJsonFile(projets, JSON_FILE_PATH);
    }

}
