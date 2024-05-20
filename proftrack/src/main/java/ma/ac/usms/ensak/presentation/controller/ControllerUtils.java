package ma.ac.usms.ensak.presentation.controller;

import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;

public class ControllerUtils {

    /**
     * Closes the given stage.
     *
     * @param stage the stage to be closed
     */
    public static void closeStage(Stage stage) {
        if (stage != null) {
            stage.close();
        }
    }

    /**
     * Converts a LocalDate object to a Date object.
     *
     * @param localDate the LocalDate object to be converted
     * @return the converted Date object
     */
    public static Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Converts a Date object to a LocalDate object.
     *
     * @param date the Date object to be converted
     * @return the converted LocalDate object
     */
    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Sets the items of the given ChoiceBox with the titles of all projects.
     *
     * @param choiceBox the ChoiceBox to set the items for
     */
    public static void setProjectChoiceBoxItems(ChoiceBox<String> choiceBox) {
        ProjectManager projectManager = new ProjectManager();
        List<Project> projects = projectManager.listProjects();
        for (Project p : projects) {
            choiceBox.getItems().add(p.getTitle());
        }
    }

    /**
     * Sets the items of the given ChoiceBox with the titles of all lists.
     *
     * @param choiceBox the ChoiceBox to set the items for
     */
    public static void setListChoiceBoxItems(ChoiceBox<String> choiceBox) {
        ListToDoManager listToDoManager = new ListToDoManager();
        List<ListToDo> lists = listToDoManager.listListToDo();
        for (ListToDo l : lists) {
            choiceBox.getItems().add(l.getTitle());
        }
    }

    /**
     * Retrieves the project ID based on the given title.
     *
     * @param title the title of the project
     * @return the ID of the project, or null if not found
     */
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

    /**
     * Retrieves the list ID based on the given title.
     *
     * @param title the title of the list
     * @return the ID of the list, or null if not found
     */
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

    /**
     * Converts a LocalDateTime object to a Date object.
     *
     * @param endDateTime the LocalDateTime object to be converted
     * @return the converted Date object
     */
    public static Date convertLocalDateTimeToDate(LocalDateTime endDateTime) {
        return Date.from(endDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Converts a Date object to a LocalDateTime object.
     *
     * @param date the Date object to be converted
     * @return the converted LocalDateTime object
     */
    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
}
