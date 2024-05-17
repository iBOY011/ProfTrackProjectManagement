package ma.ac.usms.ensak.metier.Services;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import com.google.api.services.calendar.Calendar;

public class GoogleCalendarExample {
        public static void main(String[] args) throws IOException, GeneralSecurityException {
                Calendar service = GoogleCalendarService.getCalendarService();

                Event event = new Event()
                                .setSummary("Google I/O 2021")
                                .setLocation("800 Howard St., San Francisco, CA 94103")
                                .setDescription("A chance to hear more about Google's developer products.");

                DateTime startDateTime = new DateTime("2021-05-28T09:00:00-07:00");
                EventDateTime start = new EventDateTime()
                                .setDateTime(startDateTime)
                                .setTimeZone("America/Los_Angeles");
                event.setStart(start);

                DateTime endDateTime = new DateTime("2021-05-28T17:00:00-07:00");
                EventDateTime end = new EventDateTime()
                                .setDateTime(endDateTime)
                                .setTimeZone("America/Los_Angeles");
                event.setEnd(end);

                String[] recurrence = new String[] { "RRULE:FREQ=DAILY;COUNT=2" };
                event.setRecurrence(Arrays.asList(recurrence));

                String calendarId = "primary";
                event = service.events().insert(calendarId, event).execute();
                System.out.printf("Event created: %s\n", event.getHtmlLink());
        }
}
