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
     * @param message The message of the exception
     */
    public ConnectionException(String message) {
        super(message);
    }

    /**
     * @param message The message of the exception
     * @param cause   The message of the cause
     */
    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause The message of the cause
     */
    public ConnectionException(Throwable cause) {
        super(cause);
    }
}
