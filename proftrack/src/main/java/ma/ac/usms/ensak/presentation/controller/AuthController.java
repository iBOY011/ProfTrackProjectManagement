package ma.ac.usms.ensak.presentation.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.auth.oauth2.Credential;

import ma.ac.usms.ensak.metier.Services.GoogleOAuth2Login;

public class AuthController {
    void authController() {
        try {
            Credential credential = GoogleOAuth2Login.authorize();
            System.out.println("Login successful! Access token: " + credential.getAccessToken());
        } catch (IOException | InterruptedException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
