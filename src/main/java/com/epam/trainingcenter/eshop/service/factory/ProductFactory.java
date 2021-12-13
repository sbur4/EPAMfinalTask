package com.epam.trainingcenter.eshop.service.factory;

import com.epam.trainingcenter.eshop.model.Product;
import com.epam.trainingcenter.eshop.service.builder.ProductBuilderImpl;
import com.epam.trainingcenter.eshop.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * @version 1.0
 */

public class ProductFactory {
    private static ProductFactory instance = new ProductFactory();

    /**
     * Fills fields in database when create new Product
     *
     * @param request
     * @return product
     */
    public Product fillProduct(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Product product = new ProductBuilderImpl().
                setName(request.getParameter(NAME)).
                setDescription(request.getParameter(DESCRIPTION)).
                setImage_url(request.getParameter(IMAGE_URL)).
                setPrice(Long.valueOf(request.getParameter(PRICE))).
                setUserId(((User) session.getAttribute(USER)).getId())
                .build();
        return product;
    }

    /**
     * Updates Product
     *
     * @param request
     * @return product
     */
    public Product updateProduct(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Product product = new ProductBuilderImpl().
                setName(request.getParameter(NAME)).
                setDescription(request.getParameter(DESCRIPTION)).
                setImage_url(request.getParameter(IMAGE_URL)).
                setPrice(Long.valueOf(request.getParameter(PRICE))).
                setUserId(((User) session.getAttribute(USER)).getId())
                .setId(Long.valueOf(request.getParameter(PRODUCT_ID)))
                .build();
        return product;
    }

    /**
     * Checks instance of Product
     *
     * @return instance
     */
    public static ProductFactory getInstance() {
        if (instance == null) {
            instance = new ProductFactory();
        }
        return instance;
    }
}
