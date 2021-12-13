package com.epam.trainingcenter.eshop.model;

import java.util.Objects;

/**
 * @author sburch
 * @version 1.0
 * Use POJO class for entity OrderItem
 */

public class OrderItem {
    private long id;
    private long productId;
    private long userId;
    private long orderId;

    /**
     * Default constructor for class OrderItem
     */
    public OrderItem() {
    }

    /**
     * Constructor with parameters
     *
     * @param id
     * @param productId
     * @param userId
     * @param orderId
     */
    public OrderItem(long id, long productId, long userId, long orderId) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.orderId = orderId;
    }

    /**
     * Method gets id
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Method sets id
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Method gets productId
     *
     * @return productId
     */
    public long getProductId() {
        return productId;
    }

    /**
     * Method sets productId
     *
     * @param productId
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }

    /**
     * Method gets userId
     *
     * @return userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Method sets userId
     *
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Method gets orderId
     *
     * @return orderId
     */
    public long getOrderId() {
        return orderId;
    }

    /**
     * Method sets orderId
     *
     * @param orderId
     */
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    /**
     * Method generates hashCode of the object
     */
    @Override
    public int hashCode() {
//        return super.hashCode();
        final int PRIME = 31;
        int result = 1;
        result = (int) (PRIME * result + getId());
        result = (int) (PRIME * result + getProductId());
        result = (int) (PRIME * result + getUserId());
        result = (int) (PRIME * result + getOrderId());
        return result;
    }

    /**
     * Method equals objects
     *
     * @param obj
     */
    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OrderItem orderItem = (OrderItem) obj;
        return Objects.equals(id, orderItem.id)
                && Objects.equals(productId, orderItem.productId)
                && Objects.equals(userId, orderItem.userId)
                && Objects.equals(orderId, orderItem.orderId);
    }

    /**
     * Method returns object with parameters to string
     */
    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", orderId=" + orderId +
                '}';
    }
}
