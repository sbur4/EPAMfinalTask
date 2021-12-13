package com.epam.trainingcenter.eshop.service.factory;

import com.epam.trainingcenter.eshop.dao.impl.StatusDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.StatusDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Status;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.STATUS_PENDING;

/**
 * @author sburch
 * @version 1.0
 */

public class StatusFactory {
    public static StatusFactory instance = new StatusFactory();
    StatusDao statusDao = new StatusDaoImpl();

    /**
     * Fills status
     *
     * @param request
     * @return status
     * @throws IOException
     * @throws SQLException
     * @throws DaoException
     */
    public Status fillStatus(HttpServletRequest request) throws IOException, SQLException, DaoException {
        Status status = new Status();
        status.setId(statusDao.getIdByStatusName(STATUS_PENDING));
        status.setStatusName(STATUS_PENDING);
        return status;
    }

    /**
     * Checks instance of Status
     *
     * @return instance
     */
    public static StatusFactory getInstance() {
        if (instance == null) {
            instance = new StatusFactory();
        }
        return instance;
    }
}
