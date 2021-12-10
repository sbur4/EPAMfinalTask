package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.CartDaoImpl;
import com.epam.trainingcenter.eshop.dao.impl.ProductDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.CartDao;
import com.epam.trainingcenter.eshop.dao.interfaces.ProductDao;
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
import java.util.List;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.*;

public class OrderService implements Service{
    CartDao cartDao = new CartDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException, DaoException {
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        long userId = ((User)session.getAttribute(USER)).getId();

        List<Long> productIdsInCart = cartDao.getProductsInCart(userId);
        long totalPrice = 0;
        for(long productId: productIdsInCart){
            totalPrice+= productDao.getProductById(productId).getPrice();
        }

        request.setAttribute(TOTAL_PRICE, totalPrice);

        dispatcher = request.getRequestDispatcher(ORDER_JSP);
        dispatcher.forward(request, response);
    }
}
