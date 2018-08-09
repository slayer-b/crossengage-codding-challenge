package com.crossengage;

import com.crossengage.context.AppContext;
import com.crossengage.service.UserService;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        AppContext appContext = new AppContext("/test_user_data.txt");
        UserService userService = appContext.getUserService();

        System.out.println("------------------------------");
        System.out.println("Send Email");
        System.out.println("------------------------------");
        userService.sendAllEmails();
        System.out.println("------------------------------");
        System.out.println("Send SMS");
        System.out.println("------------------------------");
        userService.sendAllSMS();
        System.out.println("------------------------------");
        System.out.println("Send Both");
        System.out.println("------------------------------");
        userService.sendAllBoth();
    }

}
