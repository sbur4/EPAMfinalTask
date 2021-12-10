package com.epam.trainingcenter.eshop.service.factory;

import com.epam.trainingcenter.eshop.model.Cart;
import com.epam.trainingcenter.eshop.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * @version 1.0
 */

public class CartFactory {
    private static CartFactory instance = new CartFactory();

    /**
     * Fill fields in database when create new UCart
     *
     * @param request
     * @return cart
     */
    public Cart fillCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = new Cart();
        long productId = Long.valueOf(request.getParameter(PRODUCT_ID));
        long userId = ((User) session.getAttribute(USER)).getId();
        cart.setUserId(userId);
        cart.setProductId(productId);
        return cart;
    }

    /**
     * Check instance of Cart
     *
     * @return instance
     */
    public static CartFactory getInstance() {
        if (instance == null) {
            instance = new CartFactory();
        }
        return instance;
    }
}
