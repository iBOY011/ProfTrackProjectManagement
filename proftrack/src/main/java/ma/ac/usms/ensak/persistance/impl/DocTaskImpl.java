package ma.ac.usms.ensak.persistance.impl;

import java.util.ArrayList;
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.DocTask;
import static ma.ac.usms.ensak.persistance.StorageFile.*;
import ma.ac.usms.ensak.persistance.dao.DocTaskDAO;

public class DocTaskImpl implements DocTaskDAO {
    private static final String JSON_FILE_PATH = "src\\main\\resources\\databases\\doctasks.json";

    @Override
    public void addDocTask(DocTask docTask) {
        List<DocTask> doctasks = readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
        if (doctasks == null) {
            doctasks = new ArrayList<>();
        }
        doctasks.add(docTask);
        saveToJsonFile(doctasks, JSON_FILE_PATH);
    }

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

    @Override
    public void deleteAllDocTask() {
        saveToJsonFile(null, JSON_FILE_PATH);

    }

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

    @Override
    public List<DocTask> getAllDocTasks() {
        return readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
    }

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

    @Override
    public List<DocTask> getDocTaskByTask(String idTask) {
        List<DocTask> doctasks = readObjectsFromJsonFile(JSON_FILE_PATH, DocTask.class);
        List<DocTask> result = new ArrayList<>();
        result.clear();
        for (int i = 0; i < doctasks.size(); i++) {
            DocTask doctask = doctasks.get(i);
            if (doctask.getIdTask().equals(idTask)) {
                result.add(doctask);
            }
        }
        return result;
    }

}
