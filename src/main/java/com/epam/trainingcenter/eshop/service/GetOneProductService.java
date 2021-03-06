package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.ProductDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.ProductDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.ID;
import static com.epam.trainingcenter.eshop.constant.ConstantNames.PRODUCT;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.PRODUCT_DETAIL_JSP;

/**
 * @author sburch
 * @version 1.0
 */

public class GetOneProductService implements Service {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ProductDao productDao = new ProductDaoImpl();

    /**
     * Servlet shows product detail
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

        long productId = Long.valueOf(request.getParameter(ID));
        Product product = productDao.getProductById(productId);

        request.setAttribute(PRODUCT, product);
        dispatcher = request.getRequestDispatcher(PRODUCT_DETAIL_JSP);
        dispatcher.forward(request, response);


    }
}
