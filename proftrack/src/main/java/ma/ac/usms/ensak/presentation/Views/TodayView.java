package ma.ac.usms.ensak.presentation.Views;

import org.checkerframework.checker.units.qual.s;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.presentation.Views.VBoxes.ShowBox;
import ma.ac.usms.ensak.presentation.Views.VBoxes.TodayBox;
import ma.ac.usms.ensak.presentation.controller.TodayBoxController;
import ma.ac.usms.ensak.presentation.controller.DetailsController;
import ma.ac.usms.ensak.presentation.controller.ShowBoxController;

public class TodayView extends HBox {
    private VBox[] vBoxs;

    public TodayView() {
        // Create 4 vBoxs
        TodayBoxController todayBoxController = new TodayBoxController();
        TodayBox Today = todayBoxController.getTodayBox();
        ShowBoxController showBoxController = new ShowBoxController();
        DetailsController detailsController = new DetailsController();
        ShowBox showBox = showBoxController.getShowBox();
        VBox detailsBox = detailsController.getDetailsBox();

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