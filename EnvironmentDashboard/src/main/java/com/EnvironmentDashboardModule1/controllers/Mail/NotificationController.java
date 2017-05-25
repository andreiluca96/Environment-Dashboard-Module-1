package com.EnvironmentDashboardModule1.controllers.Mail;

/**
 * Created by Luca Andrei on 5/25/2017.
 */

import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.models.Users.User;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.Mail.NotificationService;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("v1/notification")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void sendTestMail() {
        notificationService.sendMail("luca.andrei96@gmail.com", "Un NOU EVENIMENT!!!", "FUGGGIIITTTZZZ!!!");
    }

    @RequestMapping(value = "/current-event-notification", method = RequestMethod.GET)
    public void notifyUsers() {
        List<Event> eventList = eventService.getAll();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> userResponse = restTemplate.getForEntity("http://localhost:8100/v1/users/59156d656cea4a46349c8401", User.class);

        notificationService.sendMail("luca.andrei96@gmail.com", "Un NOU EVENIMENT!!!", userResponse.toString());
    }

}
