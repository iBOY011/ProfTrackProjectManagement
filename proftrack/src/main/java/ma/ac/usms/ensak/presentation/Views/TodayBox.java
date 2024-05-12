package ma.ac.usms.ensak.presentation.Views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TodayBox extends VBox{
    private HBox header;
    private HBox search;
    private HBox list;
    private HBox project;
    private HBox footer;


    public TodayBox() {
        header = createHeader();
        search = new HBox();
        list = new HBox();
        project = new HBox();
        footer = new HBox();

        HBox[] HBoxes = new HBox[] { header, search, list, project, footer };
        double[] percentages = { 20, 10, 30, 30, 10 };
        for (int i = 0; i < HBoxes.length; i++) {
            HBox HBox = HBoxes[i];
            HBox.prefHeightProperty().bind(heightProperty().multiply(percentages[i] / 100));
        }

        header.setStyle("-fx-background-color: #f0f0f0;");

        getChildren().addAll(HBoxes);
    }
    
    public static void addButtonWithImage(HBox hbox, String imageUrl) {
        Image image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Button button = new Button();
        button.setGraphic(imageView);
        // set the style of the button 
        button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand;");
        button.setAlignment(Pos.BASELINE_RIGHT);       // add the button to the right of hbox
        hbox.getChildren().add(button);
    } 

    public static HBox createHeader() {
        // create hbox
        HBox hbox = new HBox();
        // create a label named Today and add it to the hbox
        Label label = new Label("<< Today");
        // set the style of the label
        label.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        hbox.getChildren().add(label);
        // add preference button to the hbox
        addButtonWithImage(hbox, "https://cdn-icons-png.flaticon.com/512/3185/3185894.png");

        return hbox;
    }
    
}
