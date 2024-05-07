package ma.ac.usms.ensak.persistance.dao;

import java.util.List;

import ma.ac.usms.ensak.metier.POJO.ListToDo;

public interface ListeToDoDAO {

    void addListeToDo(ListToDo listeToDo);

    ListToDo getListeToDoById(String listeToDoId);

    List<ListToDo> getAllListesToDo();

    void updateListeToDo(ListToDo updatedListeToDo);

    void deleteListeToDo(String listeToDoId);

}