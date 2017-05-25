package com.EnvironmentDashboardModule1.services.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by Luca Andrei on 5/25/2017.
 */

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String email, String subject, String content) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom("environment.dashboard@gmail.com");
        mail.setSubject(subject);
        mail.setText(content);

        javaMailSender.send(mail);
    }
}
