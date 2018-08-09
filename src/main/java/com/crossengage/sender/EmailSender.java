package com.crossengage.sender;

import com.crossengage.dto.User;

public class EmailSender implements Sender {
    @Override
    public void send(User user) {
        System.out.println("sending Email to: " + user.getEmail());
        System.out.println(user);
    }
}
