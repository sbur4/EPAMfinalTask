package com.epam.trainingcenter.eshop.dao.impl;

import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductDaoImplTest {
    ProductDaoImpl productDao = new ProductDaoImpl();

    @Test
    void getAllProductTest() throws DaoException {
        List<Product> products = productDao.getAllProduct();
        assertEquals(37, products.size());
    }
}