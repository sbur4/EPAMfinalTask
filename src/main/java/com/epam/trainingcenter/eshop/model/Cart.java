package com.epam.trainingcenter.eshop.model;

import java.util.Objects;

/**
 * @author sburch
 * @version 1.0
 * Use POJO class for entity Cart
 */

public class Cart {
    private long id;
    private long productId;
    private long userId;

    /**
     * Default constructor for class Cart
     */
    public Cart() {
    }

    /**
     * Constructor with parameters
     *
     * @param id
     * @param productId
     * @param userId
     */
    public Cart(long id, long productId, long userId) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
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
        Cart cart = (Cart) obj;
        return Objects.equals(id, cart.id)
                && Objects.equals(productId, cart.productId)
                && Objects.equals(userId, cart.userId);
    }

    /**
     * Method returns object with parameters to string
     */
    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                '}';
    }
}
