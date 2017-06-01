package com.EnvironmentDashboardModule1.controllers.Mail;

/**
 * Created by Luca Andrei on 5/25/2017.
 */

import com.EnvironmentDashboardModule1.models.Events.*;
import com.EnvironmentDashboardModule1.models.MeteoEvents.MeteoEvent;
import com.EnvironmentDashboardModule1.models.Severity;
import com.EnvironmentDashboardModule1.models.Users.User;
import com.EnvironmentDashboardModule1.services.Event.*;
import com.EnvironmentDashboardModule1.services.Mail.NotificationService;
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
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
    private EarthquakeService earthquakeService;
    @Autowired
    private FloodService floodService;
    @Autowired
    private TsunamiService tsunamiService;
    @Autowired
    private TerroristAttackService terroristAttackService;
    @Autowired
    private TornadoService tornadoService;
    @Autowired
    private MeteoEventService meteoEventService;
    @Autowired
    private EventMappingService eventMappingService;


    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public void sendTestMail(@PathVariable Long id) throws MessagingException {
        Event event = eventService.getById(id);
        String subject;
        String content;
        subject=getSubject(event);
        content=getContent(event);

        notificationService.sendMail("sabisav@yahoo.com", subject, content);
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

    /*
    @RequestMapping(value = "/notification-scheduler", method = RequestMethod.GET)
    public void startScheduler() {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }
*/

    private String getContent(Event event){
        String content="";
        String eventType = eventMappingService.getById(event.getId()).getEventType();
        String headerColor;
        String severityColor;
        StringBuilder message = new StringBuilder();
        String header;
        String specialAttributes = "";

        header = getHeader(eventType);
        specialAttributes = getSpecialAttributes(eventType, event);

        headerColor = getHeaderColor(event.getSeverity());
        severityColor = getSeverityColor(event.getSeverity());

        message.append("<table style='margin: 0px auto; width:500px;font-family: Arial, Helvetica, sans-serif;'>");
        message.append(headerColor);
        message.append("<th style='color:white;font-size:22px; padding:40px;text-align:center'>");
        message.append(header);
        message.append("</th>");
        message.append("</tr>");
        content = "";
        content += severityColor;
        message.append("<tr bgcolor='#F5F5F5'>");

        content += specialAttributes;
        content += "<br><strong>Description: </strong>" + event.getDescription();
        content += "<br><strong>We recommend you to: </strong>" + event.getHints();
        content += "<br><strong>Starting time: </strong>" + event.getStartingTime();
        content += "<br><strong>Ending time: </strong>" + event.getEndingTime();
        content += "<br><br>Stay safe,<br><i>Environment Dashboard Team</i>";

        message.append("<td style='padding:30px;font-size:14px'>");
        message.append(content);
        message.append("</td>");
        message.append("</tr>");
        message.append("</table>");
        content = message.toString();

        return content;
    }

    private String getSubject(Event event){
        String eventType = eventMappingService.getById(event.getId()).getEventType();
        String subject="";
        switch (eventType) {
            case "Event":
                subject = "New Event Alert!";
                break;
            case "MeteoEvent":
                subject = "New Meteo Event Alert!";
                break;
            case "Fire":
                subject = "Fire Alert!";
                break;
            case "Earthquake":
                subject = "Earthquake Alert!";
                break;
            case "Flood":
                subject = "Flood Alert!";
                break;
            case "Tsunami":
                subject = "Tsunami Alert!";
                break;
            case "Tornado":
                subject = "Tornado Alert!";
                break;
            case "TerroristAttack":
                subject = "Terrorist Attack Alert!";
                break;
            case "CanicularWeather":
                subject = "Canicular Weather Warning!";
                break;
            case "ColdWeather":
                subject = "Cold Weather Warning!";
                break;
            case "Fog":
                subject = "Fog Warning!";
                break;
            case "Snow":
                subject = "Snow Warning!";
                break;
            case "Rain":
                subject = "Rain Warning!";
                break;
        }
        return subject;
    }


    private String getHeaderColor(Severity severity) {
        String headerColor;
        if (severity.equals(Severity.RED)) {
            headerColor = "<tr bgcolor='#DC143C'>";
        } else if (severity.equals(Severity.GREEN)) {
            headerColor = "<tr bgcolor='#3CB371'>";
        } else if (severity.equals(Severity.YELLOW)) {
            headerColor = "<tr bgcolor='#FFDF00'>";
        } else {
            headerColor = "<tr bgcolor='#FF7F50'>";
        }
        return headerColor;

    }

    private String getSeverityColor(Severity severity) {
        String severityColor = "<strong>Severity: </strong>";
        if (severity.equals(Severity.RED)) {
            severityColor += "<font color='#DC143C'><b>RED</b></font>";
        } else if (severity.equals(Severity.GREEN)) {
            severityColor += "<font color='#3CB371'><b>GREEN</b></font>";
        } else if (severity.equals(Severity.YELLOW)) {
            severityColor += "<font color='#FFDF00'><b>YELLOW</b></font>";
        } else {
            severityColor += "<font color= '#FF7F50'><b>ORANGE</b></font>";
        }
        return severityColor;
    }


    private String getHeader(String eventType) {
        String header="";
        switch (eventType) {
            case "Event":
                header = "There's a new event in your area!";
                break;
            case "MeteoEvent":
                header = "There's a new meteo event in your area!";
                break;
            case "Fire":
                header = "There's a fire in your area!";
                break;
            case "Earthquake":
                header = "There's an earthquake in your area!";
                break;
            case "Flood":
                header = "There's a flood in your area!";
                break;
            case "Tsunami":
                header = "There's a tsunami in your area!";
                break;
            case "Tornado":
                header = "There's a tornado in your area!";
                break;
            case "TerroristAttack":
                header = "There's a terrorist attack in your area!";
                break;
            case "CanicularWeather":
                header = "Canicular Weather warning!";
                break;
            case "ColdWeather":
                header = "Cold Weather warning!";
                break;
            case "Fog":
                header = "Fog warning!";
                break;
            case "Snow":
                header = "Snow warning!";
                break;
            case "Rain":
                header = "Rain warning!";
                break;
        }
        return header;
    }

    private String getSpecialAttributes(String eventType, Event event) {
        String specialAttributes="";
        switch (eventType) {
            case "Event":
                specialAttributes = "";
                break;
            case "Fire":
                Fire fire = fireService.getById(event.getId());
                specialAttributes += "<br><strong>Speed: </strong>" + fire.getSpeed();
                break;
            case "Earthquake":
                Earthquake earthquake = earthquakeService.getById(event.getId());
                specialAttributes += "<br><strong>Depth: </strong>" + earthquake.getDepth();
                specialAttributes += "<br><strong>Mercalli degree: </strong>" + earthquake.getMercalliDegree();
                specialAttributes += "<br><strong>Richter degree: </strong>" + earthquake.getRichterDegree();
                break;
            case "Flood":
                Flood flood = floodService.getById(event.getId());
                specialAttributes += "<br><strong>Precipitation level: </strong>" + flood.getPrecipitationLevel();
                break;
            case "Tsunami":
                Tsunami tsunami = tsunamiService.getById(event.getId());
                specialAttributes += "<br><strong>Max wave height: </strong>" + tsunami.getMaxWaveHeight();
                break;
            case "Tornado":
                Tornado tornado = tornadoService.getById(event.getId());
                specialAttributes += "<br><strong>Wind speed: </strong>" + tornado.getWindSpeed();
                break;
            case "TerroristAttack":
                TerroristAttack terroristAttack = terroristAttackService.getById(event.getId());
                specialAttributes += "<br><strong>Number of terrorists: </strong>" + terroristAttack.getNumberOfTerrorists();
                break;
            default:
                MeteoEvent meteoEvent = meteoEventService.getById(event.getId());
                specialAttributes += "<br><strong>Humidity: </strong>" + meteoEvent.getHumidity();
                specialAttributes += "<br><strong>Precipitation level: </strong>" + meteoEvent.getPrecipitationLevel();
                specialAttributes += "<br><strong>Temperature: </strong>" + meteoEvent.getTemperature();
        }
        return specialAttributes;

    }



    private void sendEmailToUsersWithEvent(User[] users, Event event) throws MessagingException {
        String subject;
        String content;
        subject=getSubject(event);
        content=getContent(event);

        for (User user : users) {
            notificationService.sendMail(user.getEmail(), subject, content);
        }
    }

    private User[] getUsersInRange(Event event) {
        RestTemplate restTemplate = new RestTemplate();
        User[] users = restTemplate.getForObject("http://localhost:8100/v1/users/" + event.getLatitude() + "/" + event.getLongitude() + "/" + event.getRadius(), User[].class);

        return users;
    }
/*
    public class NotificationJob implements Job {
        private Map<Long, Boolean> notifiedEvent = new HashMap<>();

        public NotificationJob() {
            for (Event event : eventService.getAll()) {
                notifiedEvent.put(event.getId(), Boolean.FALSE);
            }
        }

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
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
    }
    */
}
