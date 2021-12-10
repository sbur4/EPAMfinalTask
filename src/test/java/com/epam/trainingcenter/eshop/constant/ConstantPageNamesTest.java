package com.epam.trainingcenter.eshop.constant;


import org.junit.jupiter.api.*;

class ConstantPageNamesTest {
    private static final String CORRECT_SERVICE_NAME = "home";
    private static final String INCORRECT_SERVICE_NAME = "hope";
    private static final String CORRECT_NAME = "cart.jsp";
    private static final String INCORRECT_NAME = "mart.jsp";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Constant page names test start");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Constant page names test end");
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
    void testLoginService() {
        Assertions.assertEquals(ConstantPageNames.LOGIN_SERVICE, "login");
        boolean serv1 = ConstantPageNames.HOME_SERVICE == CORRECT_SERVICE_NAME;
        boolean serv2 = ConstantPageNames.HOME_SERVICE == INCORRECT_SERVICE_NAME;
        Assertions.assertTrue(serv1);
        Assertions.assertFalse(serv2);
    }

    @Test
    void testHomeJsp() {
        Assertions.assertEquals(ConstantPageNames.HOME_JSP, "home.jsp");
        boolean page1 = ConstantPageNames.CART_JSP == CORRECT_NAME;
        boolean page2 = ConstantPageNames.CART_JSP == INCORRECT_NAME;
        Assertions.assertTrue(page1);
        Assertions.assertFalse(page2);
    }
}