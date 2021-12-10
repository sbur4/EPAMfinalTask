package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.CartDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.CartDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.PRODUCT_ID;
import static com.epam.trainingcenter.eshop.constant.ConstantNames.USER;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.CART_SERVICE;

/**
 * @author sburch
 * #
 */

public class DeleteProductFromCartService implements Service {
    CartDao cartDao = new CartDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException, DaoException {
        HttpSession session = request.getSession();
        long userId = ((User)session.getAttribute(USER)).getId();
        long productId = Long.valueOf(request.getParameter(PRODUCT_ID));
        cartDao.DeleteProductInCart(productId,userId);
        response.sendRedirect(CART_SERVICE);
    }
}
