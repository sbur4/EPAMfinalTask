package com.epam.trainingcenter.eshop.model;

import java.util.Objects;

/**
 * @author sburch
 * @version 1.0
 * Use POJO class for entity Address
 */

public class Address {
    private long id;
    private String country;
    private String city;
    private String street;
    private String phone;

    /**
     * Default constructor for class Address
     */
    public Address() {
    }

    /**
     * Constructor with parameters
     *
     * @param id
     * @param country
     * @param city
     * @param street
     * @param phone
     */
    public Address(long id, String country, String city, String street, String phone) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.phone = phone;
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
     * Method gets country
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Method sets country
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Method gets city
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Method sets city
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method gets street
     *
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Method sets street
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Method gets phone
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Method sets phone
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
        result = PRIME * result + ((country == null) ? 0 : country.hashCode());
        result = PRIME * result + ((city == null) ? 0 : city.hashCode());
        result = PRIME * result + ((street == null) ? 0 : street.hashCode());
        result = PRIME * result + ((phone == null) ? 0 : phone.hashCode());
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
        Address address = (Address) obj;
        return Objects.equals(id, address.id)
                && Objects.equals(country, address.country)
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street)
                && Objects.equals(phone, address.phone);
    }

    /**
     * Method returns object with parameters to string
     */
    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
