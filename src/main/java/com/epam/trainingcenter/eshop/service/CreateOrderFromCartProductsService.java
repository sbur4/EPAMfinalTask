package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.*;
import com.epam.trainingcenter.eshop.dao.interfaces.*;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.*;
import com.epam.trainingcenter.eshop.service.factory.AddressFactory;
import com.epam.trainingcenter.eshop.service.factory.OrderFactory;
import com.epam.trainingcenter.eshop.service.factory.OrderItemFactory;
import com.epam.trainingcenter.eshop.service.factory.StatusFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.*;

/**
 * @author sburch
 * #
 */

public class CreateOrderFromCartProductsService implements Service {
    CartDao cartDao = new CartDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    AddressDao addressDao = new AddressDaoImpl();
    StatusDao statusDao = new StatusDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    AddressFactory addressFactory = AddressFactory.getInstance();
    StatusFactory statusFactory = StatusFactory.getInstance();
    OrderFactory orderFactory = OrderFactory.getInstance();
    OrderItemFactory orderItemFactory = OrderItemFactory.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException, DaoException {

        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        long userId = ((User) session.getAttribute(USER)).getId();
        List<Long> productIdsInCart = cartDao.getProductsInCart(userId);
        Address address = addressFactory.fillAddress(request);
        addressDao.createAddress(address);
        Status status = statusFactory.fillStatus(request);
        Order order = orderFactory.fillOrder(request, status, address);
        orderDao.createOrder(order);
        for (Long productId : productIdsInCart) {
            OrderItem orderItem = orderItemFactory.fillOrderItem(request, productId, userId, order);
            orderItemDao.createOrderItem(orderItem);
        }
        cartDao.deleteProductFromCartByUserId(userId);
        response.sendRedirect(HOME_SERVICE);
    }
}
