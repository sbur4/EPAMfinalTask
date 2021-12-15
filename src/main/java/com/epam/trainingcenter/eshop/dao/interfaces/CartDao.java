package com.epam.trainingcenter.eshop.dao.interfaces;

import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Cart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sburch
 * @version 1.0
 * interface to handle the database operation required to manipulate Cart entity
 */

public interface CartDao {
    /**
     * Interface to adds product to cart
     *
     * @param cart
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    void addProductToCart(Cart cart) throws SQLException, IOException, DaoException;

    /**
     * Interface to gets products in cart
     *
     * @param userId
     * @return productsIds
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    List<Long> getProductsInCart(long userId) throws SQLException, IOException, DaoException;

    /**
     * Interface to deletes product in cart
     *
     * @param productId
     * @param userId
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    void DeleteProductInCart(long productId, long userId) throws SQLException, IOException, DaoException;

    /**
     * Interface to gets cart
     *
     * @param cart
     * @return newCart
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    Cart getCart(Cart cart) throws SQLException, IOException, DaoException;

    /**
     * Interface to gets all from cart
     *
     * @param productId
     * @return productId
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    List<Cart> getAllFromCart(long productId) throws SQLException, IOException, DaoException;

    /**
     * Interface to deletes product from cart by user id
     *
     * @param userId
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    void deleteProductFromCartByUserId(long userId) throws SQLException, IOException, DaoException;

//    задача на защите
//    int getAllInCart() throws DaoException;
}
