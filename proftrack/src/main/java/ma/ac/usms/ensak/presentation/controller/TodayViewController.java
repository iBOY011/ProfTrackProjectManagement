package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.presentation.Views.VBoxes.NavBarBox;

/**
 * The TodayViewController class is responsible for managing the Today View in the application.
 * It handles the selection of the Today tab and updates the appearance of the navigation bar accordingly.
 */
public class TodayViewController {
    private static NavBarBox navBarBox = new NavBarBox();

    /**
     * Constructs a new TodayViewController object and selects the Today tab.
     */
    public TodayViewController() {
        selectToday();
    }

    /**
     * Selects the Today tab and updates the appearance of the navigation bar.
     */
    public static void selectToday() {
        navBarBox.getTasksButton().setOnAction(e -> {
            navBarBox.getUserEmail().setStyle("-fx-background-color: #f1f1f1; -fx-text-fill: black;");
            navBarBox.getSettings().setStyle("-fx-background-color: #f1f1f1; -fx-text-fill: black;");
            navBarBox.getCalendar().setStyle("-fx-background-color: #f1f1f1; -fx-text-fill: black;");
        });
    }

    /**
     * Returns the navigation bar box associated with this TodayViewController.
     * @return The navigation bar box.
     */
    public NavBarBox getNavBarBox() {
        return navBarBox;
    }
}
