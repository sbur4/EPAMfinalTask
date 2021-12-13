package com.epam.trainingcenter.eshop.validator;

import com.epam.trainingcenter.eshop.model.User;

/**
 * @author sburch
 * @version 1.0
 * This class checks active User
 */

public class ValidateActiveUser {

    /**
     * Method check access to store
     *
     * @param user
     * @return isAccess
     */
    public static boolean checkAccess(User user) {
        boolean isAccess = false;
        boolean isActivity = user.isActive();

        if (isActivity == true) {
            isAccess = true;
        }
        return isAccess;
    }
}
