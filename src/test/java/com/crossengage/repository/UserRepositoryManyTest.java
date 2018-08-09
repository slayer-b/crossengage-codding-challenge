package com.crossengage.repository;

import com.crossengage.context.AppContext;
import com.crossengage.dto.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryManyTest {

    private UserRepository userRepository;

    @BeforeEach
    public void before() throws Exception {
        File tempFile = File.createTempFile("asd", ".txt");
        tempFile.deleteOnExit();
        AppContext appContext = new AppContext(tempFile);
        userRepository = new UserRepository(appContext);
    }

    @Test
    public void testManyUsers() throws IOException {
        for (int i = 1; i < 1_000_001; i++) {
//        mers satter - why square is not a subtype of rectangle
//        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(i);
            user.setActive(true);
            user.setContactBy("email");
            user.setEmail(i + "@gmail.com");
            user.setPhone("+1" + i);
            userRepository.save(user);
            System.out.println(i);
        }
        List<User> emails = userRepository.getAll();

        assertThat(emails).hasSize(10_000);
        System.out.println(emails);
    }
}
