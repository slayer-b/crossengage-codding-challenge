package com.crossengage.sender;

import com.crossengage.dto.User;

public class SMSSender implements Sender {
    @Override
    public void send(User user) {
        System.out.println("sending SMS to: " + user.getPhone());
        System.out.println(user);
    }
}
