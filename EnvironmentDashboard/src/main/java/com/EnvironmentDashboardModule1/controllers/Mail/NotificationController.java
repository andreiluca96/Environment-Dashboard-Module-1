package com.EnvironmentDashboardModule1.controllers.Mail;

/**
 * Created by Luca Andrei on 5/25/2017.
 */

import com.EnvironmentDashboardModule1.services.Mail.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/notification")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void sendTestMail() {
        notificationService.sendMail("luca.andrei96@gmail.com", "Un NOU EVENIMENT!!!", "FUGGGIIITTTZZZ!!!");
    }
}
