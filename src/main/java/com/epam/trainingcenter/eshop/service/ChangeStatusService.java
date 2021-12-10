package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.OrderDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.OrderDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * #
 */

public class ChangeStatusService implements Service {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException, DaoException {
        long orderId = Long.valueOf(request.getParameter(ORDER_ID));
        long statusId = Long.valueOf(request.getParameter(STATUS_ID));
        orderDao.changeOrderStatus(orderId, statusId);
        response.sendRedirect("orderDetail?orderId=" + orderId);
    }
}