package com.epam.trainingcenter.eshop.dao.interfaces;

import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Status;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sburch
 * @version 1.0
 * interface to handle the database operation required to manipulate Status entity
 */

public interface StatusDao {
    /**
     * Interface to gets id by status name
     *
     * @param statusName
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    Long getIdByStatusName(String statusName) throws SQLException, IOException, DaoException;

    /**
     * Interface to gets all statuses
     *
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    List<Status> getAllStatuses() throws SQLException, IOException, DaoException;

    /**
     * Interface to gets status by order id
     *
     * @param orderId
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    Status getStatusByOrderId(Long orderId) throws SQLException, IOException, DaoException;
}
