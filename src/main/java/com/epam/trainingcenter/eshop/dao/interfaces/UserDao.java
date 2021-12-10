package com.epam.trainingcenter.eshop.dao.interfaces;

import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sburch
 * @version 1.0
 * interface to handle the database operation required to manipulate User entity
 */

public interface UserDao {
    void addUser(User user) throws SQLException, IOException, DaoException;

    List<User> getUsers() throws SQLException, IOException, DaoException;

    User getUserByLoginPassword(String login, String password) throws SQLException, IOException, DaoException;

    void ActivateUser(long userId, boolean isActive) throws SQLException, IOException, DaoException;

    boolean isEmailExist(String email) throws SQLException, IOException, DaoException;
}
