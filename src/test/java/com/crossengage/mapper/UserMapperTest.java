package com.crossengage.mapper;

import com.crossengage.dto.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private UserMapper userMapper;

    @BeforeEach
    public void before() {
        userMapper = new UserMapper();
    }

    @Test
    public void testParseSuccess() {
        User user = userMapper.toDTO("1,true,email,test1@mail.com,+999999999999");

        assertEquals(1, user.getId());
        assertEquals("email", user.getContactBy());
        assertEquals("test1@mail.com", user.getEmail());
        assertEquals("+999999999999", user.getPhone());
        assertTrue(user.isActive());
    }

    @Test
    public void testParseNotAllFields() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> userMapper.toDTO("1,true,email,+999999999999"));
    }

}