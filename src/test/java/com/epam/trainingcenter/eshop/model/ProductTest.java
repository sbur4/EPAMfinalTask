package com.epam.trainingcenter.eshop.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Product entity test start");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Product entity test end");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Test start");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test end");
    }

    @Test
    void setIdTest() {
        Product product = new Product();
        product.setId(15);
        assertTrue(product.getId() == 15);
        assertFalse(product.getId() == 10);
    }

    @Test
    void setNameTest() {
        Product product = new Product();
        product.setName("Cola");
        assertTrue(product.getName().equalsIgnoreCase("Cola"));
        assertFalse(product.getName().equalsIgnoreCase("Fanta"));
    }

    @Test
    void setDescriptionTest() {
        Product product = new Product();
        product.setDescription("Sugar free");
        assertTrue(product.getDescription().equalsIgnoreCase("sugar free"));
        assertFalse(product.getDescription().equalsIgnoreCase("alcohol free"));
    }

    @Test
    void setPriceTest() {
        Product product = new Product();
        product.setPrice(23.45);
        assertTrue(product.getPrice() == 23.45);
        assertFalse(product.getPrice() == 23.54);
    }
}