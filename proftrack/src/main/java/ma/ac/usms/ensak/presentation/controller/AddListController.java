/**
 * The AddListController class is responsible for managing the addition of a new list in the application.
 * It interacts with the ListToDoManager and AddListView classes to handle the user input and display the appropriate alerts.
 */
package ma.ac.usms.ensak.presentation.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.exception.AlertHandler;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.presentation.Views.AddListView;

public class AddListController {
    private static ListToDoManager listToDoManager = new ListToDoManager();
    private static AddListView addListView;
    
    /**
     * Constructs an AddListController object and initializes the AddListView.
     * It also calls the addList() method to handle the addition of a new list.
     */
    public AddListController() {
        addListView = new AddListView();
        addList();
    }

    /**
     * Handles the addition of a new list.
     * It retrieves the title and description from the AddListView,
     * validates the input, creates a new list using the ListToDoManager,
     * clears the input fields, updates the list view, displays a success alert,
     * and hides the AddListView window.
     * @return true if the list is added successfully, false otherwise.
     */
    public boolean addList() {
        try {
            addListView.getSubmitButton().setOnAction(e -> {
                String title = addListView.getNameField().getText();
                String description = addListView.getDescriptionArea().getText();
                if (title.isEmpty() || description.isEmpty()){
                    AlertHandler.showFailureAlert("Please fill all fields");
                    return;
                }
                listToDoManager.createListToDo(title, description);
                addListView.getNameField().clear();
                addListView.getDescriptionArea().clear();
                ShowBoxController.showList(ShowBoxController.getList());
                AlertHandler.showSuccessAlert("List added successfully");
                addListView.getScene().getWindow().hide();
            });
            return true;
        } catch (Exception e) {
            AlertHandler.showFailureAlert("List not added");
            return false;
        }
    }

    /**
     * Returns the AddListView object associated with this controller.
     * @return the AddListView object.
     */
    public AddListView getAddListView() {
        return addListView;
    }

    /**
     * Creates and displays the AddListView window.
     */
    public void createView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(addListView, 640, 400));
        stage.getScene().getStylesheets().add("/Css/Home.css");
        stage.setTitle("Add List");
        stage.setResizable(false);
        stage.show();
    }
}
