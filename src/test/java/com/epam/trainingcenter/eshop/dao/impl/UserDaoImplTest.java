package com.epam.trainingcenter.eshop.dao.impl;

import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.User;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @BeforeAll
    static void beforeAll() {
        System.out.println("User DAO test start");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("User DAO test end");
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
    public void addUserTest() throws DaoException {
        User user = new User();
        user.setFirstName("tester");
        user.setLastName("tester");
        user.setEmail("test5@gmail.com");
        user.setPassword("test5");
        user.setActive(true);

//        userDao.addUser(user);

        List<User> users = userDao.getUsers();
        assertEquals(4, users.size());
        assertEquals(user.getFirstName(), users.get(3).getFirstName());
    }

    @Test
    public void getUserByLoginPasswordTest() throws DaoException {
        String login = "test5@gmail.com";
        String pass = "test5";
        List<User> users = userDao.getUsers();
        assertEquals(login, users.get(3).getEmail());
        assertEquals(pass, users.get(3).getPassword());
    }
}