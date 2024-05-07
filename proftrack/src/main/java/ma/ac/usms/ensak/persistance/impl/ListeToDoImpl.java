package ma.ac.usms.ensak.persistance.impl;

import com.google.gson.Gson;

import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.persistance.dao.ListeToDoDAO;

import java.util.List;

import static ma.ac.usms.ensak.persistance.StorageFile.*;

public class ListeToDoImpl implements ListeToDoDAO {
    private static final String JSON_FILE_PATH = "src/main/resources/databases/listestodo.json";
    private Gson gson;

    public ListeToDoImpl() {
        gson = new Gson();
    }

    @Override
    public void addListeToDo(ListToDo listeToDo) {
        List<ListToDo> listesToDo = readObjectsFromJsonFile(JSON_FILE_PATH);
        listeToDo.setId(listesToDo.size() + 1);
        saveToJsonFile(listeToDo, JSON_FILE_PATH);
    }

    @Override
    public ListToDo getListeToDoById(String listeToDoId) {
        List<ListToDo> listesToDo = readObjectsFromJsonFile(JSON_FILE_PATH);
        for (ListToDo listeToDo : listesToDo) {
            if (String.valueOf(listeToDo.getId()).equals(listeToDoId)) {
                return listeToDo;
            }
        }
        return null;
    }

    @Override
    public List<ListToDo> getAllListesToDo() {
        return readObjectsFromJsonFile(JSON_FILE_PATH);
    }

    @Override
    public void updateListeToDo(ListToDo updatedListeToDo) {
        List<ListToDo> listesToDo = readObjectsFromJsonFile(JSON_FILE_PATH);
        for (int i = 0; i < listesToDo.size(); i++) {
            ListToDo listeToDo = listesToDo.get(i);
            if (listeToDo.getId() == updatedListeToDo.getId()) {
                listesToDo.set(i, updatedListeToDo);
                saveToJsonFile(listeToDo, JSON_FILE_PATH);
                return;
            }
        }
        // ListeToDo not found, do nothing or throw an exception
    }

    @Override
    public void deleteListeToDo(String listeToDoId) {
        List<ListToDo> listesToDo = readObjectsFromJsonFile(JSON_FILE_PATH);
        int id = Integer.parseInt(listeToDoId); // Convert listeToDoId to integer
        listesToDo.removeIf(listeToDo -> listeToDo.getId() == id); // Compare with the id property
        saveListToJsonFile(listesToDo, JSON_FILE_PATH);
    }

   
}
