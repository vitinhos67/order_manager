package com.ordermanager.services;

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");



            helper.setText(message, true);



            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject(subject);

            this.mailSender.send(mimeMessage);


        } catch (Exception e) {
             System.out.print(e.getMessage());
        }
    }

}
