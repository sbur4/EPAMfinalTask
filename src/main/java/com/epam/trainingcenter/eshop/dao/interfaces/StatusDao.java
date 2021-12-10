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
    Long getIdByStatusName(String statusName) throws SQLException, IOException, DaoException;

    List<Status> getAllStatuses() throws SQLException, IOException, DaoException;

    Status getStatusByOrderId(Long orderId) throws SQLException, IOException, DaoException;
}
