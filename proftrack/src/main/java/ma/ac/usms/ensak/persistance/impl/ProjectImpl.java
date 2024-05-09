package ma.ac.usms.ensak.persistance.impl;

import java.util.List;

import com.google.gson.Gson;

import ma.ac.usms.ensak.metier.POJO.Project;
import static ma.ac.usms.ensak.persistance.StorageFile.readObjectsFromJsonFile;
import static ma.ac.usms.ensak.persistance.StorageFile.saveToJsonFile;
import ma.ac.usms.ensak.persistance.dao.ProjectDAO;

public class ProjectImpl implements ProjectDAO {
    private static final String JSON_FILE_PATH = "proftrack\\src\\main\\resources\\databases\\projects.json";
    private final Gson gson;

    public ProjectImpl() {
        gson = new Gson();
    }

    @Override
    public void addProject(Project project) {
        saveToJsonFile(project, JSON_FILE_PATH);
    }

    @Override
    public Project getProjectById(String projectId) {
        List<Project> projects = readObjectsFromJsonFile(JSON_FILE_PATH, Project.class);
        for (Project project : projects) {
            if (String.valueOf(project.getId()).equals(projectId)) {
                return project;
            }
        }
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        return readObjectsFromJsonFile(JSON_FILE_PATH, Project.class);
    }

    @Override
    public void updateProject(Project updatedProjet) {
        List<Project> projets = readObjectsFromJsonFile(JSON_FILE_PATH, Project.class);
        for (int i = 0; i < projets.size(); i++) {
            Project project = projets.get(i);
            if (project.getId() == updatedProjet.getId()) {
                projets.set(i, updatedProjet);
                saveListToJsonFile(projets, JSON_FILE_PATH);
                return;
            }
        }
        // Projet not found, do nothing or throw an exception
    }

    @Override
    public void deleteProject(String projetId) {
        List<Project> projets = readObjectsFromJsonFile(JSON_FILE_PATH, Project.class);
        String id = projetId; // Convert projetId to integer
        projets.removeIf(projet -> projet.getId() == id); // Compare with the id property
        saveToJsonFile(projets, JSON_FILE_PATH);
    }

}
