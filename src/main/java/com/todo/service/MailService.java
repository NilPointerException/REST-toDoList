package com.todo.service;

import com.todo.controller.TaskController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {


    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    public void sendEmail(String from, String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("contact@nilauberge.tech");

        msg.setSubject("Hello World from " + from);
        msg.setText(message);

        try {
            javaMailSender.send(msg);
        } catch (MailException e) {
            LOGGER.error("Erreur lors de l'envoie du mail : " + e);
        }

    }

}
