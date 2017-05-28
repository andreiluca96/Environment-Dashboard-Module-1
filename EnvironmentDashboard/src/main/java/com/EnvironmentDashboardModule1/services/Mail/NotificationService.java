package com.EnvironmentDashboardModule1.services.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Luca Andrei on 5/25/2017.
 */

@Service
public class NotificationService {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private String port;

    public void sendMail(String email, String subject, String content) throws MessagingException {

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        Session session = Session.getInstance(properties,auth);
        Message mail = new MimeMessage(session);
        InternetAddress[] toAddresses = { new InternetAddress(email) };
        mail.setRecipients(Message.RecipientType.TO, toAddresses);
        mail.setFrom(new InternetAddress("environment.dashboard@gmail.com"));
        mail.setSubject(subject);
        mail.setContent(content,"text/html");

        Transport.send(mail);
    }

    /*@Autowired
    private JavaMailSender javaMailSender;
    public void sendMail(String email, String subject, String content) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom("environment.dashboard@gmail.com");
        mail.setSubject(subject);
        mail.setText(content);

        javaMailSender.send(mail);
    }*/

}
