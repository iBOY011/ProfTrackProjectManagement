package ma.ac.usms.ensak;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ma.ac.usms.ensak.presentation.controller.AuthController;

public class Main extends Application {
    Stage primaryStage;
    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        AuthController authController = new AuthController();
        scene = new Scene(authController.getAuthentification(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void setRoot (Pane pane) {
        scene.setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Scene getScene() {
        return scene;
    }
}