package com.epam.trainingcenter.eshop.model;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author sburch
 * @version 1.0
 * Use POJO class for entity Order
 */

public class Order {
    private long id;
    private Timestamp dateTime;
    private long statusId;
    private long deliveryAddressId;

    /**
     * Default constructor for class Order
     */
    public Order() {
    }

    /**
     * Constructor with parameters
     *
     * @param id
     * @param dateTime
     * @param statusId
     * @param deliveryAddressId
     */
    public Order(long id, Timestamp dateTime, long statusId, long deliveryAddressId) {
        this.id = id;
        this.dateTime = dateTime;
        this.statusId = statusId;
        this.deliveryAddressId = deliveryAddressId;
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
     * Method gets dateTime
     *
     * @return dateTime
     */
    public Timestamp getDateTime() {
        return dateTime;
    }

    /**
     * Method sets dateTime
     *
     * @param dateTime
     */
    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Method gets statusId
     *
     * @return statusId
     */
    public long getStatusId() {
        return statusId;
    }

    /**
     * Method sets statusId
     *
     * @param statusId
     */
    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    /**
     * Method gets deliveryAddressId
     *
     * @return deliveryAddressId
     */
    public long getDeliveryAddressId() {
        return deliveryAddressId;
    }

    /**
     * Method sets deliveryAddressId
     *
     * @param deliveryAddressId
     */
    public void setDeliveryAddressId(long deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
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
        result = PRIME * result + dateTime.hashCode();
        result = (int) (PRIME * result + getStatusId());
        result = (int) (PRIME * result + getDeliveryAddressId());
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
        Order order = (Order) obj;
        return Objects.equals(id, order.id)
                && Objects.equals(dateTime, order.dateTime)
                && Objects.equals(statusId, order.statusId)
                && Objects.equals(deliveryAddressId, order.deliveryAddressId);
    }

    /**
     * Method returns object with parametrs to string
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
