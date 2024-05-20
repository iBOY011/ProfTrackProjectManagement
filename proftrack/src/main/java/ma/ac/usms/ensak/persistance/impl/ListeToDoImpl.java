package ma.ac.usms.ensak.persistance.impl;

import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.persistance.dao.ListeToDoDAO;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.persistance.StorageFile;
import static ma.ac.usms.ensak.persistance.StorageFile.*;

/**
 * Implementation of the ListeToDoDAO interface.
 * Provides methods to add, retrieve, update, and delete ListToDo objects.
 */
public class ListeToDoImpl implements ListeToDoDAO {
    private static final String JSON_FILE_PATH = "src\\main\\resources\\databases\\listestodo.json";

    /**
     * Default constructor.
     */
    public ListeToDoImpl() {
    }

    /**
     * Adds a ListToDo object to the JSON file.
     *
     * @param listeToDo The ListToDo object to be added.
     */
    @Override
    public void addListeToDo(ListToDo listeToDo) {
        List<ListToDo> listesToDos = readObjectsFromJsonFile(JSON_FILE_PATH, ListToDo.class);
        if (listesToDos == null) {
            listesToDos = new ArrayList<>();
        }
        listesToDos.add(listeToDo);
        saveToJsonFile(listesToDos, JSON_FILE_PATH);
    }

    /**
     * Retrieves a ListToDo object by its ID.
     *
     * @param listeToDoId The ID of the ListToDo object to retrieve.
     * @return The ListToDo object with the specified ID, or null if not found.
     */
    @Override
    public ListToDo getListeToDoById(String listeToDoId) {
        List<ListToDo> listesToDo = readObjectsFromJsonFile(JSON_FILE_PATH, ListToDo.class);
        for (ListToDo listeToDo : listesToDo) {
            if (String.valueOf(listeToDo.getId()).contentEquals(listeToDoId)) {
                return listeToDo;
            }
        }
        return null;
    }

    /**
     * Retrieves all ListToDo objects from the JSON file.
     *
     * @return A list of all ListToDo objects.
     */
    @Override
    public List<ListToDo> getAllListesToDo() {
        List<ListToDo> listesToDo = StorageFile.readObjectsFromJsonFile(JSON_FILE_PATH, ListToDo.class);
        return listesToDo;
    }

    /**
     * Updates a ListToDo object in the JSON file.
     *
     * @param updatedListeToDo The updated ListToDo object.
     */
    @Override
    public void updateListeToDo(ListToDo updatedListeToDo) {
        List<ListToDo> listesToDo = readObjectsFromJsonFile(JSON_FILE_PATH, ListToDo.class);
        for (int i = 0; i < listesToDo.size(); i++) {
            ListToDo listeToDo = listesToDo.get(i);
            if (listeToDo.getId().contentEquals(updatedListeToDo.getId())) {
                listesToDo.set(i, updatedListeToDo);
                break;
            }
        }
        saveToJsonFile(listesToDo, JSON_FILE_PATH);
    }

    /**
     * Deletes a ListToDo object from the JSON file.
     *
     * @param listeToDoId The ID of the ListToDo object to delete.
     */
    @Override
    public void deleteListeToDo(String listeToDoId) {
        List<ListToDo> listesToDo = readObjectsFromJsonFile(JSON_FILE_PATH, ListToDo.class);
        String id = listeToDoId;
        listesToDo.removeIf(listeToDo -> listeToDo.getId().contentEquals(id));
        saveToJsonFile(listesToDo, JSON_FILE_PATH);
    }
}
