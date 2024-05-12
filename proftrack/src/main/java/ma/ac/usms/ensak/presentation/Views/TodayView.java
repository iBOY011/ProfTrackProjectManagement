package ma.ac.usms.ensak.presentation.Views;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.Main;

public class TodayView extends HBox {
    private VBox[] vBoxs;

    public TodayView() {
        // Create 4 vBoxs
        NavBarBox navbarBox = new NavBarBox();
        TodayBox Today = new TodayBox();
        VBox showBox = new VBox();
        VBox detailsBox = new VBox();

        // Set the preferred size of each VBox by percentage 1 -> 10% 2 -> 20% 3 -> 40%
        // 4 -> 30%
        vBoxs = new VBox[] { navbarBox, Today, showBox, detailsBox };
        double[] percentages = { 10, 20, 40, 30 };
        for (int i = 0; i < vBoxs.length; i++) {
            VBox StackPane = vBoxs[i];
            StackPane.prefWidthProperty().bind(Main.getScene().widthProperty().multiply(percentages[i] / 100));
        }

        // Set the preferred height of each VBox 100%
        for (VBox StackPane : vBoxs) {
            StackPane.prefHeightProperty().bind(Main.getScene().heightProperty());
        }

        // add VBox to HBox
        getChildren().addAll(navbarBox, Today, showBox, detailsBox);
    }

    public Parent getView() {
        return this;
    }

}