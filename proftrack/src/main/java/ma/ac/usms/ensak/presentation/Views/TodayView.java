package ma.ac.usms.ensak.presentation.Views;


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



}
