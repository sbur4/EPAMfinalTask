package com.epam.trainingcenter.eshop.dao.impl;

import com.epam.trainingcenter.eshop.connection.ConnectionPool;
import com.epam.trainingcenter.eshop.dao.interfaces.UserDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * @version 1.0
 */

public class UserDaoImpl extends ConnectionPool implements UserDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    private static final String INSERT_INTO_USERS = "INSERT USER(first_name, last_name, email, password, admin, active) VALUES" +
            "(?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_BY_LOGIN_PASSWORD = "SELECT id, first_name, last_name, email, password, admin, active FROM" +
            " USER WHERE email = ? AND password = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM USER WHERE admin = 0";
    private static final String UPDATE_USER_ACTIVITY = "UPDATE USER SET  active = ? WHERE id = ?";
    private static final String CHECK_LOGIN = "SELECT * FROM user WHERE email = ?";

    /**
     * Default constructor
     */
    public UserDaoImpl() {
    }

    /**
     * Method add User to database
     *
     * @param user
     * @throws SQLException
     * @throws IOException
     */
    public void addUser(User user) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_INTO_USERS);

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setBoolean(5, user.isAdmin());
            pstmt.setBoolean(6, user.isActive());
            int count = pstmt.executeUpdate();
            if (count != 1)
                throw new SQLException("Insert updated " + count + " rows");
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
                LOGGER.error("Error connection", e);
            }
            LOGGER.error("Error add users", e);
        }
    }

    /**
     * Gets user parameters
     *
     * @param login
     * @param password
     * @return user
     * @throws DaoException
     */
    public User getUserByLoginPassword(String login, String password) throws DaoException {
        User user = null;
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(GET_USER_BY_LOGIN_PASSWORD);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(ID));
                user.setFirstName(resultSet.getString(FIRST_NAME_TABLE));
                user.setLastName(resultSet.getString(LAST_NAME_TABLE));
                user.setEmail(resultSet.getString(EMAIL));
                user.setPassword(resultSet.getString(PASSWORD));
                user.setAdmin(resultSet.getBoolean(ADMIN));
                user.setActive(resultSet.getBoolean(ACTIVE));
            }
            resultSet.close();
            preparedStatement.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error connection", e);
        }
        return user;
    }

    /**
     * Verify email
     *
     * @param email
     * @return isExist
     * @throws DaoException
     */
    public boolean isEmailExist(String email) throws DaoException {
        boolean isExist = false;
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(CHECK_LOGIN);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                isExist = true;
            }
            resultSet.close();
            preparedStatement.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error connection", e);
        }
        return isExist;
    }

    /**
     * Gets list of Users
     *
     * @return users
     * @throws DaoException
     */
    public List<User> getUsers() throws DaoException {
        List<User> users = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(GET_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(ID));
                user.setFirstName(resultSet.getString(FIRST_NAME_TABLE));
                user.setLastName(resultSet.getString(LAST_NAME_TABLE));
                user.setEmail(resultSet.getString(EMAIL));
                user.setPassword(resultSet.getString(PASSWORD));
                user.setAdmin(resultSet.getBoolean(ADMIN));
                user.setActive(resultSet.getBoolean(ACTIVE));
                users.add(user);
            }
            resultSet.close();
            preparedStatement.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error connection", e);
        }
        return users;
    }

    /**
     * Method makes User active
     *
     * @param userId
     * @param isActive
     * @throws DaoException
     */
    public void ActivateUser(long userId, boolean isActive) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(UPDATE_USER_ACTIVITY);
            preparedStatement.setBoolean(1, isActive);
            preparedStatement.setLong(2, userId);
            int count = preparedStatement.executeUpdate();
            if (count != 1)
                throw new SQLException("Updated " + count + " rows");
            preparedStatement.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error connection", e);
        }
    }
}