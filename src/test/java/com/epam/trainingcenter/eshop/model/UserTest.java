package com.epam.trainingcenter.eshop.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("User entity test start");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("User entity test end");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Test start");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test end");
    }

    @Test
    void setIdTest() {
        User user = new User();
        user.setId(3);
        assertTrue(user.getId() == 3);
        assertFalse(user.getId() == 5);
    }

    @Test
    void setFirstNameTest() {
        User user = new User();
        user.setFirstName("Test");
        assertTrue(user.getFirstName().equalsIgnoreCase("test"));
        assertFalse(user.getFirstName().equalsIgnoreCase("hello"));
    }

    @Test
    void setLastNameTest() {
        User user = new User();
        user.setLastName("epam");
        assertTrue(user.getLastName().equalsIgnoreCase("EPAM"));
        assertFalse(user.getLastName().equalsIgnoreCase("java"));
    }

    @Test
    void setEmailTest() {
        User user = new User();
        user.setEmail("admin@gmail.com");
        assertTrue(user.getEmail().equalsIgnoreCase("admin@gmail.com"));
        assertFalse(user.getEmail().equalsIgnoreCase("user@gmail.com"));
    }

    @Test
    void setPasswordTest() {
        User user = new User();
        user.setPassword("qwerty12345");
        assertTrue(user.getPassword().equalsIgnoreCase("qwerty12345"));
        assertFalse(user.getPassword().equalsIgnoreCase("testpassword"));
    }
}