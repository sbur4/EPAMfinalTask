package com.epam.trainingcenter.eshop.validator;

import org.junit.jupiter.api.*;

class ValidateRegistrationTest {
    private static ValidateRegistration validator = new ValidateRegistration();
    private static final String CORRECT_MAIL = "epam@gmail.com";
    private static final String INCORRECT_MAIL = "a@b";
    private static final String CORRECT_PASS = "11qwery";
    private static final String INCORRECT_PASS = "?";
    private static final String CORRECT_FIRSTNAME = "EPAM";
    private static final String INCORRECT_FIRSTNAME = "12345";
    private static final String CORRECT_LASTNAME = "EPAM";
    private static final String INCORRECT_LASTNAME = "12345";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Validate registration test start");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Validate registration test end");
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
    void validateMailWithRegex() {
        boolean mail1 = validator.validateMailWithRegex(CORRECT_MAIL);
        boolean mail2 = validator.validateMailWithRegex(INCORRECT_MAIL);
        Assertions.assertTrue(mail1);
        Assertions.assertFalse(mail2);
    }

    @Test
    void validatePasswordWithRegex() {
        boolean pass1 = validator.validatePasswordWithRegex(CORRECT_PASS);
        boolean pass2 = validator.validatePasswordWithRegex(INCORRECT_PASS);
        Assertions.assertTrue(pass1);
        Assertions.assertFalse(pass2);
    }

    @Test
    void validateFirstNameWithRegex() {
        boolean fname1 = validator.validateFirstNameWithRegex(CORRECT_FIRSTNAME);
        boolean fname2 = validator.validateFirstNameWithRegex(INCORRECT_FIRSTNAME);
        Assertions.assertTrue(fname1);
        Assertions.assertFalse(fname2);
    }

    @Test
    void validateLastNameWithRegex() {
        boolean lname1 = validator.validateLastNameWithRegex(CORRECT_LASTNAME);
        boolean lname2 = validator.validateLastNameWithRegex(INCORRECT_LASTNAME);
        Assertions.assertTrue(lname1);
        Assertions.assertFalse(lname2);
    }
}