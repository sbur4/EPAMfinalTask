package com.epam.trainingcenter.eshop.validator;

import com.epam.trainingcenter.eshop.model.User;

/**
 * @author sburch
 * @version 1.0
 * This class checks is active user or not
 */

public class ValidateActiveUser {

    public static boolean checkAccess(User user) {
        boolean isAccess = false;
        boolean isActivity = user.isActive();

        if (isActivity == true) {
            isAccess = true;
        }
        return isAccess;
    }
}
