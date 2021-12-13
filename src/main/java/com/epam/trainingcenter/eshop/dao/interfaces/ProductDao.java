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
    /**
     * Interface to gets all products
     *
     * @return products
     * @throws DaoException
     */
    List<Product> getAllProduct() throws DaoException;

    /**
     * Interface to gets product by id
     *
     * @param id
     * @return product
     * @throws DaoException
     */
    Product getProductById(Long id) throws DaoException;

    /**
     * Interface to creates product
     *
     * @param product
     * @throws DaoException
     */
    void createProduct(Product product) throws DaoException;

    /**
     * Interface to updates product
     *
     * @param product
     * @throws DaoException
     */
    void updateProduct(Product product) throws DaoException;

    /**
     * Interface to gets searched products
     *
     * @param productName
     * @return products
     * @throws DaoException
     */
    List<Product> getSearchedProducts(String productName) throws DaoException;

    /**
     * Interface to deletes product
     *
     * @param productId
     * @throws SQLException
     * @throws IOException
     * @throws DaoException
     */
    void deleteProduct(long productId) throws SQLException, IOException, DaoException;

    //pagination and sorting

    /**
     * Interface to finds products
     *
     * @param limit
     * @param offset
     * @return products
     * @throws DaoException
     */
    List<Product> findProductsForPagination(int limit, int offset) throws DaoException;

    /**
     * Interface to gets products size for pagination
     *
     * @return size
     * @throws DaoException
     */
    int getProductsSizeForPagination() throws DaoException;

    /**
     * Interface to finds products
     *
     * @param limit
     * @param offset
     * @param sortBy
     * @return products
     * @throws DaoException
     */
    List<Product> findProductsForPaginationAndSort(int limit, int offset, String sortBy) throws DaoException;

    /**
     * Interface to gets products size for pagination and sort
     *
     * @param sortBy
     * @return size
     * @throws DaoException
     */
    int getProductsSizeForPaginationAndSort(String sortBy) throws DaoException;
}
