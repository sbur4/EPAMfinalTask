package com.epam.trainingcenter.eshop.service.builder;

import com.epam.trainingcenter.eshop.model.Product;

/**
 * @author sburch
 * @version 1.0
 * This class create a new product
 */

public class ProductBuilderImpl implements ProductBuilder {
    Product product = new Product();

    /**
     * Sets product id
     *
     * @param id
     * @return id
     */
    public ProductBuilder setId(long id) {
        product.setId(id);
        return this;
    }

    /**
     * Sets product name
     *
     * @param name
     * @return name
     */
    public ProductBuilder setName(String name) {
        product.setName(name);
        return this;
    }

    /**
     * Sets product description
     *
     * @param description
     * @return description
     */
    public ProductBuilder setDescription(String description) {
        product.setDescription(description);
        return this;
    }

    /**
     * Sets product price
     *
     * @param price
     * @return price
     */
    public ProductBuilder setPrice(double price) {
        product.setPrice(price);
        return this;
    }

    /**
     * Sets product image_url
     *
     * @param image_url
     * @return image_url
     */
    public ProductBuilder setImage_url(String image_url) {
        product.setImage_url(image_url);
        return this;
    }

    /**
     * Sets product userId
     *
     * @param userId
     * @return userId
     */
    public ProductBuilder setUserId(long userId) {
        product.setUserId(userId);
        return this;
    }

    /**
     * Build Product
     *
     * @return product
     */
    @Override
    public Product build() {
        return product;
    }
}
