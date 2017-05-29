package com.EnvironmentDashboardModule1.controllers.Mail;

/**
 * Created by Luca Andrei on 5/25/2017.
 */

import com.EnvironmentDashboardModule1.models.Events.Event;
import com.EnvironmentDashboardModule1.models.Events.Fire;
import com.EnvironmentDashboardModule1.models.Users.User;
import com.EnvironmentDashboardModule1.services.EventMappingService;
import com.EnvironmentDashboardModule1.services.EventService;
import com.EnvironmentDashboardModule1.services.FireService;
import com.EnvironmentDashboardModule1.services.Mail.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;

import java.util.*;

@RestController
@RequestMapping("v1/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private EventService eventService;

    @Autowired
    private FireService fireService;

    @Autowired
    private EventMappingService eventMappingService;


    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public void sendTestMail(@PathVariable Long id) throws MessagingException {
        Event event = eventService.getById(id);
        String eventType = eventMappingService.getById(event.getId()).getEventType();
        String title = "";
        String content = "";
        String headerColor = "";
        String severityColor = "";
        StringBuilder message = new StringBuilder();
        String header = "";
        String specialAttributes = "";


        header = getHeader(eventType, header);
        specialAttributes = getSpecialAttributes(eventType, event, specialAttributes);

        title = "New event alert!";
        headerColor = getHeaderColor(event.getSeverity(), headerColor);
        severityColor = getSeverityColor(event.getSeverity(), severityColor);

        message.append("<table style=\"margin: 0px auto; width:500px\">");
        message.append(headerColor);
        message.append("<td style='padding:30px 30px 0px;text-align:center;font-family: Arial, Helvetica, sans-serif;'>");
        //content = "<p style=\"font-size:22px\"><b>A new event just happened in one of your locations</b></p><br>";
        message.append(header);
        message.append("</td>");
        message.append("</tr>");
        content = "";
        content += severityColor;
        message.append("<tr bgcolor=\"#F5F5F5\" style='font-family: Arial, Helvetica, sans-serif;'>");

        content += specialAttributes;
        content += "<br>Description: " + event.getDescription();
        content += "<br>We recommend you to: " + event.getHints();
        content += "<br>Starting time: " + event.getStartingTime();
        content += "<br>Ending time: " + event.getEndingTime();
        content += "<br><br>Stay safe.<br><i>Environment Dashboard Team</i>";

        message.append("<td style='padding:30px;font-size:14px'>");
        message.append(content);
        message.append("</td>");
        message.append("</tr>");
        message.append("</table>");
        content = message.toString();


        notificationService.sendMail("sabisav@yahoo.com", title, content);
    }

    public String getHeaderColor(String severity, String headerColor) {
        if (severity.equals("RED")) {
            headerColor = "<tr bgcolor=\"#DC143C\" style='color:white'>";
        } else if (severity.equals("GREEN")) {
            headerColor = "<tr bgcolor=\"#3CB371\" style='color:white'>";
        } else if (severity.equals("YELLOW")) {
            headerColor = "<tr bgcolor=\"#FFDF00\" style='color:white'>";
        } else {
            headerColor = "<tr bgcolor=\" #FF7F50\" style='color:white'>";
        }
        return headerColor;

    }

    public String getSeverityColor(String severity, String severityColor) {
        if (severity.equals("RED")) {
            severityColor = "Severity: <font color='#DC143C'><b>RED</b></font>";
        } else if (severity.equals("GREEN")) {
            severityColor = "Severity: <font color='#3CB371'><b>GREEN</b></font>";
        } else if (severity.equals("YELLOW")) {
            severityColor = "Severity: <font color='#FFDF00'><b>YELLOW</b></font>";
        } else {
            severityColor = "Severity: <font color= '#FF7F50'><b>ORANGE</b></font>";
        }

        return severityColor;
    }


    public String getHeader(String eventType, String header) {
        switch (eventType) {
            case "Event":
                header = "<p style=\"font-size:22px\"><b>There's a new event in your area</b></p><br>";
                break;
            case "Fire":
                header = "<p style=\"font-size:22px\"><b>There's a fire in your area</b></p><br>";
                break;

        }
        return header;

    }

    public String getSpecialAttributes(String eventType, Event event, String specialAttributes) {
        switch (eventType) {
            case "Fire":
                Fire fire = fireService.getById(event.getId());
                specialAttributes += "<br>Speed: " + fire.getSpeed();
                break;

        }
        return specialAttributes;

    }

    @RequestMapping(value = "/current-event-notification", method = RequestMethod.GET)
    public void notifyUsers() throws MessagingException {
        List<Event> eventList = eventService.getAll();
        for (Event event : eventList) {
            Date currentDate = new Date();
            if (event.getStartingTime().before(currentDate) && event.getEndingTime().after(currentDate)) {
                User[] users = getUsersInRange(event);

                try {
                    sendEmailToUsersWithEvent(users, event);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    public void notifyUsersForEvent(@PathVariable Long id) throws MessagingException {
        Event event = eventService.getById(id);
        User[] users = getUsersInRange(event);

        try {
            sendEmailToUsersWithEvent(users, event);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/notification-daemon", method = RequestMethod.GET)
    public void startDaemon() {
        new Thread(() -> {
            Map<Long, Boolean> notifiedEvent = new HashMap<>();

            for (Event event : eventService.getAll()) {
                notifiedEvent.put(event.getId(), Boolean.FALSE);
            }

            while (true) {
                List<Event> events = eventService.getAll();

                for (Event event : events) {
                    Date currentDate = new Date();
                    if ((notifiedEvent.get(event.getId()) == null || notifiedEvent.get(event.getId()).equals(Boolean.FALSE)) &&
                            event.getStartingTime().before(currentDate) &&
                            event.getEndingTime().after(currentDate)) {
                        try {
                            notifyUsersForEvent(event.getId());
                        } catch (MessagingException e) {
                            e.printStackTrace();
                        }
                        notifiedEvent.put(event.getId(), Boolean.TRUE);
                    }
                }
            }
        }).start();
    }

    private void sendEmailToUsersWithEvent(User[] users, Event event) throws MessagingException {
        String eventType = eventMappingService.getById(event.getId()).getEventType();
        String title = "";
        String content = "";
        String headerColor = "";
        String severityColor = "";
        StringBuilder message = new StringBuilder();
        String header = "";
        String specialAttributes = "";


        header = getHeader(eventType, header);
        specialAttributes = getSpecialAttributes(eventType, event, specialAttributes);

        title = "New event alert!";
        headerColor = getHeaderColor(event.getSeverity(), headerColor);
        severityColor = getSeverityColor(event.getSeverity(), severityColor);

        message.append("<table style=\"margin: 0px auto; width:500px\">");
        message.append(headerColor);
        message.append("<td style='padding:30px 30px 0px;text-align:center;font-family: Arial, Helvetica, sans-serif;'>");
        //content = "<p style=\"font-size:22px\"><b>A new event just happened in one of your locations</b></p><br>";
        message.append(header);
        message.append("</td>");
        message.append("</tr>");
        content = "";
        content += severityColor;
        message.append("<tr bgcolor=\"#F5F5F5\" style='font-family: Arial, Helvetica, sans-serif;'>");

        content += specialAttributes;
        content += "<br>Description: " + event.getDescription();
        content += "<br>We recommend you to: " + event.getHints();
        content += "<br>Starting time: " + event.getStartingTime();
        content += "<br>Ending time: " + event.getEndingTime();
        content += "<br><br>Stay safe.<br><i>Environment Dashboard Team</i>";

        message.append("<td style='padding:30px;font-size:14px'>");
        message.append(content);
        message.append("</td>");
        message.append("</tr>");
        message.append("</table>");
        content = message.toString();


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
