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
     * @param message The message of the exception
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * @param message The message of the exception
     * @param cause   The message of the cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
