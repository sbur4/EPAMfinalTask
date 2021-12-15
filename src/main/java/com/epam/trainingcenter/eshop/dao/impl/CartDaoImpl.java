package com.epam.trainingcenter.eshop.dao.impl;

import com.epam.trainingcenter.eshop.connection.ConnectionPool;
import com.epam.trainingcenter.eshop.dao.interfaces.CartDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Cart;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * @version 1.0
 */

public class CartDaoImpl extends ConnectionPool implements CartDao {
    private Logger LOGGER = LoggerFactory.getLogger(CartDaoImpl.class);

    private static final String INSERT_PRODUCT_INTO_CART = "INSERT cart(product_id, user_id) VALUES(?, ?)";
    private static final String GET_PRODUCTS_FROM_CART_BY_USER_ID = "SELECT * FROM cart WHERE user_id = ?";
    private static final String GET_CART_ID_FROM_CART = "SELECT id FROM cart WHERE product_id = ? AND user_id = ?";
    private static final String GET_ALL_FROM_CART = "SELECT * FROM cart WHERE product_id = ?";
    private static final String DELETE_PRODUCTS_FROM_CART_BY_USER = "DELETE FROM eshop.cart WHERE user_id=?";

    //This request delete all equals products
//    private static final String DELETE_PRODUCT_FROM_CART = "DELETE FROM cart WHERE product_id = ? AND user_id = ?";
    //This request delete only 1 product if we have equals products
    private static final String DELETE_PRODUCT_FROM_CART = "DELETE FROM cart WHERE product_id = ? AND user_id = ? LIMIT 1";

    private static final String COUNT_PRODUCTS_IN_CART = "SELECT COUNT(product_id) AS count FROM cart";

    /**
     * Add product to cart
     *
     * @param cart
     * @throws DaoException
     */
    public void addProductToCart(Cart cart) throws SQLException, IOException, DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_PRODUCT_INTO_CART);
            pstmt.setLong(1, cart.getProductId());
            pstmt.setLong(2, cart.getUserId());
            int count = pstmt.executeUpdate();
            if (count != 0)
                throw new SQLException("Insert updated " + count + " rows");
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error adding products to cart", e);
        }
    }

    /**
     * Get products in cart
     *
     * @param userId
     * @return productsIds
     * @throws DaoException
     */
    public List<Long> getProductsInCart(long userId) throws DaoException {
        Connection con = null;
        List<Long> productsIds = null;
        try {
            productsIds = new ArrayList<>();
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(GET_PRODUCTS_FROM_CART_BY_USER_ID);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long productId = resultSet.getLong(PRODUCT_ID_TABLE);
                productsIds.add(productId);
            }
            resultSet.close();
            preparedStatement.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error getting products from cart", e);
        }
        return productsIds;
    }

    /**
     * Delete product in cart
     *
     * @param productId
     * @param userId
     * @throws DaoException
     */
    public void DeleteProductInCart(long productId, long userId) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(DELETE_PRODUCT_FROM_CART);
            preparedStatement.setLong(1, productId);
            preparedStatement.setLong(2, userId);
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error deleting products from cart", e);
        }
    }

    /**
     * Get cart
     *
     * @param cart
     * @return newCart
     * @throws DaoException
     */
    public Cart getCart(Cart cart) throws DaoException {
        Connection con = null;
        Cart newCart = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(GET_CART_ID_FROM_CART);
            preparedStatement.setLong(1, cart.getProductId());
            preparedStatement.setLong(2, cart.getUserId());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                newCart.setId(rs.getLong(ID));
            }
            preparedStatement.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error getting cart", e);
        }
        return newCart;
    }

    /**
     * Get all products from cart
     *
     * @param productId
     * @return carts
     * @throws DaoException
     */
    public List<Cart> getAllFromCart(long productId) throws DaoException {
        List<Cart> carts = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(GET_ALL_FROM_CART);
            pstmt.setLong(1, productId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getLong(ID));
                cart.setProductId(rs.getLong(PRODUCT_ID_TABLE));
                cart.setUserId(rs.getLong(USER_ID_TABLE));
                carts.add(cart);
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error get all products from cart", e);
        }
        return carts;
    }

    /**
     * Delete product from cart by user id
     *
     * @param userId
     * @throws DaoException
     */
    @Override
    public void deleteProductFromCartByUserId(long userId) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(DELETE_PRODUCTS_FROM_CART_BY_USER);
            preparedStatement.setLong(1, userId);
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.warn("INFO?", e);
        }
    }

    //    задача на защите
//    @Override
//    public int getAllInCart() throws DaoException {
//        Connection con = null;
//        int countProducts = 0;
//        try {
//            con = getConnection();
//            PreparedStatement preparedStatement = con.prepareStatement(COUNT_PRODUCTS_IN_CART);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                countProducts = (int) rs.getLong("count");
//            }
//            preparedStatement.close();
//            releaseConnection(con);
//        } catch (Exception e) {
//            try {
//                if (con != null)
//                    con.close();
//            } catch (SQLException e2) {
//            }
//            LOGGER.error("Error getting cart", e);
//        }
//        return countProducts;
//    }
}
