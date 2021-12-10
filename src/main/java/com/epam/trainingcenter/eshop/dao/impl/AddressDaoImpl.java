package com.epam.trainingcenter.eshop.dao.impl;

import com.epam.trainingcenter.eshop.connection.ConnectionPool;
import com.epam.trainingcenter.eshop.dao.interfaces.AddressDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Address;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author sburch
 * @version 1.0
 */

public class AddressDaoImpl extends ConnectionPool implements AddressDao {
    private final Logger LOGGER = LoggerFactory.getLogger(AddressDaoImpl.class);

    private static final String INSERT_ADDRESS = "INSERT address(id, country, city, street, phone) VALUES(?,?,?,?,?)";
    private static final String SELECT_LAST_ID_FROM_ADDRESS = "SELECT MAX(id) FROM address";
    private static final String DELETE_ADDRESS_BY_ID = "DELETE FROM eshop.address WHERE id = ?";

    /**
     * Create address
     *
     * @param address
     * @throws DaoException
     */
    @Override
    public void createAddress(Address address) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_ADDRESS);
            pstmt.setLong(1, address.getId());
            pstmt.setString(2, address.getCountry());
            pstmt.setString(3, address.getCity());
            pstmt.setString(4, address.getStreet());
            pstmt.setString(5, address.getPhone());
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
            }
            LOGGER.error("Error create address", e);
        }
    }

    /**
     * @return last id
     * @throws DaoException
     */
    @Override
    public Long takeLastID() throws DaoException {
        long lastId = 0;
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_LAST_ID_FROM_ADDRESS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lastId = rs.getLong("MAX(ID)");
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error get last address", e);
        }
        return lastId;
    }


    /**
     * Delete address by id
     *
     * @param addressId
     * @throws DaoException
     */
    @Override
    public void deleteAddressById(Long addressId) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(DELETE_ADDRESS_BY_ID);
            pstmt.setLong(1, addressId);
            int count = pstmt.executeUpdate();
            if (count != 1)
                throw new SQLException("deleted " + count + " rows");
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            System.out.println(e + "address");
        }
    }
}
