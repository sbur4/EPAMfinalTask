package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.OrderDaoImpl;
import com.epam.trainingcenter.eshop.dao.impl.UserDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.OrderDao;
import com.epam.trainingcenter.eshop.dao.interfaces.UserDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.ORDERS;
import static com.epam.trainingcenter.eshop.constant.ConstantNames.USER;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.LOGIN_SERVICE;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.ORDERS_ADMIN_JSP;

/**
 * @author sburch
 * @version 1.0
 */

public class ListOfOrdersForAdminService implements Service {
    UserDao userDao = new UserDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();

    /**
     * Servlet shows orders list for admin page
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

//    задача на защите
//        CartDao cartDao = new CartDaoImpl();
//        int count = cartDao.getAllInCart();

        User currentUser = (User) session.getAttribute(USER);
        if (currentUser.isAdmin()) {
            ArrayList<ArrayList<String>> orders = orderDao.getFrom4Tables();
            request.setAttribute(ORDERS, orders);

            //    задача на защите
//            request.setAttribute("count", count);

            dispatcher = request.getRequestDispatcher(ORDERS_ADMIN_JSP);
            dispatcher.forward(request, response);

        } else {
            response.sendRedirect(LOGIN_SERVICE);
        }
    }
}
