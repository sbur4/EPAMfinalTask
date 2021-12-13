package com.epam.trainingcenter.eshop.exeption;

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
     * Constructs a new exception with the specified detail message
     *
     * @param message
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause
     *
     * @param message
     * @param cause
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
