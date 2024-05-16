package ma.ac.usms.ensak.presentation.Views;

<<<<<<< HEAD
=======

import org.checkerframework.checker.units.qual.s;

>>>>>>> 45a786bfa39adcf625216e588c4d78f45c8d147a
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.presentation.Views.VBoxes.ShowBox;
import ma.ac.usms.ensak.presentation.Views.VBoxes.TodayBox;
<<<<<<< HEAD
import ma.ac.usms.ensak.presentation.controller.TodayBoxController;
=======
import ma.ac.usms.ensak.presentation.controller.DetailsController;
import ma.ac.usms.ensak.presentation.controller.ShowBoxController;
>>>>>>> 45a786bfa39adcf625216e588c4d78f45c8d147a

public class TodayView extends HBox {
    private VBox[] vBoxs;

    public TodayView() {
        // Create 4 vBoxs
<<<<<<< HEAD
        TodayBoxController todayBoxController = new TodayBoxController();
        TodayBox Today = todayBoxController.getTodayBox();
        ShowBox showBox = new ShowBox();
        VBox detailsBox = new VBox();
=======
        ShowBoxController showBoxController = new ShowBoxController();
        DetailsController detailsController = new DetailsController();
        TodayBox Today = new TodayBox();
        ShowBox showBox = showBoxController.getShowBox();
        VBox detailsBox = detailsController.getDetailsBox();
>>>>>>> 45a786bfa39adcf625216e588c4d78f45c8d147a

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