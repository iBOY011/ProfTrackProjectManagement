package ma.ac.usms.ensak.presentation.Views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AuthentificationView extends HBox {
        private Button loginButton;

        public AuthentificationView() {
                // Creating the labels and button
                Label titleLabel = new Label("PROFTRACK MANAGER");
                // set font cursive
                titleLabel.setStyle(
                                "-fx-color: linear-gradient(to right bottom,#61D8DE, #E839F6); -fx-font-size: 50px; -fx-margin: 10px; -fx-alignment: center;-fx-padding: 10px; -fx-border-color: transparent; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-width: 100%; -fx-height: 100%; -fx-margin: 10px;");
                Label loginLabel = new Label("Login Using Google");
                loginLabel.setStyle(
                                "-fx-font-size: 20px; -fx-font-weight: bold; -fx-margin: 10px; -fx-alignment: center; -fx-font-family: Arial; -fx-padding: 10px; -fx-border-color: transparent; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-width: 100%; -fx-height: 100%; -fx-margin: 10px;");
                loginButton = new Button("Login");
                ImageView googleIcon = new ImageView(
                                new Image("https://cdn-icons-png.flaticon.com/512/281/281764.png"));
                googleIcon.setFitWidth(50);
                googleIcon.setFitHeight(50);

                // Creating the HBox for Google icon and login button
                loginButton.setGraphic(googleIcon);
                loginButton.setStyle("-fx-background-color: #d2e2ff; -fx-text-fill: black;-fx-font-family: 'Trebuchet MS'; ; -fx-font-size: 20px; -fx-cursor: hand; -fx-border-color: transparent; -fx-border-radius: 2; -fx-padding: 10px 20px; -fx-alignment: center; -fx-margin: 10px; -fx-hover: #f0f0f0; -fx-width: 100%; -fx-height: 100%;");
                loginButton.setId("login-button");
                // Creating the VBox and adding all the elements
                VBox logginVBox = new VBox();
                logginVBox.setAlignment(Pos.CENTER);
                logginVBox.getChildren().addAll(titleLabel, loginLabel, loginButton);

                // Centering the VBox within the HBox
                this.setAlignment(Pos.TOP_CENTER);

                // Setting the Loggin VBox as a child of the Auth HBox
                this.getChildren().add(logginVBox);
                this.setId("login");
                // this.setStyle("-fx-background-color: #f0f0f0; -fx-background-image : url('https://i.pinimg.com/originals/6f/6c/15/6f6c1538b050072b002dbc06bedaaf90.jpg'); -fx-background-size: cover; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-width: 100%; -fx-height: 100%; -fx-margin: 10px; -fx-padding: 10px; -fx-border-color: transparent; -fx-border-radius: 10px;");
        }

        public Button getLoginButton() {
                return loginButton;
        }
}