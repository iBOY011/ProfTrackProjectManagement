package ma.ac.usms.ensak.util;

import ma.ac.usms.ensak.presentation.controller.TodayBoxController;

// Singleton class to share data between different controllers

public class SharedData {
    private static SharedData instance = null;
    private TodayBoxController todayBoxController;

    private SharedData() {}

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    public void setTodayBoxController(TodayBoxController todayBoxController) {
        this.todayBoxController = todayBoxController;
    }

    public TodayBoxController getTodayBoxController() {
        return todayBoxController;
    }
}