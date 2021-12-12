package com.epam.trainingcenter.eshop.service;

import com.epam.trainingcenter.eshop.dao.impl.ProductDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.ProductDao;
import com.epam.trainingcenter.eshop.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.PRODUCTS;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.HOME_JSP;

/**
 * @author sburch
 * @version 1.0
 */

public class SortProductsService implements Service {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ProductDao productDao = new ProductDaoImpl();
    private static final int SHIFT = 0;

    /**
     * Servlet shows all products
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        int page = 1;
        int pageSize = 8;
        double size = 0;
        String sortBy = request.getParameter("sortBy");
        if (request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        List<Product> products = productDao.findProductsForPaginationAndSort(pageSize, (page - 1) * pageSize, sortBy);
        size = productDao.getProductsSizeForPagination();
        int pageCount = (int) Math.ceil(size / pageSize);
        int minPagePossible = page - SHIFT < 1 ? 1 : page - SHIFT;
        int maxPagePossible = page + SHIFT > pageCount ? pageCount : page + SHIFT;
        request.setAttribute(PRODUCTS, products);
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("page", page);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("minPossiblePage", minPagePossible);
        request.setAttribute("maxPossiblePage", maxPagePossible);
        dispatcher = request.getRequestDispatcher(HOME_JSP);
        dispatcher.forward(request, response);
    }
}
