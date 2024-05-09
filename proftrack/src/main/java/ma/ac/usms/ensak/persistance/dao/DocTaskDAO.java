package ma.ac.usms.ensak.persistance.dao;

import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocTask;

public interface DocTaskDAO {
    void addDocTask(DocTask docTask);

    void deleteDocTask(String idDocument, String idTask);

    void deleteDocTaskByDocument(String idDocument);

    void deleteDocTaskByTask(String idTask);

    void deleteAllDocTask();

    void updateDocTask(DocTask updatedDocTask);

    DocTask getDocTask(String idDocument, String idTask);

    List<DocTask> getDocTaskByDocument(String idDocument);

    List<DocTask> getDocTaskByTask(String idTask);

    List<DocTask> getAllDocTasks();

}
