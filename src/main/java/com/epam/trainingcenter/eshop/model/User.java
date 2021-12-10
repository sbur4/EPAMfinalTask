package com.epam.trainingcenter.eshop.model;

import java.util.Objects;

/**
 * @author sburch
 * @version 1.0
 * Use POJO class for entity User
 */

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean admin;
    private boolean active;

    /**
     * Default constructor for class User
     */
    public User() {
    }

    /**
     * Constructor with parameters
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param admin
     * @param active
     */
    public User(long id, String firstName, String lastName, String email, String password, boolean admin, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.active = active;
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
     * Method gets firstName
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method sets firstName
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method gets lastName
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method sets lastName
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method gets email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method sets email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method gets password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method sets password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method checks is admin or not
     *
     * @return admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * Method sets admin
     *
     * @param admin
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Method checks is active or not
     *
     * @return active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Method sets active
     *
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
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
        result = PRIME * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = PRIME * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = PRIME * result + ((email == null) ? 0 : email.hashCode());
        result = PRIME * result + ((password == null) ? 0 : password.hashCode());
        result = PRIME * result + Boolean.hashCode(admin);
        result = PRIME * result + Boolean.hashCode(active);
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
        User user = (User) obj;
        return Objects.equals(id, user.id)
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && Objects.equals(admin, user.admin)
                && Objects.equals(active, user.active);
    }

    /**
     * Method returns object with parametrs to string
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", active=" + active +
                '}';
    }
}
