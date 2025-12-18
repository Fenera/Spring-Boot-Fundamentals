package com.application.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService implements NotificationService{

    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private int port;
    public void sendMessage(String message, String recipientEmail){
        System.out.printf("%nHost: %s%nPort:%d%n", host, port);
        System.out.println("From: " + recipientEmail);
        System.out.println(message);
    }
}
