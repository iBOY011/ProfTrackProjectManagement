package ma.ac.usms.ensak.metier.POJO;

public class DocTask {
    private String idDocument;
    private String idTask;

    public DocTask() {

    }

    public DocTask(String idDocument, String idTask) {
        this.idDocument = idDocument;
        this.idTask = idTask;
    }

    



    /**
     * @return String return the idDocument
     */
    public String getIdDocument() {
        return idDocument;
    }

    /**
     * @param idDocument the idDocument to set
     */
    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    /**
     * @return String return the idTask
     */
    public String getIdTask() {
        return idTask;
    }

    /**
     * @param idTask the idTask to set
     */
    public void setIdTask(String idTask) {
        this.idTask = idTask;
    }

}
