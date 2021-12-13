package com.epam.trainingcenter.eshop.exeption;

/**
 * @author sburch
 * @version 1.0
 * Create Service Exception to try catch exceptions
 */

public class ServiceException extends Exception {

    /**
     * Default constructor for class Service Exception
     */
    public ServiceException() {
    }

    /**
     * Constructs a new exception with the specified detail message
     *
     * @param message
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause
     *
     * @param message
     * @param cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
