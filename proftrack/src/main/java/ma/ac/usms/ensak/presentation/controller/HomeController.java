package ma.ac.usms.ensak.presentation.controller;


import ma.ac.usms.ensak.presentation.Views.FullCalendarView;
import ma.ac.usms.ensak.presentation.Views.HomeView;
import ma.ac.usms.ensak.presentation.Views.TodayView;
import ma.ac.usms.ensak.presentation.Views.VBoxes.NavBarBox;

public class HomeController {
    private static double normalWidth;
    private static HomeView homeView;
    private static NavBarBox navbar = new NavBarBox();
    private static TodayView todayView = new TodayView();
    private static FullCalendarViewController fullcalendarviewcontroller = new FullCalendarViewController();
    private static FullCalendarView fullcalendarView = fullcalendarviewcontroller.getFullCalendarView();
    private static HomeController homeController;
    private static boolean isShowBoxVisible = true;

    public HomeController() {
        homeController = this;
        homeView = new HomeView();
        homeView.setId("home");
        homeView.getStylesheets().add(getClass().getResource("/css/home.css").toExternalForm());
        homeView.setLeft(navbar);
        homeView.setCenter(todayView);
        showToday();
        showCalendar();
    }

    public void showCalendar() {
        navbar.getCalendarButton().setOnAction(e -> {
            homeView.setCenter(fullcalendarView.getView());
        });
    }

    public void showToday() {
        navbar.getTasksButton().setOnAction(e -> {
            homeView.setCenter(todayView);
        });
    }

    public static HomeView getHomeView() {
        return homeView;
    }

    public static TodayView getTodayView() {
        return todayView;
    }

    // private static double calculateNormalWidth() {
    //     double[] percentages = { 20, 40, 40 };
    //     double totalWidth = todayView.getShowBox().getParent().getLayoutBounds().getWidth();
    //     double normalWidth = 0;
    //     for (double percentage : percentages) {
    //         normalWidth += totalWidth * (percentage / 100);
    //     }
    //     return normalWidth;
    // }
    
    // public static void toggleShowBoxSize() {
    //     calculateNormalWidth();
    //     System.out.println("Normal width: " + normalWidth);
    //     // Check if the current width is 0, if so, set it back to normal width
    //     if (todayView.getShowBox().getPrefWidth() == 0) {
    //         todayView.getTodayBox().setPrefWidth(todayView.getTodayBox().getWidth()-normalWidth);
    //         todayView.getShowBox().setPrefWidth(normalWidth);
    //     } else {
    //         // Otherwise, set the width to 0

    //         todayView.getShowBox().setPrefWidth(0);
    //         todayView.getTodayBox().setPrefWidth(todayView.getTodayBox().getWidth()+normalWidth);
    //     }
    // }
    private static double calculateNormalWidth() {
        double[] percentages = { 20, 40, 40 };
        double totalWidth = todayView.getShowBox().getParent().getLayoutBounds().getWidth();
        double normalWidth = 0;
        for (double percentage : percentages) {
            normalWidth += totalWidth * (percentage / 100);
        }
        return normalWidth;
    }

    public static void toggleShowBoxSize() {
        calculateNormalWidth();
        // Check if the current width is 0, if so, set it back to normal width
        if (todayView.getShowBox().getPrefWidth() == 0) {
            todayView.getShowBox().setPrefWidth(normalWidth);
        } else {
            // Otherwise, set the width to 0
            todayView.getShowBox().setPrefWidth(0);
        }
    }

}
