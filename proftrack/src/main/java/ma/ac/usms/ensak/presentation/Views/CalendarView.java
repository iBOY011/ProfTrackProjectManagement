package ma.ac.usms.ensak.presentation.Views;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CalendarView extends GridPane {

    public CalendarView() {
        // create a calendar view of week

        // create a gridpane
        GridPane gridPane = new GridPane();

        // create a label for each day of the week
        Label mondayLabel = new Label("Monday");
        Label tuesdayLabel = new Label("Tuesday");
        Label wednesdayLabel = new Label("Wednesday");
        Label thursdayLabel = new Label("Thursday");
        Label fridayLabel = new Label("Friday");
        Label saturdayLabel = new Label("Saturday");
        Label sundayLabel = new Label("Sunday");

        // create a label for each hour of the day
        Label hourLabel1 = new Label("1 AM");
        Label hourLabel2 = new Label("2 AM");
        Label hourLabel3 = new Label("3 AM");

        // ... add labels for all hours of the day

        // add labels to gridpane
        gridPane.add(mondayLabel, 0, 0);
        gridPane.add(tuesdayLabel, 1, 0);
        gridPane.add(wednesdayLabel, 2, 0);
        gridPane.add(thursdayLabel, 3, 0);
        gridPane.add(fridayLabel, 4, 0);
        gridPane.add(saturdayLabel, 5, 0);
        gridPane.add(sundayLabel, 6, 0);

        gridPane.add(hourLabel1, 0, 1);
        gridPane.add(hourLabel2, 0, 2);
        gridPane.add(hourLabel3, 0, 3);
        // ... add labels for all hours of the day

        // add gridpane to the calendar view
        this.getChildren().add(gridPane);

    }
    
}
