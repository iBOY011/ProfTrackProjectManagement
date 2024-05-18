package ma.ac.usms.ensak.presentation.controller;

import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;

public class ControllerUtils {

    public static void closeStage(Stage stage) {
        if (stage != null) {
            stage.close();
        }
    }

    public static Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static void setProjectChoiceBoxItems(ChoiceBox<String> choiceBox) {
        ProjectManager projectManager = new ProjectManager();
        List<Project> projects = projectManager.listProjects();
        for (Project p : projects) {
            choiceBox.getItems().add(p.getTitle());
        }
    }

    public static void setListChoiceBoxItems(ChoiceBox<String> choiceBox) {
        ListToDoManager listToDoManager = new ListToDoManager();
        List<ListToDo> lists = listToDoManager.listListToDo();
        for (ListToDo l : lists) {
            choiceBox.getItems().add(l.getTitle());
        }
    }

    public static String getProjectIdByTitle(String title) {
        ProjectManager projectManager = new ProjectManager();
        List<Project> projects = projectManager.listProjects();
        for (Project p : projects) {
            if (p.getTitle().equals(title)) {
                return p.getId();
            }
        }
        return null;
    }

    public static String getListIdByTitle(String title) {
        ListToDoManager listToDoManager = new ListToDoManager();
        List<ListToDo> lists = listToDoManager.listListToDo();
        for (ListToDo l : lists) {
            if (l.getTitle().equals(title)) {
                return l.getId();
            }
        }
        return null;
    }
}
