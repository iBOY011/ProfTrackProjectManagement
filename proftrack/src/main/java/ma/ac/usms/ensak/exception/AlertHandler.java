package ma.ac.usms.ensak.exception;

import java.util.Random;

import javafx.scene.control.Alert;

public class AlertHandler {
    private static final String[] FINISHED_TASK_SENTENCES = {
            "Double-checking is key! Make sure everything's done before marking it finished.",
            "Don't forget to review all the details before finalizing the task as finished.",
            "Sometimes, it's the little things that get missed. Take a moment to ensure everything's complete.",
            "Hey, before you hit that 'finished' button, take a moment to verify everything's done.",
            "A task marked as finished should be truly complete. Take a moment to review.",
            "Remember, there's no rush. Take the time to ensure everything's finished before marking it as such.",
            "Completing a task is great! Just make sure it's truly done before marking it finished.",
            "Before calling it 'finished', take a moment to review all the details.",
            "Almost there! Just a quick check to ensure everything's been taken care of before marking it finished.",
            "Hey, just a friendly reminder to double-check everything before marking the task as finished."
    };

    private static final String[] INVALID_DATE_SENTENCES = {
            "Oops! Looks like the start date cannot be after the end date. Please review and correct your input.",
            "Hmm, it seems the start date should be before the end date. Please try again.",
            "Invalid date range! The start date must be earlier than the end date. Please adjust your selection.",
            "Please ensure that the start date is not later than the end date.",
            "Invalid date range detected. Please check your selection and try again.",
            "Hey, it looks like the start date you selected is after the end date. Please review and correct it.",
            "Hmm, it seems the start date should precede the end date. Please check your input.",
            "Invalid date range! The start date cannot be later than the end date. Please adjust your selection accordingly."
    };

    private static final String[] START_DATE_SENTENCES = {
        "Oops! The start date cannot be before today's date. Please select a valid start date.",
        "Hmm, it seems you've selected a start date in the past. Please choose a date from today onwards.",
        "Invalid start date! The start date cannot be earlier than today. Please adjust your selection."
};

    private static String getInvalidStartDateSentence() {
        Random random = new Random();
        int index = random.nextInt(START_DATE_SENTENCES.length);
        return START_DATE_SENTENCES[index];
    }

    public static void showInvalidStartDateAlert() {
        String errorMessage = getInvalidStartDateSentence();
        showAlert("Invalid Start Date", errorMessage, Alert.AlertType.ERROR);
    }

    public static void showAlert(String HeaderText, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(HeaderText);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static String getFinishedTaskSentence() {
        Random random = new Random();
        int index = random.nextInt(FINISHED_TASK_SENTENCES.length);
        return FINISHED_TASK_SENTENCES[index];
    }

    public static void showInvalidDateAlert() {
        String errorMessage = getInvalidDateSentence();
        showAlert("Invalid Date", errorMessage, Alert.AlertType.ERROR);
    }

    public static void showSuccessAlert(String message) {
        showAlert(null, message, Alert.AlertType.INFORMATION);
    }

    public static void showFailureAlert(String message) {
        showAlert(null, message, Alert.AlertType.ERROR);
    }

    public static String getInvalidDateSentence() {
        Random random = new Random();
        int index = random.nextInt(INVALID_DATE_SENTENCES.length);
        return INVALID_DATE_SENTENCES[index];
    }
}
