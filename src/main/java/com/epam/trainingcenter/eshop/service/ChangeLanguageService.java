package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.constant.ConstantPageNames;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * @version 1.0
 * Service witch change language in the pages
 */

public class ChangeLanguageService implements Service {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        String language = request.getParameter(LANGUAGE);
        session.setAttribute(LANGUAGE, language);
        response.sendRedirect(ConstantPageNames.HOME_SERVICE);
    }
}
