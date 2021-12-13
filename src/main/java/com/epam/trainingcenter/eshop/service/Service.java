package com.epam.trainingcenter.eshop.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sburch
 * @version 1.0
 * interface has execute method witch do get and post  request and response
 */

public interface Service {

    /**
     * Interface for request and response
     *
     * @param request
     * @param response
     * @throws Exception
     */
    void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
