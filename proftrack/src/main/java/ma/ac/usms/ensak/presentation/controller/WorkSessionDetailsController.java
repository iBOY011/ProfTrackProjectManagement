package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.metier.management.WorkSessionManager;
import ma.ac.usms.ensak.presentation.Views.VBoxes.WorkSessionDetailsBox;

public class WorkSessionDetailsController {
    private static WorkSessionDetailsController instance = new WorkSessionDetailsController();
    private static WorkSessionManager workSessionManager = new WorkSessionManager();
    private static WorkSessionDetailsBox workSessionDetailsBox = new WorkSessionDetailsBox();
    private static WorkSession workSession;

    public WorkSessionDetailsController() {
    }

    public static WorkSessionDetailsController getInstance() {
        return instance;
    }

    
}
