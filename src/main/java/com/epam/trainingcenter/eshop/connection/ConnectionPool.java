package com.epam.trainingcenter.eshop.connection;

import com.epam.trainingcenter.eshop.exeption.ConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author sburch
 * @version 1.0
 * Connection to database
 */

public class ConnectionPool {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPool.class);
    private static final String DB_CONNECTION_PATH = "dbConnection.properties";

    private static List<Connection> connectionPool = new ArrayList<>();

//    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
//    private String jdbcURL = "jdbc:mysql://localhost:3306/eshop?serverTimezone=UTC";

    public static synchronized Connection getConnection() throws ConnectionException, IOException {
        Properties dbProperties = new Properties();
        dbProperties.load(ConnectionPool.class.getClassLoader().getResourceAsStream(DB_CONNECTION_PATH));

        if (connectionPool.size() > 0) {
            return connectionPool.remove(connectionPool.size() - 1);
        }

        try {
            Class.forName(dbProperties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            LOGGER.error("Can't find database driver");
            throw new ConnectionException(e);
        }

        try {
            return DriverManager.getConnection(dbProperties.getProperty("url"), dbProperties.getProperty("user"), dbProperties.getProperty("password"));
        } catch (SQLException e) {
            LOGGER.error("Can't connect to database");
            throw new ConnectionException(e);
        }
    }

    protected synchronized void releaseConnection(Connection con) {
        connectionPool.add(con);
    }
}