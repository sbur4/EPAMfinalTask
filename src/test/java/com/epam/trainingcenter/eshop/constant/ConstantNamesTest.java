package com.epam.trainingcenter.eshop.constant;

import org.junit.jupiter.api.*;

class ConstantNamesTest {
    private static final String CORRECT_ID = "id";
    private static final String INCORRECT_ID = "ip";
    private static final String CORRECT_NAME = "price";
    private static final String INCORRECT_NAME = "brice";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Constant names test start");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Constant names test end");
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
    void testId() {
        Assertions.assertEquals(ConstantNames.ID, "id");
        Assertions.assertEquals(ConstantNames.LOGIN, "login");
        boolean id1 = ConstantNames.ID == CORRECT_ID;
        boolean id2 = ConstantNames.ID == INCORRECT_ID;
        Assertions.assertTrue(id1);
        Assertions.assertFalse(id2);
    }

    @Test
    void testProducts() {
        Assertions.assertEquals(ConstantNames.PRODUCTS, "products");
        boolean pro1 = ConstantNames.PRICE == CORRECT_NAME;
        boolean pro2 = ConstantNames.PRICE == INCORRECT_NAME;
        Assertions.assertTrue(pro1);
        Assertions.assertFalse(pro2);
    }
}