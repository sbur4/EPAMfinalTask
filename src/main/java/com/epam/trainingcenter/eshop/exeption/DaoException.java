package com.epam.trainingcenter.eshop.exeption;

import java.sql.SQLException;

/**
 * @author sburch
 * @version 1.0
 * Create DAO Exception to try catch exceptions
 */

public class DaoException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor for class Dao Exception
     */
    public DaoException() {
    }

    /**
     * @param message The message of the exception
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * @param message The message of the exception
     * @param cause   The message of the cause
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
