package com.crossengage.mapper;

import com.crossengage.dto.User;

import java.sql.Blob;

public class UserMapper {

    public User toDTO(String line) {
        String[] parsedUser = line.split(",");
        User user = new User();
        user.setId(Integer.parseInt(parsedUser[0]));
        user.setActive(Boolean.parseBoolean(parsedUser[1]));
        user.setContactBy(parsedUser[2]);
        user.setEmail(parsedUser[3]);
        user.setPhone(parsedUser[4]);
        return user;
    }

    public String fromDTO(User user) {
        return String.valueOf(user.getId()) + "," +
                user.isActive() + "," +
                user.getContactBy() + "," +
                user.getEmail() + "," +
                user.getPhone();
    }
}
