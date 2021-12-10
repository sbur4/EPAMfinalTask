package com.epam.trainingcenter.eshop.service.factory;

import com.epam.trainingcenter.eshop.model.Order;
import com.epam.trainingcenter.eshop.model.OrderItem;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sburch
 * @version 1.0
 */

public class OrderItemFactory {
    public static OrderItemFactory instance = new OrderItemFactory();

    /**
     * Fill fields in database when create new OrderItem
     * @param request
     * @param productId
     * @param userId
     * @param order
     * @return orderItem
     */
    public OrderItem fillOrderItem(HttpServletRequest request, long productId, long userId, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(productId);
        orderItem.setUserId(userId);
        orderItem.setOrderId(order.getId());
        return orderItem;
    }

    /**
     * Check instance of OrderItem
     *
     * @return instance
     */
    public static OrderItemFactory getInstance() {
        if (instance == null) {
            instance = new OrderItemFactory();
        }
        return instance;
    }
}
