package ma.ac.usms.ensak.metier.management;

import java.util.ArrayList;

import ma.ac.usms.ensak.metier.POJO.Document;
import ma.ac.usms.ensak.persistance.impl.DocumentImpl;

/**
 * 
 */
public class DocumentManager {
    
    private ArrayList<Document> documents;
    private DocumentImpl documentImpl;

    public DocumentManager() {
        documents = new ArrayList<Document>();
        documentImpl = new DocumentImpl();
    }

    public void sort() {
    }

    // validate 


}
