package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NavBarBox extends VBox {
    private HBox UserEmail;
    private HBox Tasks;
    private HBox Calendar;
    private HBox Statistics;
    
    private HBox Settings;
    private Button userEmailButton = new Button();
    private Button TasksButton = new Button();
    private Button CalendarButton = new Button();
    private Button StatisticsButton = new Button();
    private Button SettingsButton = new Button();
    
    public NavBarBox() {
        UserEmail = new HBox();
        Tasks = new HBox();
        Calendar = new HBox();
        Statistics = new HBox();
        Settings = new HBox();
        
        HBox[] HBoxes = new HBox[] { UserEmail, Tasks, Calendar, Statistics, Settings };
        double[] percentages = { 20, 20, 20, 20, 20 };
        for (int i = 0; i < HBoxes.length; i++) {
            HBox HBox = HBoxes[i];
            HBox.prefHeightProperty().bind(heightProperty().multiply(percentages[i] / 100));
        }
        
        addButtonWithImage(UserEmail, getClass().getResource("/Icons/profile.png").toString(), userEmailButton);
        addButtonWithImage(Tasks, "https://cdn-icons-png.flaticon.com/512/7072/7072982.png", TasksButton);
        addButtonWithImage(Calendar, "https://cdn-icons-png.flaticon.com/512/1048/1048953.png", CalendarButton);
        addButtonWithImage(Statistics, getClass().getResource("/Icons/analytics.png").toExternalForm(),
        StatisticsButton);
        addButtonWithImage(Settings, "https://cdn-icons-png.flaticon.com/512/1835/1835942.png", SettingsButton);
        
        getChildren().addAll(HBoxes);
        this.setStyle("-fx-background-color: #04ECFF; -fx-border-color: black; -fx-border-width: 0 1 0 0;");
    }
    
    public static Button addButtonWithImage(HBox hbox, String imageUrl, Button button) {
        Image image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        button.setStyle(
            "-fx-border-color: transparent; -fx-cursor: hand; -fx-width: 100%; -fx-height: 50px; -fx-background-color: transparent; -fx-alignment: center;");
            
            button.setGraphic(imageView);
            button.setId("navbar-button");
            hbox.getChildren().add(button);
            return button;
        }
        
        public HBox getUserEmail() {
            return UserEmail;
        }
        
    public HBox getTasks() {
        return Tasks;
    }
    
    public HBox getCalendar() {
        return Calendar;
    }
    
    public HBox getSettings() {
        return Settings;
    }
    
    public Button getUserEmailButton() {
        return userEmailButton;
    }
    
    public Button getTasksButton() {
        return TasksButton;
    }
    
    public Button getCalendarButton() {
        return CalendarButton;
    }
    
    public Button getSettingsButton() {
        return SettingsButton;
    }

    public HBox getStatistics() {
        return Statistics;
    }

    public Button getStatisticsButton() {
        return StatisticsButton;
    }
}
