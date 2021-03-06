package com.epam.trainingcenter.eshop.controller;

import com.epam.trainingcenter.eshop.service.Service;
import com.epam.trainingcenter.eshop.service.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sburch
 * @version 1.0
 * Main servlet
 */

public class Controller extends HttpServlet {
    private final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    /**
     * Method post for request and  response
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Method get for request and  response
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Service service = serviceFactory.getService(path);
        try {
            service.execute(request, response);
        } catch (Exception e) {
            LOGGER.error("Error execute request, response", e);
        }
    }
}
