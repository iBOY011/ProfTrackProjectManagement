package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.presentation.Views.FullCalendarView;
import ma.ac.usms.ensak.presentation.Views.HomeView;
import ma.ac.usms.ensak.presentation.Views.ParametreView;
import ma.ac.usms.ensak.presentation.Views.StatisticView;
import ma.ac.usms.ensak.presentation.Views.TodayView;
import ma.ac.usms.ensak.presentation.Views.VBoxes.NavBarBox;

/**
 * The HomeController class is responsible for controlling the home view of the application.
 */
public class HomeController {
    private static double normalWidth;
    private static HomeView homeView;
    private static NavBarBox navbar = new NavBarBox();
    private static StatisticView statisticView = new StatisticView();
    private static TodayView todayView = new TodayView();
    private static FullCalendarViewController fullcalendarviewcontroller = new FullCalendarViewController();
    private static FullCalendarView fullcalendarView = fullcalendarviewcontroller.getFullCalendarView();
    private static HomeController homeController;
    private static boolean isShowBoxVisible = true;

    /**
     * Constructs a new HomeController object.
     * Initializes the home view and sets up the initial layout.
     */
    public HomeController() {
        homeController = this;
        homeView = new HomeView();
        homeView.setId("home");
        homeView.getStylesheets().add(getClass().getResource("/Css/home.css").toExternalForm());
        homeView.setLeft(navbar);
        homeView.setCenter(todayView);
        showToday();
        showCalendar();
        showStatistics();
        showSettings();
    }

    /**
     * Shows the calendar view when the calendar button is clicked.
     */
    public void showCalendar() {
        navbar.getCalendarButton().setOnAction(e -> {
            homeView.setCenter(fullcalendarView.getView());
            fullcalendarviewcontroller = new FullCalendarViewController();
            fullcalendarView = fullcalendarviewcontroller.getFullCalendarView();
        });

    }

    /**
     * Shows the statistics view when the statistics button is clicked.
     */
    public void showStatistics() {
        navbar.getStatisticsButton().setOnAction(e -> {
            statisticView = new StatisticView();
            homeView.setCenter(statisticView);
        });
    }

    /**
     * Shows the today view when the tasks button is clicked.
     */
    public void showToday() {
        navbar.getTasksButton().setOnAction(e -> {
            homeView.setCenter(todayView);
        });
    }

    /**
     * Shows the statistics view when the statistics button is clicked.
     * This method is deprecated and should not be used.
     * Use the showStatistics() method instead.
     * @deprecated Use showStatistics() method instead.
     */
    @Deprecated
    public void showStatistic() {
        navbar.getStatisticsButton().setOnAction(e ->{
            homeView.setCenter(statisticView);
        });
    }

    public void showSettings() {
        navbar.getSettingsButton().setOnAction(e -> {
            ParametreView parametreView = new ParametreView(homeView.getScene().getWindow());
            homeView.setCenter(parametreView);
        });
    }

    /**
     * Returns the home view.
     * @return The home view.
     */
    public static HomeView getHomeView() {
        return homeView;
    }

    /**
     * Returns the today view.
     * @return The today view.
     */
    public static TodayView getTodayView() {
        return todayView;
    }

    private static double calculateNormalWidth() {
        double[] percentages = { 20, 40, 40 };
        double totalWidth = todayView.getShowBox().getParent().getLayoutBounds().getWidth();
        double normalWidth = 0;
        for (double percentage : percentages) {
            normalWidth += totalWidth * (percentage / 100);
        }
        return normalWidth;
    }

    /**
     * Toggles the size of the show box.
     * If the show box is currently hidden, it will be shown with the normal width.
     * If the show box is currently shown, it will be hidden.
     */
    public static void toggleShowBoxSize() {
        calculateNormalWidth();
        if (todayView.getShowBox().getPrefWidth() == 0) {
            todayView.getShowBox().setPrefWidth(normalWidth);
        } else {
            todayView.getShowBox().setPrefWidth(0);
        }
    }

}
