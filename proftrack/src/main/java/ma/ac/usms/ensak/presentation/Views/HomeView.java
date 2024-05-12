package ma.ac.usms.ensak.presentation.Views;

import javafx.scene.layout.BorderPane;
import ma.ac.usms.ensak.presentation.Views.VBoxes.NavBarBox;

public class HomeView extends BorderPane {
    private NavBarBox navbar;
    private TodayView todayView;

    public HomeView() {
        navbar = new NavBarBox();
        todayView = new TodayView();

        setLeft(navbar);
        setCenter(todayView);
    }

    public NavBarBox getNavbar() {
        return navbar;
    }

    public TodayView getTodayView() {
        return todayView;
    }
    
}
