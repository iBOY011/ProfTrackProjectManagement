package ma.ac.usms.ensak.presentation.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.auth.oauth2.Credential;

import ma.ac.usms.ensak.Main;
import ma.ac.usms.ensak.metier.Services.GoogleOAuth2Login;
import ma.ac.usms.ensak.presentation.Views.Auth;
import ma.ac.usms.ensak.presentation.Views.TodayView;

public class AuthController {
    private Auth authentification;

    public AuthController() {
        authentification = new Auth();
        authentification.getLoginButton().setOnMouseClicked(e -> {
            try {
                Credential credential = GoogleOAuth2Login.authorize();
                if (credential != null) {
                    Main.setRoot(new TodayView());
                }
            } catch (IOException | InterruptedException | GeneralSecurityException ev) {
            }
        });
        
    }

    public Auth getAuthentification() {
        return authentification;
    }

}
