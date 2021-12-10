package com.epam.trainingcenter.eshop.service;
import com.epam.trainingcenter.eshop.dao.impl.UserDaoImpl;
import com.epam.trainingcenter.eshop.dao.interfaces.UserDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.User;
import com.epam.trainingcenter.eshop.service.factory.UserFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import static com.epam.trainingcenter.eshop.validator.ValidateRegistration.*;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;
import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.*;

public class RegistrationUserService implements Service{
    private UserFactory userFactory = UserFactory.getInstance();
    private UserDao userDao = new UserDaoImpl();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException, DaoException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        if(request.getParameter(EMAIL) != null) {
            String email = request.getParameter(EMAIL) ;
            if(userDao.isEmailExist(email)){
                request.setAttribute(ERROR, ERROR_EMAIL_EXIST);
                dispatcher = request.getRequestDispatcher(REGISTRATION_JSP);
                dispatcher.forward(request, response);
            }else if(!validateMailWithRegex(email)) {
                request.setAttribute(ERROR, ERROR_EMAIL_FORMAT);
                dispatcher = request.getRequestDispatcher(REGISTRATION_JSP);
                dispatcher.forward(request, response);
            }else if(!validatePasswordWithRegex(request.getParameter(PASSWORD))){
                request.setAttribute(ERROR, ERROR_PASSWORD_FORMAT);
                dispatcher = request.getRequestDispatcher(REGISTRATION_JSP);
                dispatcher.forward(request, response);
            }else{
                User newUser = userFactory.fillUser(request,false);
                userDao.addUser(newUser);
                newUser.setId(userDao.getUserByLoginPassword(newUser.getEmail(), newUser.getPassword()).getId());
                session.setAttribute(USER, newUser);
                session.setAttribute(ADMIN, newUser.isAdmin());
                response.sendRedirect(HOME_SERVICE);
            }

        }else{
            dispatcher = request.getRequestDispatcher(REGISTRATION_JSP);
            dispatcher.forward(request, response);
        }
    }
}
