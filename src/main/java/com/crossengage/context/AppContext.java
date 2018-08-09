package com.crossengage.context;

import com.crossengage.mapper.UserMapper;
import com.crossengage.repository.UserRepository;
import com.crossengage.sender.EmailSender;
import com.crossengage.sender.SMSSender;
import com.crossengage.service.UserService;

import java.io.File;

public class AppContext {

    private File userFile;
    private UserMapper userMapper;
    private UserRepository userRepository;
    private EmailSender emailSender;
    private SMSSender smsSender;
    private UserService userService;

    public AppContext(String fileName) {
        userFile = new File(this.getClass().getResource(fileName).getFile());
        userMapper = new UserMapper();
        userRepository = new UserRepository(this);
        emailSender = new EmailSender();
        smsSender = new SMSSender();
        userService = new UserService(this);
    }

    public AppContext(File file) {
        userFile = file;
        userMapper = new UserMapper();
        userRepository = new UserRepository(this);
        emailSender = new EmailSender();
        smsSender = new SMSSender();
        userService = new UserService(this);
    }

    public File getUserFile() {
        return userFile;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public EmailSender getEmailSender() {
        return emailSender;
    }

    public SMSSender getSmsSender() {
        return smsSender;
    }

    public UserService getUserService() {
        return userService;
    }
}
