package ma.ac.usms.ensak.metier.management;

import java.util.List;

import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.persistance.impl.ListeToDoImpl;

public class ListToDoManager {

    // implementer les methodes CRUD en utilisant les fonctions dans la package DAO
    public void createListToDo(String title, String description) {
        if (!isValidateSyntax(title , description)) {
            throw new IllegalArgumentException("Invalid syntax");
        }
        else {
            ListToDo listToDo = new ListToDo();
            ListeToDoImpl listToDoImpl = new ListeToDoImpl();
            listToDoImpl.addListeToDo(listToDo);
        }
    }

    public void updateListToDo(String title, String description) {
        if (!isValidateSyntax(title , description)) {
            throw new IllegalArgumentException("Invalid syntax");
        }
        else {
            ListToDo listToDo = new ListToDo();
            ListeToDoImpl listToDoImpl = new ListeToDoImpl();
            listToDoImpl.updateListeToDo(listToDo);
        }
    }

    public void removeListToDo(ListToDo listToDo) {
        String listToDoId = String.valueOf(listToDo.getId());
        ListeToDoImpl listToDoImpl = new ListeToDoImpl();
        listToDoImpl.deleteListeToDo(listToDoId);
    }

    public ListToDo searchListToDoById(String listToDoId) {
        ListeToDoImpl listToDoImpl = new ListeToDoImpl();
        return listToDoImpl.getListeToDoById(listToDoId);
    }

    public List<ListToDo> listListToDos() {
        ListeToDoImpl listToDoImpl = new ListeToDoImpl();
        return listToDoImpl.getAllListesToDo();
    }

    private boolean isValidateSyntax(String title, String description) {
        if (title == null || title.isEmpty() || title.isBlank()) {
            return false;
        }
        if (description == null || description.isEmpty() || description.isBlank()) {
            return false;
        }
        return true;
    }
    
}
