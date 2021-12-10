package com.epam.trainingcenter.eshop.service.builder;

import com.epam.trainingcenter.eshop.model.Product;

/**
 * @author sburch
 * @version 1.0
 * Create interface to build new product
 */

public interface ProductBuilder {
    public ProductBuilder setId(long id);

    public ProductBuilder setName(String name);

    public ProductBuilder setDescription(String description);

    public ProductBuilder setPrice(double price);

    public ProductBuilder setImage_url(String image_url);

    public ProductBuilder setUserId(long userId);

    public Product build();
}
