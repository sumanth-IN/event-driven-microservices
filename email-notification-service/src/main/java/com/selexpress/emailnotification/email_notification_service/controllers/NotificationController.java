package com.selexpress.emailnotification.email_notification_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @GetMapping("/sendEmail/{userName}")
    public String sendEmail(@PathVariable String userName){

        return "Email sent to the user: "+ userName;
    }
}
