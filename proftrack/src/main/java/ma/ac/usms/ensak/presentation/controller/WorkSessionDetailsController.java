package ma.ac.usms.ensak.presentation.controller;


import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.metier.management.WorkSessionManager;
import ma.ac.usms.ensak.presentation.Views.VBoxes.WorkSessionDetailsBox;

public class WorkSessionDetailsController {
    private static WorkSessionDetailsController instance = new WorkSessionDetailsController();
    private static WorkSessionManager workSessionManager = new WorkSessionManager();
    private static WorkSessionDetailsBox workSessionDetailsBox;
    private static WorkSession workSession;

    public WorkSessionDetailsController() {
    }

    public static WorkSessionDetailsController getInstance() {
        return instance;
    }

    public WorkSessionDetailsBox getWorkSessionDetailsBox() {
        return workSessionDetailsBox;
    }

    private void updateWorkSession(WorkSession workSession) {
        
        workSessionDetailsBox.getAddNote().setOnAction(e -> {
            workSession.setNote(workSessionDetailsBox.getTxtNote().getText());
            workSessionManager.updateWorkSession(workSession);
            workSessionDetailsBox.setWorkSession(workSession);
        });
    }

    private void closeWorkSession(WorkSession workSession) {
        workSessionDetailsBox.getClose().setOnAction(e -> {
            workSession.setClosed(true);
            workSessionManager.updateWorkSession(workSession);
            workSessionDetailsBox.setWorkSession(workSession);
        });
    }

    public void showDetails(String id) {
        workSession = workSessionManager.searchWorkSessionById(id);
        workSessionDetailsBox.setWorkSession(workSession);
        updateWorkSession(workSession);
        closeWorkSession(workSession);
    }

    public Boolean createView(String id) {
        try {
            Stage stage = new Stage();
            stage.setTitle("Work Session Details");
            workSessionDetailsBox = new WorkSessionDetailsBox();
            showDetails(id);
            Scene scene = new Scene(workSessionDetailsBox, 400, 600);
            stage.setScene(scene);
            stage.show();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
}
