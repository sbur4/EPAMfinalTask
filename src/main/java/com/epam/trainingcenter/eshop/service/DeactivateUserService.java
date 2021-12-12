package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.UserDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.UserDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.USER_ID;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.ALL_USERS_SERVICE;

/**
 * @author sburch
 * @version 1.0
 */

public class DeactivateUserService implements Service {
    UserDao userDao = new UserDaoImpl();

    /**
     * Servlet block User for admin page
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
        long userId = Long.valueOf(request.getParameter(USER_ID));
        userDao.ActivateUser(userId, false);
        response.sendRedirect(ALL_USERS_SERVICE);
    }
}
