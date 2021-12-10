package com.epam.trainingcenter.eshop.service.factory;

import com.epam.trainingcenter.eshop.dao.impl.OrderDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.OrderDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Address;
import com.epam.trainingcenter.eshop.model.Order;
import com.epam.trainingcenter.eshop.model.Status;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author sburch
 * @version 1.0
 */

public class OrderFactory {
    public static OrderFactory instance = new OrderFactory();
    OrderDao orderDao = new OrderDaoImpl();

    /**
     * Fill fields in database when create new Order
     *
     * @param request
     * @param status
     * @param address
     * @return order
     * @throws SQLException
     * @throws DaoException
     */
    public Order fillOrder(HttpServletRequest request, Status status, Address address) throws SQLException, DaoException {
        Order order = new Order();
        order.setId(orderDao.takeLastID() + 1);
        LocalDateTime now = LocalDateTime.now();
        Timestamp dateTime = Timestamp.valueOf(now);
        order.setDateTime(dateTime);
        order.setStatusId(status.getId());
        order.setDeliveryAddressId(address.getId());
        return order;
    }

    /**
     * Check instance of Order
     *
     * @return instance
     */
    public static OrderFactory getInstance() {
        if (instance == null) {
            instance = new OrderFactory();
        }
        return instance;
    }
}
