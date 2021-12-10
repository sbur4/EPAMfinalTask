package com.epam.trainingcenter.eshop.model;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ProductMockTest {
    Product product = mock(Product.class);

    @Test
    public static void mockSetProduct(Product product, ResultSet resultSet) throws SQLException {
        Mockito.when(resultSet.getLong("id")).thenReturn(product.getId());
        Mockito.when(resultSet.getString("name")).thenReturn(product.getName());
        Mockito.when(resultSet.getString("description")).thenReturn(product.getDescription());
        Mockito.when(resultSet.getDouble("price")).thenReturn(product.getPrice());
        Mockito.when(resultSet.getString("image_url")).thenReturn(product.getImage_url());
    }

    @Test
    public static void assertEqualsProducts(Product expected, Product actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getPrice(), actual.getPrice());
        assertEquals(expected.getImage_url(), actual.getImage_url());
    }
}
