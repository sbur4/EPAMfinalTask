package com.epam.trainingcenter.eshop.dao.interfaces;

import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author sburch
 * @version 1.0
 * interface to handle the database operation required to manipulate Product entity
 */

public interface ProductDao {
    List<Product> getAllProduct() throws DaoException;

    Product getProductById(Long id) throws DaoException;

    void createProduct(Product product) throws DaoException;

    void updateProduct(Product product) throws DaoException;

    List<Product> getSearchedProducts(String productName) throws DaoException;

    void deleteProduct(long productId) throws SQLException, IOException, DaoException;

    //pagination and sorting

    List<Product> findProductsForPagination(int limit, int offset) throws DaoException;

    int getProductsSizeForPagination() throws DaoException;

    List<Product> findProductsForPaginationAndSort(int limit, int offset, String sortBy) throws DaoException;

    int getProductsSizeForPaginationAndSort(String sortBy) throws DaoException;
}
