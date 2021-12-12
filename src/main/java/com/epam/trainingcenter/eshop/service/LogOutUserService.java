package com.epam.trainingcenter.eshop.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.USER;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.LOGIN_JSP;

/**
 * @author sburch
 * @version 1.0
 */

public class LogOutUserService implements Service {

    /**
     * Servlet for log out
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws ParseException
     * @throws SQLException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        session.setAttribute(USER, null);
        response.sendRedirect(LOGIN_JSP);
    }
}
