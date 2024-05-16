package ma.ac.usms.ensak.presentation.controller;



import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.presentation.Views.AddListView;

public class AddListController {
    private static ListToDoManager listToDoManager = new ListToDoManager();
    private static AddListView addListView;
    
    public AddListController() {
        addListView = new AddListView();
        addList();
    }

    public boolean addList() {
        try {
            addListView.getSubmitButton().setOnAction(e -> {
                String title = addListView.getNameField().getText();
                String description = addListView.getDescriptionArea().getText();
                listToDoManager.createListToDo(title, description);
                addListView.getNameField().clear();
                addListView.getDescriptionArea().clear();
                ShowBoxController.showList(ShowBoxController.getList());
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public AddListView getAddListView() {
        return addListView;
    }

    public void createView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(addListView, 900, 400));
        stage.setTitle("Add List");
        stage.setResizable(false);
        stage.show();
    }



}
