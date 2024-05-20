package ma.ac.usms.ensak.presentation.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.auth.oauth2.Credential;

import ma.ac.usms.ensak.Main;
import ma.ac.usms.ensak.metier.Services.GoogleOAuth2Login;
import ma.ac.usms.ensak.presentation.Views.AuthentificationView;
import ma.ac.usms.ensak.presentation.Views.HomeView;

/**
 * The AuthController class handles the authentication process for the application.
 */
public class AuthController {
    private AuthentificationView authentification;

    /**
     * Constructs an AuthController object.
     * Initializes the AuthentificationView and sets the login button's on-click event.
     */
    public AuthController() {
        authentification = new AuthentificationView();
        authentification.getLoginButton().setOnMouseClicked(e -> {
            try {
                Credential credential = GoogleOAuth2Login.authorize();
                if (credential != null) {
                    Main.setRoot(new HomeController().getHomeView());
                }
            } catch (IOException | InterruptedException | GeneralSecurityException ev) {
                // Handle exceptions
            }
        });
    }

    /**
     * Returns the AuthentificationView object associated with this AuthController.
     * @return The AuthentificationView object.
     */
    public AuthentificationView getAuthentification() {
        return authentification;
    }
}
