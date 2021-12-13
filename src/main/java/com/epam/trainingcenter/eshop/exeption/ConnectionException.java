package com.epam.trainingcenter.eshop.exeption;

import java.sql.SQLException;

/**
 * @author sburch
 * @version 1.0
 * Create Connection Exception to try catch exceptions
 */

public class ConnectionException extends SQLException {

    /**
     * Default constructor for class Connection Exception
     */
    public ConnectionException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message
     *
     * @param message
     */
    public ConnectionException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause
     *
     * @param message
     * @param cause
     */
    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause)
     *
     * @param cause
     */
    public ConnectionException(Throwable cause) {
        super(cause);
    }
}
