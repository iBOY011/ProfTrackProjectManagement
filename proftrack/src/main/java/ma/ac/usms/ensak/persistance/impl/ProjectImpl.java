package ma.ac.usms.ensak.persistance.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import ma.ac.usms.ensak.metier.POJO.Project;
import static ma.ac.usms.ensak.persistance.StorageFile.readObjectsFromJsonFile;
import static ma.ac.usms.ensak.persistance.StorageFile.saveToJsonFile;

import ma.ac.usms.ensak.persistance.StorageFile;
import ma.ac.usms.ensak.persistance.dao.ProjectDAO;

public class ProjectImpl implements ProjectDAO {
    private static final String JSON_FILE_PATH = "src\\main\\resources\\databases\\projects.json";

    public ProjectImpl() {
    }

    @Override
    public void addProject(Project project) {
        List<Project> projects = readObjectsFromJsonFile(JSON_FILE_PATH, Project.class);
        if (projects == null) {
            projects = new ArrayList<>();
        }
        projects.add(project);
        saveToJsonFile(projects, JSON_FILE_PATH);
    }

    @Override
    public Project getProjectById(String projectId) {
        List<Project> projects = readObjectsFromJsonFile(JSON_FILE_PATH, Project.class);
        for (Project project : projects) {
            if (project.getId().contentEquals(projectId)) {
                return project;
            }
        }
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = StorageFile.readObjectsFromJsonFile(JSON_FILE_PATH, Project.class);
        return projects;
    }

    @Override
    public void updateProject(Project updatedProjet) {
        List<Project> projets = readObjectsFromJsonFile(JSON_FILE_PATH, Project.class);
        for (int i = 0; i < projets.size(); i++) {
            Project project = projets.get(i);
            if (project.getId().contentEquals(updatedProjet.getId())) {
                projets.set(i, updatedProjet);
                saveToJsonFile(projets, JSON_FILE_PATH);
                return;
            }
        }
    }

    @Override
    public void deleteProject(String projetId) {
        List<Project> projets = readObjectsFromJsonFile(JSON_FILE_PATH, Project.class);
        String id = projetId; // Convert projetId to integer
        projets.removeIf(projet -> projet.getId().contentEquals(id)); // Compare with the id property
        saveToJsonFile(projets, JSON_FILE_PATH);
    }

}
