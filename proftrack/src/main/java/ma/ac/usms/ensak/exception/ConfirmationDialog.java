package ma.ac.usms.ensak.exception;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ConfirmationDialog {

    public static boolean showConfirmationDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);

        // Create OK and Cancel buttons
        ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        // Add buttons to the dialog
        alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

        // Show the dialog and wait for the user's response
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == buttonTypeOK;
    }
}
