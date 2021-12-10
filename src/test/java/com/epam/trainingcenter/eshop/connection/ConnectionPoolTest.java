package com.epam.trainingcenter.eshop.connection;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConnectionPoolTest {

    @Test
    void test() throws SQLException, IOException {
        assertTrue(ConnectionPool.getConnection().isValid(5));
    }
}