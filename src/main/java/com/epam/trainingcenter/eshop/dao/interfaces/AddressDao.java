package com.epam.trainingcenter.eshop.dao.interfaces;

import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Address;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author sburch
 * @version 1.0
 * Interface to handle the database operation required to manipulate Address entity
 */

public interface AddressDao {
    /**
     * Interface to creates address
     *
     * @param address
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    void createAddress(Address address) throws SQLException, IOException, DaoException;

    /**
     * Interface to returns last id
     *
     * @return id
     * @throws SQLException
     * @throws DaoException
     */
    Long takeLastID() throws SQLException, DaoException;

    /**
     * Interface to deletes address by id
     *
     * @param addressId
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    void deleteAddressById(Long addressId) throws SQLException, IOException, DaoException;
}
