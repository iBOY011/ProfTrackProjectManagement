package ma.ac.usms.ensak.presentation.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.auth.oauth2.Credential;

import ma.ac.usms.ensak.Main;
import ma.ac.usms.ensak.metier.Services.GoogleOAuth2Login;
import ma.ac.usms.ensak.presentation.Views.AuthentificationView;
import ma.ac.usms.ensak.presentation.Views.HomeView;

public class AuthController {
    private AuthentificationView authentification;

    public AuthController() {
        authentification = new AuthentificationView();
        authentification.getLoginButton().setOnMouseClicked(e -> {
            // try {
            //     Credential credential = GoogleOAuth2Login.authorize();
            //     if (credential != null) {
            //     }
            // } catch (IOException | InterruptedException | GeneralSecurityException ev) {
            // }
            Main.setRoot(new HomeController().getHomeView());
        });
        
    }

    public AuthentificationView getAuthentification() {
        return authentification;
    }

}
