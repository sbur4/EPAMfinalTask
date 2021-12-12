package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.constant.ConstantPageNames;
import com.epam.trainingcenter.eshop.dao.impl.UserDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.UserDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.User;
import com.epam.trainingcenter.eshop.validator.ValidateActiveUser;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * @version 1.0
 */

public class LoginUserService implements Service {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private UserDao userDao = new UserDaoImpl();

    /**
     * Servlet for log in
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
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

        String login = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);

        if (login != null && password != null) {
            String securedPassword = DigestUtils.md5Hex(password);
            User user = userDao.getUserByLoginPassword(login, securedPassword);

            if (user != null) {
                if (ValidateActiveUser.checkAccess(user)) {
                    session.setAttribute(USER, user);
                    session.setAttribute(ADMIN, user.isAdmin());
                    response.sendRedirect(ConstantPageNames.HOME_SERVICE);
                } else {
                    request.setAttribute(ERROR, ERROR_USER_BLOCKED);
                    dispatcher = request.getRequestDispatcher(ConstantPageNames.LOGIN_JSP);
                    dispatcher.forward(request, response);

                }
            } else {
                request.setAttribute(ERROR, ERROR_EMAIL_OR_PASSWORD);
                dispatcher = request.getRequestDispatcher(ConstantPageNames.LOGIN_JSP);
                dispatcher.forward(request, response);
            }

        } else {
            dispatcher = request.getRequestDispatcher(ConstantPageNames.LOGIN_JSP);
            dispatcher.forward(request, response);
        }
    }
}
