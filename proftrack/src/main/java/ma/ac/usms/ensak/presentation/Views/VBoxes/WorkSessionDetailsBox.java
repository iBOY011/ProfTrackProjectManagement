package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.metier.POJO.WorkSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class WorkSessionDetailsBox extends VBox {

    private Label lblDescription;
    private Label lblDateDebut;
    private Label lblDateFin;
    private Label lblNote;
    private Label lblProjectId;
    private Label lblStatus;

    private TextField txtDescription;
    private TextField txtDateDebut;
    private TextField txtDateFin;
    private TextArea txtNote;
    private TextField txtProjectId;
    private TextField txtStatus;
    private Button addNote;
    private Button close;
    private Boolean isClosed = false;

    private SimpleDateFormat dateFormat;

    public WorkSessionDetailsBox() {
        // Apply CSS
        this.getStylesheets().add(getClass().getResource("/Css/Session.css").toExternalForm());

        dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        lblDescription = new Label("Description:");
        lblDateDebut = new Label("Start Date:");
        lblDateFin = new Label("End Date:");
        lblNote = new Label("Note:");
        lblProjectId = new Label("Project ID:");
        lblStatus = new Label("Status:");

        txtDescription = new TextField();
        txtDescription.setEditable(false);

        txtDateDebut = new TextField();
        txtDateDebut.setEditable(false);

        txtDateFin = new TextField();
        txtDateFin.setEditable(false);

        txtNote = new TextArea();
        txtNote.setEditable(true);
        txtNote.setWrapText(true);

        addNote = new Button("Add Note");

        close = new Button("Close Now");

        txtStatus = new TextField();
        txtStatus.setEditable(false);

        HBox statusBox = new HBox(txtStatus, close);
        statusBox.getStyleClass().add("hbox");

        txtProjectId = new TextField();
        txtProjectId.setEditable(false);

        // Add style classes
        lblDescription.getStyleClass().add("label");
        lblDateDebut.getStyleClass().add("label");
        lblDateFin.getStyleClass().add("label");
        lblNote.getStyleClass().add("label");
        lblProjectId.getStyleClass().add("label");
        lblStatus.getStyleClass().add("label");

        txtDescription.getStyleClass().add("text-field");
        txtDateDebut.getStyleClass().add("text-field");
        txtDateFin.getStyleClass().add("text-field");
        txtNote.getStyleClass().add("text-area");
        txtProjectId.getStyleClass().add("text-field");
        txtStatus.getStyleClass().add("text-field");

        addNote.getStyleClass().add("button");
        close.getStyleClass().add("button");

        this.getChildren().addAll(
            lblDescription, txtDescription,
            lblDateDebut, txtDateDebut,
            lblDateFin, txtDateFin,
            lblProjectId, txtProjectId,
            lblStatus, statusBox,
            lblNote, txtNote,
            addNote
        );

        this.setSpacing(10);
    }

    public void setWorkSession(WorkSession workSession) {
        txtDescription.setText(workSession.getDescription());
        txtDateDebut.setText(dateFormat.format(workSession.getDateDebut()));
        txtDateFin.setText(dateFormat.format(workSession.getDateFin()));
        txtNote.setText(workSession.getNote());
        txtProjectId.setText(workSession.getId_project());
        txtStatus.setText(workSession.isClosed() ? "Closed" : "Open");
        isClosed = workSession.isClosed();
    }

    public void clear() {
        txtDescription.clear();
        txtDateDebut.clear();
        txtDateFin.clear();
        txtNote.clear();
        txtProjectId.clear();
        txtStatus.clear();
    }

    public TextArea getTxtNote() {
        return txtNote;
    }

    public WorkSession getWorkSession() throws ParseException {
        WorkSession workSession = new WorkSession();
        workSession.setDescription(txtDescription.getText());
        workSession.setDateDebut(dateFormat.parse(txtDateDebut.getText()));
        workSession.setDateFin(dateFormat.parse(txtDateFin.getText()));
        workSession.setNote(txtNote.getText());
        workSession.setId_project(txtProjectId.getText());
        workSession.setClosed(isClosed);
        return workSession;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public Button getAddNote() {
        return addNote;
    }

    public Button getClose() {
        return close;
    }
}
