package com.epam.trainingcenter.eshop.service.builder;

import com.epam.trainingcenter.eshop.model.Product;

/**
 * @author sburch
 * @version 1.0
 * interface to builds new product
 */

public interface ProductBuilder {
    /**
     * Sets id
     *
     * @param id
     * @return id
     */
    public ProductBuilder setId(long id);

    /**
     * Sets name
     *
     * @param name
     * @return name
     */
    public ProductBuilder setName(String name);

    /**
     * Sets description
     *
     * @param description
     * @return name
     */
    public ProductBuilder setDescription(String description);

    /**
     * Sets price
     *
     * @param price
     * @return price
     */
    public ProductBuilder setPrice(double price);

    /**
     * Sets image_url
     *
     * @param image_url
     * @return image_url
     */
    public ProductBuilder setImage_url(String image_url);

    /**
     * Sets userId
     *
     * @param userId
     * @return userId
     */
    public ProductBuilder setUserId(long userId);

    /**
     * Builds product
     *
     * @return product
     */
    public Product build();
}
