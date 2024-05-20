package ma.ac.usms.ensak.presentation.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import ma.ac.usms.ensak.Main;
import ma.ac.usms.ensak.metier.Services.GoogleOAuth2Login;
import ma.ac.usms.ensak.presentation.controller.AuthController;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfo;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class ParametreView extends VBox {
    private Label nameLabel;
    private Label emailLabel;
    private Button logoutButton;

    public Button getLogoutButton() {
        return logoutButton;
    }

    public ParametreView(Window primaryStage) {
        setPadding(new Insets(20));
        setSpacing(15);
        setAlignment(Pos.CENTER);

        nameLabel = new Label("Name: Loading...");
        emailLabel = new Label("Email: Loading...");

        logoutButton = new Button("Logout");
        logoutButton.setOnAction(event -> {
            try {
                GoogleOAuth2Login.logout();
                // Close the current window
                Main.setRoot(AuthController.getAuthentification());
                // Optionally, redirect to login screen or another scene
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        getChildren().addAll(nameLabel, emailLabel, logoutButton);

        // Apply styles
        nameLabel.getStyleClass().add("user-info-label");
        emailLabel.getStyleClass().add("user-info-label");
        logoutButton.getStyleClass().add("logout-button");

        loadUserInfo();
    }

    private void loadUserInfo() {
        new Thread(() -> {
            try {
                Credential credential = GoogleOAuth2Login.authorize();
                Oauth2 oauth2 = new Oauth2.Builder(GoogleOAuth2Login.httpTransport, GoogleOAuth2Login.JSON_FACTORY, credential)
                        .setApplicationName("Google-OAuth2-Example")
                        .build();
                Userinfo userinfo = oauth2.userinfo().get().execute();
                String name = userinfo.getName();
                String email = userinfo.getEmail();

                // Update UI on JavaFX Application Thread
                javafx.application.Platform.runLater(() -> {
                    nameLabel.setText("Name: " + name);
                    emailLabel.setText("Email: " + email);
                });

            } catch (IOException | GeneralSecurityException | InterruptedException e) {
                e.printStackTrace();
                javafx.application.Platform.runLater(() -> {
                    nameLabel.setText("Name: Error loading user info");
                    emailLabel.setText("Email: Error loading user info");
                });
            }
        }).start();
        this.getStylesheets().add(getClass().getResource("/Css/stylesheet.css").toExternalForm());
    }

    
}
