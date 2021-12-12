package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.CartDaoImpl;
import com.epam.trainingcenter.eshop.dao.impl.ProductDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.CartDao;
import com.epam.trainingcenter.eshop.dao.interfaces.ProductDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Product;
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
import java.util.List;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.CART_JSP;

/**
 * @author sburch
 * @version 1.0
 */

public class GetAllProductFromCartService implements Service {
    CartDao cartDao = new CartDaoImpl();
    ProductDao productDao = new ProductDaoImpl();

    /**
     * Servlet shows all info about products in cart
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
        long userId = ((User) session.getAttribute(USER)).getId();

        List<Long> productIdsInCart = cartDao.getProductsInCart(userId);

        long sumOfPrice = 0;
        List<Product> products_in_cart = new ArrayList<>();
        for (long productId : productIdsInCart) {
            Product product = productDao.getProductById(productId);
            products_in_cart.add(product);
            sumOfPrice += product.getPrice();
        }

        request.setAttribute(PRODUCT_IDS_IN_CART, products_in_cart);
        request.setAttribute(SUM_OF_PRICE, sumOfPrice);

        dispatcher = request.getRequestDispatcher(CART_JSP);
        dispatcher.forward(request, response);
    }
}
