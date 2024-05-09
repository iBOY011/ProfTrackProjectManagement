package ma.ac.usms.ensak;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.persistance.StorageFile;
import ma.ac.usms.ensak.persistance.impl.ProjectImpl;

public class Main {
    public static void main(String[] args) {
        Project instance = new Project("title", "description", null, null, null, "type", false);
        List<Project> projects = new ArrayList<>();
        projects.add(instance);
        StorageFile.saveListToJsonFile(projects, "src/main/resources/databases/projects2.json");
        ProjectImpl projectImpl = new ProjectImpl();
        projectImpl.addProject(instance);
    }
}