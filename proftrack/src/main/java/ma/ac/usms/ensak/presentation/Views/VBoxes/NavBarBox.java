package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NavBarBox extends VBox {
    // Create 4 HBoxs
    private HBox UserEmail;
    private HBox Tasks;
    private HBox Calendar;
    private HBox Settings;

    public NavBarBox() {
        // Create 4 HBoxs
        UserEmail = new HBox();
        Tasks = new HBox();
        Calendar = new HBox();
        Settings = new HBox();

        // Set the preferred size of each HBox by percentage 1 -> 20% 2 -> 20% 3 -> 30%
        // 4 -> 30%
        HBox[] HBoxes = new HBox[] { UserEmail, Tasks, Calendar, Settings };
        double[] percentages = { 20, 20, 30, 30 };
        for (int i = 0; i < HBoxes.length; i++) {
            HBox HBox = HBoxes[i];
            HBox.prefHeightProperty().bind(heightProperty().multiply(percentages[i] / 100));
        }

        addButtonWithImage(UserEmail, getClass().getResource("/Icons/profile.png").toString());
        addButtonWithImage(Tasks, "https://cdn-icons-png.flaticon.com/512/7072/7072982.png");
        addButtonWithImage(Calendar, "https://cdn-icons-png.flaticon.com/512/1048/1048953.png");
        addButtonWithImage(Settings, "https://cdn-icons-png.flaticon.com/512/1835/1835942.png");
        // add HBox to VBox
        getChildren().addAll(HBoxes);
    }

    public static void addButtonWithImage(HBox hbox, String imageUrl) {
        Image image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        Button button = new Button();
        // set the style of the button
        button.setStyle("-fx-border-color: transparent; -fx-cursor: hand; -fx-width: 100%; -fx-height: 50px; -fx-background-color: transparent; -fx-alignment: center;");
        // make hover effect
        button.setOnMouseClicked(e -> {
            button.setStyle("-fx-border-color: transparent; -fx-cursor: hand; -fx-width: 100%; -fx-height: 50px; -fx-background-color: #adbac7; -fx-alignment: center;");
        });
        


        
        button.setGraphic(imageView);
        hbox.getChildren().add(button);
    }
}
