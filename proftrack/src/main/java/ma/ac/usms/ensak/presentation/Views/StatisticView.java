package ma.ac.usms.ensak.presentation.Views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.persistance.impl.DocumentImpl;
import ma.ac.usms.ensak.persistance.impl.ProjectImpl;
import ma.ac.usms.ensak.util.Statistics;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StatisticView extends VBox {

    private HBox TotalHoursWork;
    private HBox ProjectHoursWork;
    private BarChart<String, Number> barChart1;
    private BarChart<String, Number> barChart2;
    private XYChart.Series series;

    public StatisticView() {
        TotalHoursWork = new HBox();
        ProjectHoursWork = new HBox();
        initializeChart();

        displayWorkHours();
        this.getChildren().addAll(TotalHoursWork, ProjectHoursWork);
    }

    private void initializeChart() {
        Label label1 = new Label("Project Work Hours Summary");
        label1.setStyle(
                "-fx-font-size: 20px; -fx-font-weight: bold; -fx-padding: 10px; -fx-text-fill: #000000; -fx-border-color: black; -fx-border-width: 0 0 1 0; -fx-background-color: #04ECFF; -fx-alignment: center; -fx-width: 100%;");
        TotalHoursWork.getChildren().add(label1);

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        this.barChart1 = new BarChart<>(xAxis, yAxis);


        this.series = new XYChart.Series();
        series.setName("Hours");

        // Replace with actual data, use the ProjectImpl class to get the data
        ProjectImpl projectImpl = new ProjectImpl();
        List<Project> projects = projectImpl.getAllProjects();
        for (Project project : projects) {
            Statistics statistics = new Statistics();
            int projectgetTotalWorkHours = statistics.getTotalWorkHoursByProject(project.getId());
            series.getData().add(new XYChart.Data(project.getTitle(), projectgetTotalWorkHours));
        }

        barChart1.getData().addAll(series);

        barChart2.setTitle("Number of Documents by Project");
        for (Project project : projects) {
            XYChart.Series series = new XYChart.Series();
            series.setName(project.getTitle()());
    
            int numberOfDocuments = getNumberOfDocumentsByProject(project.getId());
            series.getData().add(new XYChart.Data(project.getTitle()(), numberOfDocuments));
    
            barChart.getData().add(series);
        }
    
        
        

        VBox vbox = new VBox();
        vbox.getChildren().addAll(label1, barChart1);

        TotalHoursWork.getChildren().add(vbox);
    }

    public int getNumberOfDocumentsByProject(String projectId) {
        // Assuming ProjectImpl has a method getDocumentsByProject
        DocumentImpl documentImpl = new DocumentImpl();
        List<Document> documents = documentImpl.getDocumentsByProject(projectId);
        return documents.size();
    }

    public int getTotalWorkHoursByDate(Date start, Date end) {
        Statistics statistics = new Statistics();
        return statistics.getTotalWorkHoursByDate(start, end);
    }

    public int getTotalWorkHoursByWeek(Date startOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startOfWeek);
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        Date endOfWeek = calendar.getTime();

        return getTotalWorkHoursByDate(startOfWeek, endOfWeek);
    }

    public int getTotalWorkHoursByMonth(Date startOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startOfMonth);
        calendar.add(Calendar.MONTH, 1);
        Date endOfMonth = calendar.getTime();

        return getTotalWorkHoursByDate(startOfMonth, endOfMonth);
    }

    public int getTotalWorkHoursByYear(Date startOfYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startOfYear);
        calendar.add(Calendar.YEAR, 1);
        Date endOfYear = calendar.getTime();

        return getTotalWorkHoursByDate(startOfYear, endOfYear);
    }

    public void displayWorkHours() {
        ListView<String> listView = new ListView<>();

        Date now = new Date();
        int hoursThisWeek = getTotalWorkHoursByWeek(now);
        int hoursThisMonth = getTotalWorkHoursByMonth(now);
        int hoursThisYear = getTotalWorkHoursByYear(now);

        ObservableList<String> items = FXCollections.observableArrayList(
                "Hours this week: " + hoursThisWeek,
                "Hours this month: " + hoursThisMonth,
                "Hours this year: " + hoursThisYear);

        listView.setItems(items);

        ProjectHoursWork.getChildren().add(listView);
    }

}