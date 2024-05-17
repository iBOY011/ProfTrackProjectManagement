package ma.ac.usms.ensak.persistance.impl;

import com.google.gson.Gson;

import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.persistance.dao.ListeToDoDAO;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.persistance.StorageFile;
import static ma.ac.usms.ensak.persistance.StorageFile.*;

public class ListeToDoImpl implements ListeToDoDAO {
    private static final String JSON_FILE_PATH = "src\\main\\resources\\databases\\listestodo.json";

    public ListeToDoImpl() {
    }

    @Override
    public void addListeToDo(ListToDo listeToDo) {
        List<ListToDo> listesToDos = readObjectsFromJsonFile(JSON_FILE_PATH, ListToDo.class);
        if (listesToDos == null) {
            listesToDos = new ArrayList<>();
        }
        listesToDos.add(listeToDo);
        saveToJsonFile(listesToDos, JSON_FILE_PATH);
    }

    @Override
    public ListToDo getListeToDoById(String listeToDoId) {
        List<ListToDo> listesToDo = readObjectsFromJsonFile(JSON_FILE_PATH, ListToDo.class);
        for (ListToDo listeToDo : listesToDo) {
            if (String.valueOf(listeToDo.getId()).contentEquals(listeToDoId)) {
                return listeToDo;
            }
        }
        return null; // ListeToDo not found
    }

    @Override
    public List<ListToDo> getAllListesToDo() {
        List<ListToDo> listesToDo = StorageFile.readObjectsFromJsonFile(JSON_FILE_PATH, ListToDo.class);
        return listesToDo;
    }

    @Override
    public void updateListeToDo(ListToDo updatedListeToDo) {
        List<ListToDo> listesToDo = readObjectsFromJsonFile(JSON_FILE_PATH, ListToDo.class);
        ;
        for (int i = 0; i < listesToDo.size(); i++) {
            ListToDo listeToDo = listesToDo.get(i);
            if (listeToDo.getId().contentEquals(updatedListeToDo.getId())) {
                listesToDo.set(i, updatedListeToDo);
                break;
            }
        }
        saveToJsonFile(listesToDo, JSON_FILE_PATH);
        // ListeToDo not found, do nothing or throw an exception
    }

    @Override
    public void deleteListeToDo(String listeToDoId) {
        List<ListToDo> listesToDo = readObjectsFromJsonFile(JSON_FILE_PATH, ListToDo.class);
        String id = listeToDoId; // Convert listeToDoId to integer
        listesToDo.removeIf(listeToDo -> listeToDo.getId().contentEquals(id)); // Compare with the id property
        saveToJsonFile(listesToDo, JSON_FILE_PATH);
    }

}
