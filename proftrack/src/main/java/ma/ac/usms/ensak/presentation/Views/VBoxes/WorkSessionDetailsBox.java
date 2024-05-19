package ma.ac.usms.ensak.presentation.Views.VBoxes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.metier.POJO.WorkSession;

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
    private TextField txtNote;
    private TextField txtProjectId;
    private TextField txtStatus;

    private SimpleDateFormat dateFormat;

    public WorkSessionDetailsBox() {
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

        txtNote = new TextField();
        txtNote.setEditable(false);

        txtProjectId = new TextField();
        txtProjectId.setEditable(false);

        txtStatus = new TextField();
        txtStatus.setEditable(false);

        this.getChildren().addAll(
            lblDescription, txtDescription,
            lblDateDebut, txtDateDebut,
            lblDateFin, txtDateFin,
            lblNote, txtNote,
            lblProjectId, txtProjectId,
            lblStatus, txtStatus
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
    }
}
