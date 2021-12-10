package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.ProductDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.ProductDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Product;
import com.epam.trainingcenter.eshop.service.factory.ProductFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.*;

/**
 * @author sburch
 * #
 */

public class CreateNewProductService implements Service{
    ProductDao productDao = new ProductDaoImpl();
    ProductFactory productFactory = ProductFactory.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException, DaoException {
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        Product product = new Product();
        String productName = request.getParameter(NAME);
        if(productName!=null) {
            product = productFactory.fillProduct(request);
            productDao.createProduct(product);
            response.sendRedirect(HOME_SERVICE);
        }else{
            dispatcher = request.getRequestDispatcher(CREATE_PRODUCT_JSP);
            dispatcher.forward(request, response);
        }
    }
}
