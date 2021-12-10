package com.epam.trainingcenter.eshop.validator;

import org.junit.jupiter.api.*;

class ValidateCreateNewProductTest {
    private static ValidateCreateNewProduct validator = new ValidateCreateNewProduct();
    private static final String CORRECT_NAME = "EPAM";
    private static final String INCORRECT_NAME = "12345";
    private static final String CORRECT_DESCRIPTION = "Coco-Cola 5 L";
    private static final String INCORRECT_DESCRIPTION = "";
    private static final String CORRECT_PRICE = "33.44";
    private static final String INCORRECT_PRICE = "0.0";
    private static final String CORRECT_IMAGE_URL = "image.jpeg";
    private static final String INCORRECT_IMAGE_URL = "abc.tif";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Validate create new product test start");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Validate create new product test end");
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
    void validateNameWithRegex() {
        boolean name1 = validator.validateNameWithRegex(CORRECT_NAME);
        boolean name2 = validator.validateNameWithRegex(INCORRECT_NAME);
        Assertions.assertTrue(name1);
        Assertions.assertFalse(name2);
    }

    @Test
    void validateDescriptionWithRegex() {
        boolean descroption1 = validator.validateDescriptionWithRegex(CORRECT_DESCRIPTION);
        boolean descroption2 = validator.validateDescriptionWithRegex(INCORRECT_DESCRIPTION);
        Assertions.assertTrue(descroption1);
        Assertions.assertFalse(descroption2);
    }

    @Test
    void validatePriceWithRegex() {
        boolean price1 = validator.validatePriceWithRegex(CORRECT_PRICE);
        boolean price2 = validator.validatePriceWithRegex(INCORRECT_PRICE);
        Assertions.assertTrue(price1);
        Assertions.assertFalse(price2);
    }

    @Test
    void validateImageUrlWithRegex() {
        boolean image1 = validator.validateImageUrlWithRegex(CORRECT_IMAGE_URL);
        boolean image2 = validator.validateImageUrlWithRegex(INCORRECT_IMAGE_URL);
        Assertions.assertTrue(image1);
        Assertions.assertFalse(image2);
    }
}