package ma.ac.usms.ensak.metier.management;

import java.util.List;

import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.persistance.impl.ListeToDoImpl;

/**
 * The ListToDoManager class is responsible for managing the operations related to ListToDo objects.
 */
public class ListToDoManager {

    /**
     * Creates a new ListToDo with the given title and description.
     *
     * @param title       The title of the ListToDo.
     * @param description The description of the ListToDo.
     */
    public void createListToDo(String title, String description) {

        ListToDo listToDo = new ListToDo(title, description);
        ListeToDoImpl listToDoImpl = new ListeToDoImpl();
        listToDoImpl.addListeToDo(listToDo);

    }

    /**
     * Updates the ListToDo with the given title and description.
     *
     * @param title       The new title of the ListToDo.
     * @param description The new description of the ListToDo.
     */
    public void updateListToDo(String title, String description) {

        ListToDo listToDo = new ListToDo(title, description);
        ListeToDoImpl listToDoImpl = new ListeToDoImpl();
        listToDoImpl.updateListeToDo(listToDo);

    }

    /**
     * Removes the ListToDo with the given listToDoId.
     *
     * @param listToDoId The ID of the ListToDo to be removed.
     */
    public void removeListToDo(String listToDoId) {
        ListeToDoImpl listToDoImpl = new ListeToDoImpl();
        listToDoImpl.deleteListeToDo(listToDoId);
    }

    /**
     * Returns a list of all ListToDo objects.
     *
     * @return A list of all ListToDo objects.
     */
    public List<ListToDo> listListToDo() {
        ListeToDoImpl listToDoImpl = new ListeToDoImpl();
        return listToDoImpl.getAllListesToDo();
    }

    /**
     * Checks if any ListToDo contains the given keyword in its title or description.
     *
     * @param keyword The keyword to search for.
     * @return true if any ListToDo contains the keyword, false otherwise.
     */
    public boolean containsKeyword(String keyword) {
        return listListToDo().stream().anyMatch(
                listToDo -> listToDo.getTitle().contains(keyword) || listToDo.getDescription().contains(keyword));
    }

    /**
     * Searches for ListToDo objects that contain the given keyword in their title or description.
     *
     * @param keyword The keyword to search for.
     * @return A list of ListToDo objects that contain the keyword.
     */
    public List<ListToDo> searchLitsByKeyword(String keyword) {
        return listListToDo().stream().filter(
                listToDo -> listToDo.getTitle().contains(keyword) || listToDo.getDescription().contains(keyword))
                .toList();
    }

    /**
     * Searches for a ListToDo with the given listeToDoId.
     *
     * @param listeToDoId The ID of the ListToDo to search for.
     * @return The ListToDo object with the given ID, or null if not found.
     */
    public ListToDo searchListeToDoById(String listeToDoId) {
        ListeToDoImpl listToDoImpl = new ListeToDoImpl();
        return listToDoImpl.getListeToDoById(listeToDoId);
    }

}
