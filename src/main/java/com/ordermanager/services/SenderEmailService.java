package com.ordermanager.services;

import com.ordermanager.OrderManagerApplication;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SenderEmailService {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SenderEmailService.class);


    private final JavaMailSender mailSender;

    @Value("${support.email}")
    private String fromEmail;

    @Autowired
    public SenderEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendEmail(String to, String subject, String message) {
        try {

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(fromEmail);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);

            this.mailSender.send(simpleMailMessage);


        } catch (Exception e) {
             System.out.print(e.getMessage());
        }
    }

}
