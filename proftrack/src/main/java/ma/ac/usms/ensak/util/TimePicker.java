package ma.ac.usms.ensak.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.StringConverter;

import java.time.LocalTime;
import java.util.Arrays;

public class TimePicker extends HBox {
    private ComboBox<String> hourComboBox;
    private ComboBox<String> minuteComboBox;

    public TimePicker() {
        hourComboBox = new ComboBox<>();
        minuteComboBox = new ComboBox<>();

        // Populate hour and minute combo boxes
        ObservableList<String> hours = FXCollections.observableArrayList(Arrays.asList(getHours()));
        hourComboBox.setItems(hours);
        hourComboBox.getSelectionModel().selectFirst();

        ObservableList<String> minutes = FXCollections.observableArrayList(Arrays.asList(getMinutes()));
        minuteComboBox.setItems(minutes);
        minuteComboBox.getSelectionModel().selectFirst();

        // Set up the layout
        this.getChildren().addAll(hourComboBox, minuteComboBox);
        this.setSpacing(5);
        HBox.setHgrow(hourComboBox, Priority.ALWAYS);
        HBox.setHgrow(minuteComboBox, Priority.ALWAYS);

        // Set up string converters for combo boxes
        hourComboBox.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return string;
            }
        });

        minuteComboBox.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return string;
            }
        });
    }

    public LocalTime getSelectedTime() {
        int hour = Integer.parseInt(hourComboBox.getValue());
        int minute = Integer.parseInt(minuteComboBox.getValue());
        return LocalTime.of(hour, minute);
    }

    private String[] getHours() {
        String[] hours = new String[24];
        for (int i = 0; i < 24; i++) {
            hours[i] = String.format("%02d", i);
        }
        return hours;
    }

    private String[] getMinutes() {
        String[] minutes = new String[60];
        for (int i = 0; i < 60; i++) {
            minutes[i] = String.format("%02d", i);
        }
        return minutes;
    }

    public void reset() {
        hourComboBox.getSelectionModel().selectFirst();
        minuteComboBox.getSelectionModel().selectFirst();
    }
}
