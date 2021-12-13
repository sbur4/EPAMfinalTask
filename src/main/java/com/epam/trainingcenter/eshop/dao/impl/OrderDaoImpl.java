package com.epam.trainingcenter.eshop.dao.impl;

import com.epam.trainingcenter.eshop.connection.ConnectionPool;
import com.epam.trainingcenter.eshop.dao.interfaces.OrderDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * @version 1.0
 */

public class OrderDaoImpl extends ConnectionPool implements OrderDao {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    private static final String SELECT_LAST_ID_FROM_ORDER = "SELECT MAX(id) FROM eshop.order";
    private static final String INSERT_INTO_ORDER = "INSERT eshop.order(date_time, status, delivery_address, id) VALUES(?,?,?,?)";
    private static final String SELECT_ALL_FROM_ORDER = "SELECT * FROM eshop.order";
    private static final String SELECT_FROM_4_TABLES = "SELECT eshop.order.id order_id, eshop.order.date_time, eshop.user.email user_email, eshop.ordering_status.status_name\n" +
            "FROM eshop.order \n" +
            "INNER JOIN eshop.ordering_status ON eshop.order.status=eshop.ordering_status.id\n" +
            "INNER JOIN eshop.order_item ON eshop.order.id = eshop.order_item.order_id\n" +
            "INNER JOIN eshop.user ON eshop.user.id = eshop.order_item.user_id\n" +
            "GROUP BY eshop.order.id";
    private static final String UPDATE_STATUS_ORDER = "UPDATE eshop.order SET  status = ? WHERE id = ?";
    private static final String SELECT_ORDERS_BY_USER_ID = "SELECT eshop.order.id order_id, eshop.order.date_time, eshop.ordering_status.status_name\n" +
            "FROM eshop.order \n" +
            "INNER JOIN eshop.ordering_status ON eshop.order.status=eshop.ordering_status.id\n" +
            "INNER JOIN eshop.order_item ON eshop.order.id = eshop.order_item.order_id\n" +
            "INNER JOIN eshop.user ON eshop.user.id = eshop.order_item.user_id \n" +
            "WHERE eshop.user.id= ?\n" +
            "GROUP BY eshop.order.id ";
    private static final String DELETE_ORDER_BY_ID = "DELETE FROM eshop.order WHERE id = ?";
    private static final String SELECT_ORDER_BY_ID = "SELECT * FROM eshop.order WHERE id = ?";
    private Exception e;

    /**
     * Create order
     *
     * @param order
     * @throws DaoException
     */
    @Override
    public void createOrder(Order order) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_INTO_ORDER);
            pstmt.setTimestamp(1, order.getDateTime());
            pstmt.setLong(2, order.getStatusId());
            pstmt.setLong(3, order.getDeliveryAddressId());
            pstmt.setLong(4, order.getId());
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
            System.out.println(e);
        }
    }

    /**
     * Get last id
     *
     * @return lastId
     * @throws DaoException
     */
    @Override
    public Long takeLastID() throws DaoException {
        long lastId = 0;
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_LAST_ID_FROM_ORDER);
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
            LOGGER.error("Error connection", e);
        }
        return lastId;
    }

    /**
     * Get all order
     *
     * @return orders
     * @throws DaoException
     */
    @Override
    public ArrayList<Order> getAllOrder() throws DaoException {
        ArrayList<Order> orders = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_ALL_FROM_ORDER);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong(ID));
                order.setDateTime(rs.getTimestamp(DATE_TIME));
                order.setStatusId(rs.getLong(STATUS));
                order.setDeliveryAddressId(rs.getLong(DELIVERY_ADDRESS));
                orders.add(order);
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error connection", e);
        }
        return orders;
    }

    /**
     * Get orders list
     *
     * @return orders
     * @throws DaoException
     */
    @Override
    public ArrayList<ArrayList<String>> getFrom4Tables() throws DaoException {
        ArrayList<ArrayList<String>> orders = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_FROM_4_TABLES);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ArrayList<String> order = new ArrayList<>();
                order.add(String.valueOf(rs.getLong(ORDER_ID_TABLE)));
                order.add(String.valueOf(rs.getTimestamp(DATE_TIME)));
                order.add(rs.getString(USER_EMAIL));
                order.add(rs.getString(STATUS_NAME));
                orders.add(order);
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error connection", e);
        }
        return orders;
    }

    /**
     * Change order status
     *
     * @param orderId
     * @param statusId
     * @throws DaoException
     */
    @Override
    public void changeOrderStatus(Long orderId, Long statusId) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(UPDATE_STATUS_ORDER);

            pstmt.setLong(1, statusId);
            pstmt.setLong(2, orderId);

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
                LOGGER.error("Error connection", e);
            }
            LOGGER.error("Error change order status", e);
        }
    }

    /**
     * Get order by user id
     *
     * @param userId
     * @return orders
     * @throws DaoException
     */
    @Override
    public ArrayList<ArrayList<String>> getOrderByUserId(Long userId) throws DaoException {
        ArrayList<ArrayList<String>> orders = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_ORDERS_BY_USER_ID);
            pstmt.setLong(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ArrayList<String> order = new ArrayList<>();
                order.add(String.valueOf(rs.getLong(ORDER_ID_TABLE)));
                order.add(String.valueOf(rs.getTimestamp(DATE_TIME)));
                order.add(rs.getString(STATUS_NAME));
                orders.add(order);
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
                LOGGER.error("Error connection", e);
            }
            LOGGER.error("Error get order by user id", e);
        }
        return orders;
    }

    /**
     * Delete oder by id
     *
     * @param orderId
     * @throws DaoException
     */
    @Override
    public void deleteOrderById(Long orderId) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(DELETE_ORDER_BY_ID);
            pstmt.setLong(1, orderId);

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
                LOGGER.error("Error connection", e);
            }
            LOGGER.error("Error delete oder by id", e);
        }
    }

    /**
     * Get order by id
     *
     * @param orderId
     * @return orderId
     * @throws DaoException
     */
    @Override
    public Order getOrderById(Long orderId) throws DaoException {
        Order order = new Order();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_ORDER_BY_ID);
            pstmt.setLong(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                order.setId(rs.getLong(ID));
                order.setDateTime(rs.getTimestamp(DATE_TIME));
                order.setDeliveryAddressId(rs.getLong(DELIVERY_ADDRESS));
                order.setStatusId(rs.getLong(STATUS));
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
                LOGGER.error("Error connection", e);
            }
            LOGGER.error("Error order by id", e);
        }
        return order;
    }
}
