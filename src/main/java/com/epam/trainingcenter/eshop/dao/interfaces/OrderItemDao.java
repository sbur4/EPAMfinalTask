package com.epam.trainingcenter.eshop.dao.interfaces;

import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.OrderItem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author sburch
 * @version 1.0
 * interface to handle the database operation required to manipulate OrderItem entity
 */

public interface OrderItemDao {
    void createOrderItem(OrderItem orderItem) throws SQLException, IOException, DaoException;

    ArrayList<Long> getProductsIdFromOrderItem(Long orderId) throws SQLException, IOException, DaoException;

    void deleteOrderItemsByOrderId(Long orderId) throws SQLException, IOException, DaoException;
}