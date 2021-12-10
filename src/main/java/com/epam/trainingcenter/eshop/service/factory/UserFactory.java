package com.epam.trainingcenter.eshop.service.factory;

import com.epam.trainingcenter.eshop.model.User;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * @version 1.0
 */

public class UserFactory {
    private static UserFactory instance = new UserFactory();

    /**
     * Fill fields in database when create new User
     * @param request
     * @param admin
     * @return new User
     */
    public User fillUser(HttpServletRequest request, boolean admin) {
        User newUser = new User();
        newUser.setFirstName(request.getParameter(FIRST_NAME));
        newUser.setLastName(request.getParameter(LAST_NAME));
        newUser.setEmail(request.getParameter(EMAIL));
        String password = request.getParameter(PASSWORD);
        String securedPassword = DigestUtils.md5Hex(password);
        newUser.setPassword(securedPassword);
        newUser.setAdmin(admin);
        newUser.setActive(true);
        return newUser;
    }

    /**
     * Check instance of User
     * @return instance
     */
    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }
}
