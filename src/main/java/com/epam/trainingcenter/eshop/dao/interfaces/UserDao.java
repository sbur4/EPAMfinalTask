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
    /**
     * Interface to adds user
     *
     * @param user
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    void addUser(User user) throws SQLException, IOException, DaoException;

    /**
     * Interface to gets user
     *
     * @return users
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    List<User> getUsers() throws SQLException, IOException, DaoException;

    /**
     * Interface to gets user by login password
     *
     * @param login
     * @param password
     * @return user
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    User getUserByLoginPassword(String login, String password) throws SQLException, IOException, DaoException;

    /**
     * Interface to activates user
     *
     * @param userId
     * @param isActive
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    void ActivateUser(long userId, boolean isActive) throws SQLException, IOException, DaoException;

    /**
     * Interface to checks email is exist
     *
     * @param email
     * @return isExist
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    boolean isEmailExist(String email) throws SQLException, IOException, DaoException;
}
