package ma.ac.usms.ensak.persistance.impl;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocTask;
import static ma.ac.usms.ensak.persistance.StorageFile.*;
import ma.ac.usms.ensak.persistance.dao.DocTaskDAO;

/**
 * Implementation of the DocTaskDAO interface that provides methods to manipulate DocTask objects.
 */
public class DocTaskImpl implements DocTaskDAO {
    private static final String JSON_FILE_PATH = "src\\main\\resources\\databases\\doctasks.json";

    /**
     * Adds a new DocTask to the database.
     *
     * @param docTask The DocTask object to be added.
     */
    @Override
    public void addDocTask(DocTask docTask) {
        List<DocTask> doctasks = readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
        if (doctasks == null) {
            doctasks = new ArrayList<>();
        }
        doctasks.add(docTask);
        saveToJsonFile(doctasks, JSON_FILE_PATH);
    }

    /**
     * Deletes a DocTask from the database based on the document ID and task ID.
     *
     * @param idDocument The ID of the document.
     * @param idTask     The ID of the task.
     */
    @Override
    public void deleteDocTask(String idDocument, String idTask) {
        List<DocTask> doctasks = readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
        for (int i = 0; i < doctasks.size(); i++) {
            DocTask doctask = doctasks.get(i);
            if (doctask.getIdDocument().equals(idDocument) && doctask.getIdTask().equals(idTask)) {
                doctasks.remove(i);
                saveToJsonFile(doctasks, JSON_FILE_PATH);
                return;
            }
        }
    }

    /**
     * Deletes all DocTasks associated with a specific document.
     *
     * @param idDocument The ID of the document.
     */
    @Override
    public void deleteDocTaskByDocument(String idDocument) {
        List<DocTask> doctasks = readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
        for (int i = 0; i < doctasks.size(); i++) {
            DocTask doctask = doctasks.get(i);
            if (doctask.getIdDocument().equals(idDocument)) {
                doctasks.remove(i);
            }
        }
        saveToJsonFile(doctasks, JSON_FILE_PATH);
    }

    /**
     * Deletes all DocTasks associated with a specific task.
     *
     * @param idTask The ID of the task.
     */
    @Override
    public void deleteDocTaskByTask(String idTask) {
        List<DocTask> doctasks = readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
        for (int i = 0; i < doctasks.size(); i++) {
            DocTask doctask = doctasks.get(i);
            if (doctask.getIdTask().equals(idTask)) {
                doctasks.remove(i);
            }
        }
        saveToJsonFile(doctasks, JSON_FILE_PATH);
    }

    /**
     * Deletes all DocTasks from the database.
     */
    @Override
    public void deleteAllDocTask() {
        saveToJsonFile(null, JSON_FILE_PATH);
    }

    /**
     * Updates a DocTask in the database.
     *
     * @param updatedDocTask The updated DocTask object.
     */
    @Override
    public void updateDocTask(DocTask updatedDocTask) {
        List<DocTask> doctasks = readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
        for (int i = 0; i < doctasks.size(); i++) {
            DocTask doctask = doctasks.get(i);
            if (doctask.getIdDocument().equals(updatedDocTask.getIdDocument())
                    && doctask.getIdTask().equals(updatedDocTask.getIdTask())) {
                doctasks.set(i, updatedDocTask);
                saveToJsonFile(doctasks, JSON_FILE_PATH);
                return;
            }
        }
    }

    /**
     * Retrieves a specific DocTask from the database based on the document ID and task ID.
     *
     * @param idDocument The ID of the document.
     * @param idTask     The ID of the task.
     * @return The DocTask object if found, or null if not found.
     */
    @Override
    public DocTask getDocTask(String idDocument, String idTask) {
        List<DocTask> doctasks = readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
        for (DocTask doctask : doctasks) {
            if (doctask.getIdDocument().equals(idDocument) && doctask.getIdTask().equals(idTask)) {
                return doctask;
            }
        }
        return null;
    }

    /**
     * Retrieves all DocTasks from the database.
     *
     * @return A list of all DocTask objects.
     */
    @Override
    public List<DocTask> getAllDocTasks() {
        return readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
    }

    /**
     * Retrieves all DocTasks associated with a specific document.
     *
     * @param idDocument The ID of the document.
     * @return A list of DocTask objects associated with the document.
     */
    @Override
    public List<DocTask> getDocTaskByDocument(String idDocument) {
        List<DocTask> doctasks = readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
        List<DocTask> result = new ArrayList<>();
        result.clear();
        for (int i = 0; i < doctasks.size(); i++) {
            DocTask doctask = doctasks.get(i);
            if (doctask.getIdDocument().equals(idDocument)) {
                result.add(doctask);
            }
        }
        return result;
    }

    /**
     * Retrieves all DocTasks associated with a specific task.
     *
     * @param idTask The ID of the task.
     * @return A list of DocTask objects associated with the task.
     */
    @Override
    public List<DocTask> getDocTaskByTask(String idTask) {
        List<DocTask> doctasks = readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
        List<DocTask> result = new ArrayList<>();
        result.clear();
        for (int i = 0; i < doctasks.size(); i++) {
            DocTask doctask = doctasks.get(i);
            if (doctask.getIdTask().contentEquals(idTask)) {
                result.add(doctask);
            }
        }
        return result;
    }
}
