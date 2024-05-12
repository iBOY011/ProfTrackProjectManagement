package ma.ac.usms.ensak.presentation.Views;


import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.presentation.Views.VBoxes.ShowBox;
import ma.ac.usms.ensak.presentation.Views.VBoxes.TodayBox;

public class TodayView extends HBox {
    private VBox[] vBoxs;

    public TodayView() {
        // Create 4 vBoxs
        TodayBox Today = new TodayBox();
        ShowBox showBox = new ShowBox();
        VBox detailsBox = new VBox();

        // Set the preferred size of each VBox by percentage 1 -> 10% 2 -> 20% 3 -> 40%
        // 4 -> 30%
        vBoxs = new VBox[] { showBox, Today, detailsBox };
        double[] percentages = { 20, 40, 40 };
        for (int i = 0; i < vBoxs.length; i++) {
            VBox StackPane = vBoxs[i];
            StackPane.prefWidthProperty().bind(widthProperty().multiply(percentages[i] / 100));
        }

        // Set the preferred height of each VBox 100%
        for (VBox StackPane : vBoxs) {
            StackPane.prefHeightProperty().bind(heightProperty());
        }

        // add VBox to HBox
        getChildren().addAll(showBox, Today, detailsBox);
    }

    public VBox[] getVBoxs() {
        return vBoxs;
    }

}