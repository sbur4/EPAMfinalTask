package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.OrderItemDaoImpl;
import com.epam.trainingcenter.eshop.dao.impl.ProductDaoImpl;
import com.epam.trainingcenter.eshop.dao.impl.StatusDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.OrderItemDao;
import com.epam.trainingcenter.eshop.dao.interfaces.ProductDao;
import com.epam.trainingcenter.eshop.dao.interfaces.StatusDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Product;
import com.epam.trainingcenter.eshop.model.Status;
import com.epam.trainingcenter.eshop.constant.ConstantNames;
import com.epam.trainingcenter.eshop.constant.ConstantPageNames;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailAdminService implements Service{

    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    StatusDao statusDao = new StatusDaoImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException, DaoException {

        RequestDispatcher dispatcher;

        long orderId = Long.valueOf(request.getParameter(ConstantNames.ORDER_ID));
        ArrayList<Long> productsIds = orderItemDao.getProductsIdFromOrderItem(orderId);

        ArrayList<Product> products = new ArrayList<>();
        for(Long productId : productsIds){
            products.add(productDao.getProductById(productId));
        }

        List<Status> statuses = statusDao.getAllStatuses();
        Status currentStatus = statusDao.getStatusByOrderId(orderId);

        request.setAttribute(ConstantNames.PRODUCTS, products);
        request.setAttribute(ConstantNames.STATUSES, statuses);
        request.setAttribute(ConstantNames.CURRENT_STATUS, currentStatus);
        request.setAttribute(ConstantNames.ORDER_ID, orderId);
        System.out.println(products);
        dispatcher = request.getRequestDispatcher(ConstantPageNames.ORDER_DETAIL_JSP);
        dispatcher.forward(request, response);
    }
}
