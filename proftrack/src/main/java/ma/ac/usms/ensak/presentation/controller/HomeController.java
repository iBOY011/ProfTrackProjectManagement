package ma.ac.usms.ensak.presentation.controller;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;
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
    private static boolean isShowBoxVisible = true;

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

    public static void toggleShowBox() {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setNode(todayView.getShowBox());
    
        if (isShowBoxVisible) {
            // Déplacer ShowBox vers la gauche pour le cacher
            translateTransition.setByX(-todayView.getShowBox().getWidth());
            translateTransition.setOnFinished(e -> {
                // Réduire la largeur du ShowBox à 0 pour le cacher complètement
                todayView.getShowBox().setPrefWidth(0);
                isShowBoxVisible = false;
            });
        } else {
            // Agrandir la largeur du ShowBox pour l'afficher
            todayView.getShowBox().setPrefWidth(20); // Réinitialiser la largeur à 20
            translateTransition.setByX(todayView.getShowBox().getWidth());
            translateTransition.setOnFinished(e -> {
                isShowBoxVisible = true;
            });
        }
    
        translateTransition.play();
    }


}
