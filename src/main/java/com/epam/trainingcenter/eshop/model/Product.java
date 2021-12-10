package com.epam.trainingcenter.eshop.model;

import java.util.Objects;

/**
 * @author sburch
 * @version 1.0
 * Use POJO class for entity Product
 */

public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private String image_url;
    private long userId;

    /**
     * Default constructor for class Product
     */
    public Product() {
    }

    /**
     * Constructor with parameters
     *
     * @param id
     * @param name
     * @param description
     * @param price
     * @param image_url
     * @param userId
     */
    public Product(long id, String name, String description, double price, String image_url, long userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image_url = image_url;
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
     * Method gets name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method sets name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method gets description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method sets description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method gets price
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Method sets price
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method gets image_url
     *
     * @return image_url
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     * Method sets image_url
     *
     * @param image_url
     */
    public void setImage_url(String image_url) {
        this.image_url = image_url;
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
        result = PRIME * result + ((name == null) ? 0 : name.hashCode());
        result = PRIME * result + ((description == null) ? 0 : description.hashCode());
        result = (int) (PRIME * result + getPrice());
        result = PRIME * result + ((image_url == null) ? 0 : image_url.hashCode());
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
        Product product = (Product) obj;
        return Objects.equals(id, product.id)
                && Objects.equals(name, product.name)
                && Objects.equals(description, product.description)
                && Objects.equals(price, product.price)
                && Objects.equals(image_url, product.image_url)
                && Objects.equals(userId, product.userId);
    }

    /**
     * Method returns object with parametrs to string
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image_url='" + image_url + '\'' +
                ", userId=" + userId +
                '}';
    }
}
