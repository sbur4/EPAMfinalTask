package com.epam.trainingcenter.eshop.service.factory;

import com.epam.trainingcenter.eshop.dao.impl.AddressDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.AddressDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Address;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * @version 1.0
 */

public class AddressFactory {
    public static AddressFactory instance = new AddressFactory();
    AddressDao addressDao = new AddressDaoImpl();

    /**
     * Fill fields in database when create new Address
     *
     * @param request
     * @return address
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     * @throws DaoException
     */
    public Address fillAddress(HttpServletRequest request) throws ServletException, IOException, SQLException, DaoException {
        Address address = new Address();
        address.setCountry(request.getParameter(COUNTRY));
        address.setCity(request.getParameter(CITY));
        address.setStreet(request.getParameter(STREET));
        address.setPhone(request.getParameter(PHONE));
        address.setId(addressDao.takeLastID() + 1);
        return address;
    }

    /**
     * Check instance of Address
     *
     * @return instance
     */
    public static AddressFactory getInstance() {
        if (instance == null) {
            instance = new AddressFactory();
        }
        return instance;
    }
}
