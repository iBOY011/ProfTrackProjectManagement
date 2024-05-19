package ma.ac.usms.ensak.presentation.Views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AuthentificationView extends HBox {
        private Button loginButton;

        public AuthentificationView() {
                // Creating the labels and button
                Label titleLabel = new Label("PROFTRACK MANAGER");
                titleLabel.setTextFill(Color.WHITE);
                titleLabel.setFont(new Font("Arial", 20));
                titleLabel.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 30px;");

                Label loginLabel = new Label("Login Using Google");
                loginLabel.setTextFill(Color.WHITE);
                loginLabel.setFont(new Font("Arial", 15));
                loginLabel.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 20px;");

                loginButton = new Button("Login");
                ImageView googleIcon = new ImageView(
                                new Image("https://cdn-icons-png.flaticon.com/512/281/281764.png"));
                googleIcon.setFitWidth(50);
                googleIcon.setFitHeight(50);
                loginButton.setGraphic(googleIcon);
                loginButton.setStyle("-fx-background-radius: 10; -fx-font-size: 20px; -fx-font-weight: bold;");

                // Creating the VBox for the labels
                VBox leftVBox = new VBox(10, titleLabel, loginLabel);
                leftVBox.setAlignment(Pos.CENTER);
                leftVBox.setStyle("-fx-background-color: #04ECFF;");
                // Bind the preferred width of leftVBox to half of the window's width
                leftVBox.prefWidthProperty().bind(this.widthProperty().divide(2));

                // Creating the VBox for the login button
                VBox rightVBox = new VBox(loginButton);
                rightVBox.setAlignment(Pos.CENTER);
                rightVBox.setStyle("-fx-background-color: white;");
                // Bind the preferred width of leftVBox to half of the window's width
                rightVBox.prefWidthProperty().bind(this.widthProperty().divide(2));

                // Creating the HBox for the two VBoxes
                HBox hbox = new HBox(leftVBox, rightVBox);
                // Adding the HBox to the scene
                this.getChildren().add(hbox);
        }

        public Button getLoginButton() {
                return loginButton;
        }
}