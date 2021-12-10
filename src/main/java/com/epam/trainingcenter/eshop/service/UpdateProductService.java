package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.ProductDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.ProductDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Product;
import com.epam.trainingcenter.eshop.service.factory.ProductFactory;
import com.epam.trainingcenter.eshop.constant.ConstantNames;
import com.epam.trainingcenter.eshop.constant.ConstantPageNames;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * @author sburch
 * @version 1.0
 */

public class UpdateProductService implements Service {
    ProductDao productDao = new ProductDaoImpl();
    ProductFactory productFactory = ProductFactory.getInstance();

    /**
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
        //TODO check authentication
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        String productName = request.getParameter(ConstantNames.NAME);
//        System.out.println(productName);
        if (productName != null) {
            Product product = productFactory.updateProduct(request);
            productDao.updateProduct(product);
            response.sendRedirect(ConstantPageNames.HOME_SERVICE);
        } else {
            Product product = productDao.getProductById(Long.valueOf(request.getParameter(ConstantNames.PRODUCT_ID)));
            request.setAttribute(ConstantNames.PRODUCT, product);
            dispatcher = request.getRequestDispatcher(ConstantPageNames.UPDATE_PRODUCT_JSP);
            dispatcher.forward(request, response);
        }
    }
}
