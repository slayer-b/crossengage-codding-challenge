package com.crossengage.repository;

import com.crossengage.context.AppContext;
import com.crossengage.dto.User;
import com.crossengage.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    public void before() {
        AppContext appContext = new AppContext("/test_user_data.txt");
        userRepository = new UserRepository(appContext);
    }

    @Test
    public void testGetEmails() throws IOException {
        List<String> emails = userRepository.getAllEmails();

        assertThat(emails).hasSize(5);
        System.out.println(emails);
    }

    @Test
    public void testGetAll() throws IOException {
        List<User> users = userRepository.getAll();

        assertThat(users).hasSize(5);
        System.out.println(users);
    }
}
