package com.epam.trainingcenter.eshop.validator;

/**
 * @author sburch
 * @version 1.0
 * This class validates input data's
 */

public class ValidateRegistration {

    //TODO show this at html
    private static final String MAIL_REGEX = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{1,6}$";
    private static final String PASSWORD_REGEX = "[a-zA-Z0-9~!@#$%^&*]{2,}";

    private static final String FIRSTNAME_REGEX = "^[a-zA-Z\\\\s]*$";
    private static final String LASTNAME_REGEX = "^[a-zA-Z\\\\s]*$";

    /**
     * Validate login when input one
     *
     * @param login
     * @return login
     */
    public static boolean validateMailWithRegex(String login) {
        return login.matches(MAIL_REGEX);
    }

    /**
     * Validate password when input one
     *
     * @param password
     * @return password
     */
    public static boolean validatePasswordWithRegex(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    /**
     * Validate firstname when input one
     *
     * @param firstname
     * @return firstname
     */
    public static boolean validateFirstNameWithRegex(String firstname) {
        return firstname.matches(FIRSTNAME_REGEX);
    }

    /**
     * Validate lastname when input one
     *
     * @param lastname
     * @return lastname
     */
    public static boolean validateLastNameWithRegex(String lastname) {
        return lastname.matches(LASTNAME_REGEX);
    }
}
