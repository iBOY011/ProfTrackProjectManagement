package ma.ac.usms.ensak;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
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

    private void switchScene(Scene scene) {
        Stage stage = (Stage) scene.getWindow();
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);

    }
}