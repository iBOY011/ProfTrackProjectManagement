package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.presentation.Views.VBoxes.NavBarBox;

public class TodayViewController {
    private static NavBarBox navBarBox = new NavBarBox();

    public TodayViewController() {
        selectToday();
    }

    // select the current day
    public static void selectToday() {
        navBarBox.getTasksButton().setOnAction(e -> {
            navBarBox.getUserEmail().setStyle("-fx-background-color: #f1f1f1; -fx-text-fill: black;");
            navBarBox.getSettings().setStyle("-fx-background-color: #f1f1f1; -fx-text-fill: black;");
            navBarBox.getCalendar().setStyle("-fx-background-color: #f1f1f1; -fx-text-fill: black;");
        });
    }

    public NavBarBox getNavBarBox() {
        return navBarBox;
    }
}
