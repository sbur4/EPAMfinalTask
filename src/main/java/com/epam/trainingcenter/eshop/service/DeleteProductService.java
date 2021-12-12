package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.CartDaoImpl;
import com.epam.trainingcenter.eshop.dao.impl.ProductDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.CartDao;
import com.epam.trainingcenter.eshop.dao.interfaces.ProductDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.PRODUCT_ID;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.HOME_SERVICE;

/**
 * @author sburch
 * @version 1.0
 */

public class DeleteProductService implements Service {
    ProductDao productDao = new ProductDaoImpl();
    CartDao cartDao = new CartDaoImpl();

    /**
     * Servlet deletes products
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
        long productId = Long.valueOf(request.getParameter(PRODUCT_ID));
        List<Cart> carts = cartDao.getAllFromCart(productId);
        for (Cart eachProductInCart : carts) {
            cartDao.DeleteProductInCart(productId, eachProductInCart.getUserId());
        }
        productDao.deleteProduct(productId);
        response.sendRedirect(HOME_SERVICE);
    }
}
