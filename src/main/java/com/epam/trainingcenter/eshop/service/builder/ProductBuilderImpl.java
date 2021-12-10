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
     * @param id Set product id
     * @return id
     */
    public ProductBuilder setId(long id) {
        product.setId(id);
        return this;
    }

    /**
     * @param name Set product name
     * @return name
     */
    public ProductBuilder setName(String name) {
        product.setName(name);
        return this;
    }

    /**
     * @param description Set product description
     * @return description
     */
    public ProductBuilder setDescription(String description) {
        product.setDescription(description);
        return this;
    }

    /**
     * @param price Set product price
     * @return price
     */
    public ProductBuilder setPrice(double price) {
        product.setPrice(price);
        return this;
    }

    /**
     * @param image_url Set product image_url
     * @return image_url
     */
    public ProductBuilder setImage_url(String image_url) {
        product.setImage_url(image_url);
        return this;
    }

    /**
     * @param userId Set product userId
     * @return userId
     */
    public ProductBuilder setUserId(long userId) {
        product.setUserId(userId);
        return this;
    }

    /**
     * @return product
     */
    @Override
    public Product build() {
        return product;
    }
}
