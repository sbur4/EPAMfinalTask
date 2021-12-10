package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.CartDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.CartDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Cart;
import com.epam.trainingcenter.eshop.model.User;
import com.epam.trainingcenter.eshop.service.factory.CartFactory;

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

public class AddProductToCartService implements Service {
    CartDao cartDao = new CartDaoImpl();
    CartFactory cartFactory = CartFactory.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException, DaoException {
        HttpSession session = request.getSession();
        long productId = Long.valueOf(request.getParameter(PRODUCT_ID));
        long userId = ((User) session.getAttribute(USER)).getId();
        List<Long> productInCart = cartDao.getProductsInCart(userId);
        boolean alreadyInCart = false;
        for (Long product : productInCart) {
            if (product.equals(productId)) {
                //TODO  Make code more effective!!! Try add one item to the table with multiply function
                product++;
            }
        }
//        for (Long product : productInCart) {
//            if (product.equals(productId)) {
//                alreadyInCart = true;
//                break;
//            }
//        }
        if (!alreadyInCart) {
            Cart cart = cartFactory.fillCart(request);
            cartDao.addProductToCart(cart);
            response.sendRedirect(CART_SERVICE);
        } else {
            response.sendRedirect(HOME_SERVICE);
        }
    }
}
