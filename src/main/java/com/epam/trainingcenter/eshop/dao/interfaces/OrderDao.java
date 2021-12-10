package com.epam.trainingcenter.eshop.dao.interfaces;

import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Order;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author sburch
 * @version 1.0
 * interface to handle the database operation required to manipulate Order entity
 */

public interface OrderDao {
    void createOrder(Order order) throws SQLException, IOException, DaoException;

    Long takeLastID() throws SQLException, DaoException;

    ArrayList<Order> getAllOrder() throws SQLException, IOException, DaoException;

    ArrayList<ArrayList<String>> getFrom4Tables() throws SQLException, IOException, DaoException;

    void changeOrderStatus(Long orderId, Long statusId) throws SQLException, IOException, DaoException;

    ArrayList<ArrayList<String>> getOrderByUserId(Long userId) throws SQLException, IOException, DaoException;

    void deleteOrderById(Long orderId) throws DaoException;

    Order getOrderById(Long orderId) throws SQLException, IOException, DaoException;
}
