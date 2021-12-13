package com.epam.trainingcenter.eshop.dao.impl;

import com.epam.trainingcenter.eshop.connection.ConnectionPool;
import com.epam.trainingcenter.eshop.dao.interfaces.OrderItemDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.PRODUCT_ID_TABLE;

/**
 * @author sburch
 * @version 1.0
 */

public class OrderItemDaoImpl extends ConnectionPool implements OrderItemDao {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    private static final String INSERT_INTO_ORDER_ITEM = "INSERT order_item(product_id, user_id, order_id, id) VALUES(?,?,?,?)";
    private static final String SELECT_PRODUCT_ID = "SELECT product_id FROM eshop.order_item WHERE order_id = ?";
    private static final String DELETE_ORDER_ITEMS = "DELETE FROM eshop.order_item WHERE order_id = ?";

    /**
     * Create order item
     *
     * @param orderItem
     * @throws DaoException
     */
    @Override
    public void createOrderItem(OrderItem orderItem) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_INTO_ORDER_ITEM);
            pstmt.setLong(1, orderItem.getProductId());
            pstmt.setLong(2, orderItem.getUserId());
            pstmt.setLong(3, orderItem.getOrderId());
            pstmt.setLong(4, orderItem.getId());
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
            LOGGER.error("Error create order item", e);
        }
    }

    /**
     * Get products id from order item
     *
     * @param orderId
     * @return productsId
     * @throws DaoException
     */
    @Override
    public ArrayList<Long> getProductsIdFromOrderItem(Long orderId) throws DaoException {
        ArrayList<Long> productsId = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_PRODUCT_ID);
            pstmt.setLong(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                productsId.add(rs.getLong(PRODUCT_ID_TABLE));
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
            LOGGER.error("Error get products id from order item", e);
        }
        return productsId;
    }

    /**
     * Delete order items by order id
     *
     * @param orderId
     * @throws DaoException
     */
    @Override
    public void deleteOrderItemsByOrderId(Long orderId) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(DELETE_ORDER_ITEMS);
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
            LOGGER.error("Error delete order items by order id", e);
        }
    }
}
