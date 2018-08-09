package com.crossengage.repository;

import com.crossengage.context.AppContext;
import com.crossengage.dto.User;
import com.crossengage.mapper.UserMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    private final UserMapper userMapper;
    private final File data;

    public UserRepository(AppContext context) {
        data = context.getUserFile();
        userMapper = context.getUserMapper();
    }

    public List<String> getAllEmails() throws IOException {
        return Files.lines(data.toPath())
                .skip(1)
                .map(line -> line.substring(line.indexOf(',', 8)+1, line.lastIndexOf(',')))
                .collect(Collectors.toList());
    }

    public List<User> getAll() throws IOException {
        System.out.println(data.toPath());
        return Files.lines(data.toPath())
                .skip(1)
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void save(User user) throws IOException {
        Files.write(data.toPath(), userMapper.fromDTO(user).concat("\n").getBytes(),
                StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    }

}
