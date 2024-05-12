package ma.ac.usms.ensak.presentation.Views;

<<<<<<< HEAD

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TodayView extends HBox { 

    private Button button;
    

    public TodayView() {



        Text text = new Text("Enter Password:");
        PasswordField passwordField = new PasswordField();
        button = new Button("Switch to Authentification View");


        this.getChildren().add(text);
        this.getChildren().add(passwordField);
        this.getChildren().add(button);


        

    }

    public Object getButton() {
        return button;
    }



=======
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

public class TodayView extends HBox {
    private StackPane[] StackPanes;

    public TodayView(Stage primaryStage) {
        // Create 4 StackPanes
        StackPane navbarBox = new StackPane();
        StackPane menuBox = new StackPane();
        StackPane showBox = new StackPane();
        StackPane detailsBox = new StackPane();
        
        // Set the preferred size of each StackPane by percentage 1 -> 10% 2 -> 20% 3 -> 40% 4 -> 30%
        StackPanes = new StackPane[]{navbarBox, menuBox, showBox, detailsBox};
        double[] percentages = {10, 20, 40, 30};
        for (int i = 0; i < StackPanes.length; i++) {
            StackPane StackPane = StackPanes[i];
            StackPane.prefWidthProperty().bind(primaryStage.widthProperty().multiply(percentages[i] / 100));
        }

        // Set the preferred height of each StackPane 100%
        for (StackPane StackPane : StackPanes) {
            StackPane.prefHeightProperty().bind(primaryStage.heightProperty());
        }
        
        // add StackPane to HBox
        getChildren().addAll(navbarBox, menuBox, showBox, detailsBox);       
    }
    
    public Parent getView() {
        return this;
    }

    public StackPane[] getStackPanes() {
        return StackPanes;
    }

    public StackPane getNavbarBox() {
        return StackPanes[0];
    }

    public StackPane getMenuBox() {
        return StackPanes[1];
    }

    public StackPane getShowBox() {
        return StackPanes[2];
    }

    public StackPane getDetailsBox() {
        return StackPanes[3];
    }
    
>>>>>>> 1d35a40c437889b48cd676a79d653a2c06aeb9ee
}
