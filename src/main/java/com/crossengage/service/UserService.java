package com.crossengage.service;

import com.crossengage.context.AppContext;
import com.crossengage.dto.User;
import com.crossengage.repository.UserRepository;
import com.crossengage.sender.EmailSender;
import com.crossengage.sender.SMSSender;

import java.io.IOException;

public class UserService {

    private final UserRepository userRepository;
    private final EmailSender emailSender;
    private final SMSSender smsSender;

    public UserService(AppContext appContext) {
        userRepository = appContext.getUserRepository();
        emailSender = appContext.getEmailSender();
        smsSender = appContext.getSmsSender();
    }

    public void sendAllEmails() throws IOException {
        userRepository.getAll().forEach((User u) -> {
            if (u.isActive() && u.getEmail() != null) {
                emailSender.send(u);
            }
        });
    }

    public void sendAllSMS() throws IOException {
        userRepository.getAll().forEach((User u) -> {
            if (u.isActive() && u.getEmail() != null) {
                smsSender.send(u);
            }
        });
    }

    public void sendAllBoth() throws IOException {
        userRepository.getAll().forEach((User u) -> {
            if (u.isActive() && u.getEmail() != null) {
                emailSender.send(u);
                smsSender.send(u);
            }
        });
    }

}
