package ma.ac.usms.ensak;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.checkerframework.checker.units.qual.A;

import com.google.api.client.auth.oauth2.Credential;
import com.ibm.icu.util.Region;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
<<<<<<< HEAD
import ma.ac.usms.ensak.presentation.Views.AuthentificationView;
import ma.ac.usms.ensak.presentation.Views.TodayView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene todayView = new Scene(new TodayView());
        primaryStage.setScene(todayView);

        Scene authentificationView = new Scene(new AuthentificationView());

        TodayView todayViewNode = (TodayView) todayView.getRoot(); // Cast the root to TodayView
        ((Object) todayViewNode.getButton()).setOnAction(event -> switchScene(authentificationView));

        primaryStage.show();
    }
=======
import ma.ac.usms.ensak.metier.Services.GoogleOAuth2Login;
import ma.ac.usms.ensak.presentation.Views.Auth;
import ma.ac.usms.ensak.presentation.Views.NavBarBox;
import ma.ac.usms.ensak.presentation.Views.TodayBox;
import ma.ac.usms.ensak.presentation.Views.TodayView;
import ma.ac.usms.ensak.presentation.controller.AuthController;

public class Main extends Application {
>>>>>>> 1d35a40c437889b48cd676a79d653a2c06aeb9ee

    private void switchScene(Scene scene) {
        Stage stage = (Stage) scene.getWindow();
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the TodayView
        AuthController authController = new AuthController();
        Auth auth = new Auth();
        auth.autosize();
        // Create the Scene
        Scene scene = new Scene(auth, 800, 600);
        
        // Set the scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}