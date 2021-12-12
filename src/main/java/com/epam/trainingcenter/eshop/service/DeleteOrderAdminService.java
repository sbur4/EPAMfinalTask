package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.AddressDaoImpl;
import com.epam.trainingcenter.eshop.dao.impl.OrderDaoImpl;
import com.epam.trainingcenter.eshop.dao.impl.OrderItemDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.AddressDao;
import com.epam.trainingcenter.eshop.dao.interfaces.OrderDao;
import com.epam.trainingcenter.eshop.dao.interfaces.OrderItemDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.ORDER_ID;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.ORDERS_ADMIN_SERVICE;

/**
 * @author sburch
 * @version 1.0
 */

public class DeleteOrderAdminService implements Service {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    AddressDao addressDao = new AddressDaoImpl();

    /**
     * Servlet deletes order for admin page
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
        long orderId = Long.valueOf(request.getParameter(ORDER_ID));
        long addressId = orderDao.getOrderById(orderId).getDeliveryAddressId();
        orderItemDao.deleteOrderItemsByOrderId(orderId);
        orderDao.deleteOrderById(orderId);
        addressDao.deleteAddressById(addressId);
        response.sendRedirect(ORDERS_ADMIN_SERVICE);
    }
}
