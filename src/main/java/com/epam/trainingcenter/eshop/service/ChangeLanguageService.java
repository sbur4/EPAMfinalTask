package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.constant.ConstantPageNames;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.LANGUAGE;

/**
 * @author sburch
 * @version 1.0
 */

public class ChangeLanguageService implements Service {

    /**
     * Servlet changes language on page
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
        String language = request.getParameter(LANGUAGE);
        session.setAttribute(LANGUAGE, language);
        response.sendRedirect(ConstantPageNames.HOME_SERVICE);
    }
}
