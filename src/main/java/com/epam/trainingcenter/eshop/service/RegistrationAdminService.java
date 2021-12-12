package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.constant.ConstantNames;
import com.epam.trainingcenter.eshop.constant.ConstantPageNames;
import com.epam.trainingcenter.eshop.dao.impl.UserDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.UserDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.User;
import com.epam.trainingcenter.eshop.service.factory.UserFactory;
import com.epam.trainingcenter.eshop.validator.ValidateRegistration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * @author sburch
 * @version 1.0
 */

public class RegistrationAdminService implements Service {
    private UserFactory userFactory = UserFactory.getInstance();
    private UserDao userDao = new UserDaoImpl();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    /**
     * Servlet for register new admin
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws ParseException
     * @throws SQLException
     * @throws DaoException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException, DaoException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        if (request.getParameter(ConstantNames.EMAIL) != null) {
            String email = request.getParameter(ConstantNames.EMAIL);
            if (userDao.isEmailExist(email)) {

                request.setAttribute(ConstantNames.ERROR, ConstantNames.ERROR_EMAIL_EXIST);
                dispatcher = request.getRequestDispatcher(ConstantPageNames.REGISTRATION_JSP);
                dispatcher.forward(request, response);
            } else if (!ValidateRegistration.validateMailWithRegex(email)) {
                request.setAttribute(ConstantNames.ERROR, ConstantNames.ERROR_EMAIL_FORMAT);
                dispatcher = request.getRequestDispatcher(ConstantPageNames.REGISTRATION_JSP);
                dispatcher.forward(request, response);
            } else if (!ValidateRegistration.validatePasswordWithRegex(request.getParameter(ConstantNames.PASSWORD))) {
                request.setAttribute(ConstantNames.ERROR, ConstantNames.ERROR_PASSWORD_FORMAT);
                dispatcher = request.getRequestDispatcher(ConstantPageNames.REGISTRATION_JSP);
                dispatcher.forward(request, response);
            } else {
                User newUser = userFactory.fillUser(request, true);
                userDao.addUser(newUser);
                newUser.setId(userDao.getUserByLoginPassword(newUser.getEmail(), newUser.getPassword()).getId());
                session.setAttribute(ConstantNames.USER, newUser);
                session.setAttribute(ConstantNames.ADMIN, newUser.isAdmin());
                response.sendRedirect(ConstantPageNames.HOME_SERVICE);
            }

        } else {
            dispatcher = request.getRequestDispatcher(ConstantPageNames.REGISTRATION_JSP);
            dispatcher.forward(request, response);
        }
    }
}
