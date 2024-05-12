package ma.ac.usms.ensak.metier.management;

import java.util.List;

import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.persistance.impl.ListeToDoImpl;

public class ListToDoManager {
    
    public void createListToDo(String title, String description) {
        if (!isValidateSyntax(title, description)) {
            throw new IllegalArgumentException("Invalid syntax");
        }
        else {
            ListToDo listToDo = new ListToDo(title, description);
            ListeToDoImpl listToDoImpl = new ListeToDoImpl();
            listToDoImpl.addListeToDo(listToDo);
        }
    }

    public void updateListToDo(String title, String description) {
        if (!isValidateSyntax(title, description)) {
            throw new IllegalArgumentException("Invalid syntax");
        }
        else {
            ListToDo listToDo = new ListToDo(title, description);
            ListeToDoImpl listToDoImpl = new ListeToDoImpl();
            listToDoImpl.updateListeToDo(listToDo);
        }
    }

    public void removeListToDo(ListToDo listToDo) {
        String listToDoId = String.valueOf(listToDo.getId());
        ListeToDoImpl listToDoImpl = new ListeToDoImpl();
        listToDoImpl.deleteListeToDo(listToDoId);
    }

    public List<ListToDo> listListToDo() {
        ListeToDoImpl listToDoImpl = new ListeToDoImpl();
        return listToDoImpl.getAllListesToDo();
    }

    public boolean isValidateSyntax(String title, String description) {
        if (title == null || title.isEmpty() || title.isBlank()) {
            return false;
        }
        return (description == null || description.isEmpty() || description.isBlank());
    }
    
    // Méthodes pour rechercher une liste de taches par mot clé
    public boolean containsKeyword(String keyword){
        return listListToDo().stream().anyMatch(listToDo -> listToDo.getTitle().contains(keyword) || listToDo.getDescription().contains(keyword));
    }

    public List<ListToDo> searchProjectsByKeyword(String keyword){
        return listListToDo().stream().filter(listToDo -> listToDo.getTitle().contains(keyword) || listToDo.getDescription().contains(keyword)).toList();
    }



}
