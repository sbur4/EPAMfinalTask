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
    /**
     * Interface to create order
     *
     * @param order
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    void createOrder(Order order) throws SQLException, IOException, DaoException;

    /**
     * Interface to takes last id
     *
     * @return lastId
     * @throws SQLException
     * @throws DaoException
     */
    Long takeLastID() throws SQLException, DaoException;

    /**
     * Interface to gets all orders
     *
     * @return orders
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    ArrayList<Order> getAllOrder() throws SQLException, IOException, DaoException;

    /**
     * Interface to gets info from different tables
     *
     * @return orders
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    ArrayList<ArrayList<String>> getFrom4Tables() throws SQLException, IOException, DaoException;

    /**
     * Interface to changes order status
     *
     * @param orderId
     * @param statusId
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    void changeOrderStatus(Long orderId, Long statusId) throws SQLException, IOException, DaoException;

    /**
     * Interface to gets order by user id
     *
     * @param userId
     * @return orders
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    ArrayList<ArrayList<String>> getOrderByUserId(Long userId) throws SQLException, IOException, DaoException;

    /**
     * Interface to deletes order by id
     *
     * @param orderId
     * @throws DaoException
     */
    void deleteOrderById(Long orderId) throws DaoException;

    /**
     * Interface to gets order by id
     *
     * @param orderId
     * @return order
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    Order getOrderById(Long orderId) throws SQLException, IOException, DaoException;
}
