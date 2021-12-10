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
    void addProductToCart(Cart cart) throws SQLException, IOException, DaoException;

    List<Long> getProductsInCart(long userId) throws SQLException, IOException, DaoException;

    void DeleteProductInCart(long productId, long userId) throws SQLException, IOException, DaoException;

    Cart getCart(Cart cart) throws SQLException, IOException, DaoException;

    List<Cart> getAllFromCart(long productId) throws SQLException, IOException, DaoException;

    void deleteProductFromCartByUserId(long userId) throws SQLException, IOException, DaoException;
}
