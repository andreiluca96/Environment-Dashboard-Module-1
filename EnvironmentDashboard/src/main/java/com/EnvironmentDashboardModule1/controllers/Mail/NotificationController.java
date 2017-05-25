package com.EnvironmentDashboardModule1.controllers.Mail;

/**
 * Created by Luca Andrei on 5/25/2017.
 */

import com.EnvironmentDashboardModule1.models.EventMapping;
import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.models.Users.User;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.Mail.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private EventService eventService;

    @Autowired
    private EventMappingService eventMappingService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void sendTestMail() {
        notificationService.sendMail("luca.andrei96@gmail.com", "Un NOU EVENIMENT!!!", "FUGGGIIITTTZZZ!!!");
    }

    @RequestMapping(value = "/current-event-notification", method = RequestMethod.GET)
    public void notifyUsers() {
        List<Event> eventList = eventService.getAll();
        for (Event event : eventList) {
            Date currentDate = new Date();
            if (event.getStartingTime().before(currentDate) && event.getEndingTime().after(currentDate)) {
                User[] users = getUsersInRange(event);

                sendEmailToUsersWithEvent(users, event);
            }
        }
    }

    private void sendEmailToUsersWithEvent(User[] users, Event event) {
        String eventType  = eventMappingService.getById(event.getId()).getEventType();
        String title = "";
        String content = "";

        if (eventType.equals("Event")) {
            title = "A new event just happened!";
            content = "A new event just happened in one of your locations.\n";
            content += "Severity: " + event.getSeverity() + "\n";
            content += "Description: " + event.getDescription() + "\n";
            content += "We recommend you to " + event.getHints() + "\n";
            content += "Starting time: " + event.getStartingTime() + "\n";
            content += "Ending time: " + event.getEndingTime() + "\n";

            content += "\n\n\n";

            content += "Take care of you.\nEnvironment dashboard.";
        }

        for (User user : users) {
            notificationService.sendMail(user.getEmail(), title, content);
        }
    }

    private User[] getUsersInRange(Event event) {
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject("http://localhost:8100/v1/users/" + event.getLatitude() + "/" + event.getLongitude() + "/" + event.getRadius(), User[].class);

        return users;
    }

}
