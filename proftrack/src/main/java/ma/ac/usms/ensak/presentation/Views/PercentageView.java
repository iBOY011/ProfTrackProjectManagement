package ma.ac.usms.ensak.presentation.Views;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.util.Category;
import ma.ac.usms.ensak.util.Statistics;
import ma.ac.usms.ensak.util.Type;

import java.io.File;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class PercentageView extends VBox {
    private ComboBox<String> selector1;
    private ComboBox<String> selector2;
    private PieChart pieChart;
    private Date currentDate;
    private Statistics statistics = new Statistics();
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##");

    public PercentageView() {
        // Initialize selectors
        Label selectTypeOrCategory = new Label("Select Type or Category");
        selector1 = new ComboBox<>();
        selector1.getItems().addAll("Category", "Type");
        selector1.setValue("Category");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(selectTypeOrCategory, selector1);

        Label selectPeriod = new Label("Select Period");
        selector2 = new ComboBox<>();
        selector2.getItems().addAll("Week", "Month", "Year");
        selector2.setValue("Week");

        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(selectPeriod, selector2);

        // make hbox et hbox2 at the same size and align them
        hbox.setMinWidth(200);
        hbox2.setMinWidth(200);
        hbox.setSpacing(10);
        hbox2.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox.getStyleClass().add("hbox");
        hbox2.getStyleClass().add("hbox");

        // Initialize PieChart
        pieChart = new PieChart();

        // Add listeners to update PieChart based on selections
        selector1.setOnAction(e -> updatePieChart());
        selector2.setOnAction(e -> updatePieChart());

        // Add components to VBox
        this.getChildren().addAll(hbox, hbox2, pieChart);

        // Initialize current date
        currentDate = new Date();
        updatePieChart(); // Initial update

        try {
            getStylesheets().add(new File("src/main/resources/Css/stylesheet.css").toURI().toURL().toExternalForm());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        getStyleClass().add("percentage-view");
    }

    private void updatePieChart() {
        String selection1 = selector1.getValue();
        String selection2 = selector2.getValue();

        if (selection1 == null || selection2 == null) {
            return;
        }

        // Define the start and end date based on the second selector
        Date[] dateRange = getDateRange(selection2);
        Date startDate = dateRange[0];
        Date endDate = dateRange[1];

        // Get data for the PieChart based on the first selector
        ObservableList<PieChart.Data> pieChartData;
        if (selection1.equals("Category")) {
            pieChartData = getPieChartDataByCategory(startDate, endDate);
        } else {
            pieChartData = getPieChartDataByType(startDate, endDate);
        }

        pieChart.setData(pieChartData);

        // Show percentage labels on pie chart slices
    }

    private Date[] getDateRange(String period) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate); // Set calendar to current date
        Date endDate = calendar.getTime();
        Date startDate = null;

        switch (period) {
            case "Week":
                calendar.add(Calendar.WEEK_OF_YEAR, -1);
                startDate = calendar.getTime();
                break;
            case "Month":
                calendar.add(Calendar.MONTH, -1);
                startDate = calendar.getTime();
                break;
            case "Year":
                calendar.add(Calendar.YEAR, -1);
                startDate = calendar.getTime();
                break;
        }

        return new Date[]{startDate, endDate};
    }

    private ObservableList<PieChart.Data> getPieChartDataByCategory(Date start, Date end) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (Category category : Category.values()) {
            int percentage = statistics.getPercentageOfWorkHoursByCategory(category, start, end);
            if (percentage != 0) {
                String name = String.format("%s (%s%%)", category.name(), DECIMAL_FORMAT.format(percentage));
                data.add(new PieChart.Data(name, percentage));
            }
        }
        return data;
    }

    private ObservableList<PieChart.Data> getPieChartDataByType(Date start, Date end) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (Type type : Type.values()) {
            int percentage = statistics.getPercentageOfWorkHoursByType(type, start, end);
            if (percentage != 0) { // Exclude zero percentage data
                String name = String.format("%s (%s%%)", type.name(), DECIMAL_FORMAT.format(percentage));
                data.add(new PieChart.Data(name, percentage));
            }
        }
        return data;
    }
}
