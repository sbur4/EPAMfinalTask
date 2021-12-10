package com.epam.trainingcenter.eshop.model;

import java.util.Objects;

/**
 * @author sburch
 * @version 1.0
 * Use POJO class for entity Status
 */

public class Status {
    private long id;
    private String statusName;

    /**
     * Default constructor for class Status
     */
    public Status() {
    }

    /**
     * Constructor with parameters
     *
     * @param id
     * @param statusName
     */
    public Status(long id, String statusName) {
        this.id = id;
        this.statusName = statusName;
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
     * Method gets statusName
     *
     * @return statusName
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * Method sets statusName
     *
     * @param statusName
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
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
        result = PRIME * result + ((statusName == null) ? 0 : statusName.hashCode());
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
        Status status = (Status) obj;
        return Objects.equals(id, status.id)
                && Objects.equals(statusName, status.statusName);
    }

    /**
     * Method returns object with parametrs to string
     */
    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
