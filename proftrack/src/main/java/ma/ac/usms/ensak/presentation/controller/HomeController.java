package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.presentation.Views.CalendarView;
import ma.ac.usms.ensak.presentation.Views.HomeView;
import ma.ac.usms.ensak.presentation.Views.TodayView;
import ma.ac.usms.ensak.presentation.Views.VBoxes.NavBarBox;

public class HomeController {
    private static HomeView homeView;
    private static NavBarBox navbar = new NavBarBox();
    private static TodayView todayView = new TodayView();
    private static CalendarView calendarView = new CalendarView();
    private static HomeController homeController;

    public HomeController() {
        homeController = this;
        homeView = new HomeView();
        homeView.setLeft(navbar);
        homeView.setCenter(todayView);
        showToday();
        showCalendar();
    }

    public void showCalendar() {
        navbar.getCalendarButton().setOnAction(e -> {
            homeView.setCenter(calendarView);
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


}
