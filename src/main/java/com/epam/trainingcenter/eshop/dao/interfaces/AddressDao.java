package com.epam.trainingcenter.eshop.dao.interfaces;

import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Address;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author sburch
 * @version 1.0
 * interface to handle the database operation required to manipulate Address entity
 */

public interface AddressDao {
    void createAddress(Address address) throws SQLException, IOException, DaoException;

    Long takeLastID() throws SQLException, DaoException;

    void deleteAddressById(Long addressId) throws SQLException, IOException, DaoException;
}
