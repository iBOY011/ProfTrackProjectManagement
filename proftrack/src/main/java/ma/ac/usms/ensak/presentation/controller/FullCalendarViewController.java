package ma.ac.usms.ensak.presentation.controller;

import java.time.ZoneId;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.FullCalendarView;

public class FullCalendarViewController {

    private TaskManager taskManager = new TaskManager();

    private static FullCalendarView fullCalendarView = new FullCalendarView(YearMonth.now());
    private YearMonth currentYearMonth;

    public FullCalendarViewController() {

        fullCalendarView.getpreviousMonth().setOnAction(e -> previousMonth());

        fullCalendarView.getnextMonth().setOnAction(e -> nextMonth());

        currentYearMonth = fullCalendarView.getCurrentYearMonth();

        initialize();
    }

    /**
     * Move the month back by one. Repopulate the calendar with the correct dates.
     */
    private void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        fullCalendarView.populateCalendar(currentYearMonth);
        initialize(); // Réinitialiser les tâches pour le nouveau mois

    }

    /**
     * Move the month forward by one. Repopulate the calendar with the correct
     * dates.
     */
    private void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
        fullCalendarView.populateCalendar(currentYearMonth);
        initialize(); // Réinitialiser les tâches pour le nouveau mois

    }

    public FullCalendarView getFullCalendarView() {
        return fullCalendarView;
    }

    public void initialize() {
        List<Task> tasks = taskManager.listTasks();
        for (Task task : tasks) {
            LocalDate startDate = task.getStart_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate endDate = task.getEnd_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (task.getStart_date().equals(task.getEnd_date())) {
                addTask(startDate, task.getTitle(), task.getId());
            } else {
                addMultiDayTask(startDate, endDate, task.getTitle(), task.getId());
            }
        }
    }

    public void addTask(LocalDate date, String taskTitle, String idTask) {
        fullCalendarView.addTask(date, taskTitle, idTask);
    }

    public void addMultiDayTask(LocalDate startDate, LocalDate endDate, String taskTitle, String idTask) {
        fullCalendarView.addMultiDayTask(startDate, endDate, taskTitle, idTask);
    }


}