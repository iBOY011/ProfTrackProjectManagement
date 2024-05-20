package ma.ac.usms.ensak.presentation.Views;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.Services.GoogleCalendarMajidi;
import ma.ac.usms.ensak.metier.Services.GoogleCalendarService;
import com.google.api.services.calendar.model.Event;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class CalendarViewMajidi extends VBox{
    public CalendarViewMajidi() {
        setPadding(new Insets(20));
        setSpacing(10);
        setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Upcoming Events");
        getChildren().add(titleLabel);

        new Thread(() -> {
            try {
                List<Event> events = GoogleCalendarMajidi.getUpcomingEvents();
                Platform.runLater(() -> {
                    for (Event event : events) {
                        Label eventLabel = new Label(event.getSummary());
                        getChildren().add(eventLabel);
                    }
                });
            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
            }
        }).start();
    }
}