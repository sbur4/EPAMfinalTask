//package com.epam.trainingcenter.eshop.web.sort.service;
//
//import com.epam.trainingcenter.eshop.dao.impl.ProductDaoImpl;
//import com.epam.trainingcenter.eshop.dao.interfaces.ProductDao;
//import com.epam.trainingcenter.eshop.exeption.DaoException;
//import com.epam.trainingcenter.eshop.model.Product;
//import com.epam.trainingcenter.eshop.service.Service;
//import com.epam.trainingcenter.eshop.service.ServiceFactory;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.util.List;
//
//import static com.epam.trainingcenter.eshop.constant.ConstantNames.SORT_BY_PRICE;
//import static com.epam.trainingcenter.eshop.constant.ConstantPageNames.HOME_JSP;
//
///**
// * @author sburch
// * @version 1.0
// * Class has methods witch sorts products
// */
//
//public class SortByName implements Service {
//    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
//    ProductDao productDao = new ProductDaoImpl();
//
//    @Override
//    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException, DaoException {
//        RequestDispatcher dispatcher;
//        HttpSession session = request.getSession();
//        String sortByPrice = request.getParameter(SORT_BY_PRICE);
//        request.setAttribute(SORT_BY_PRICE, sortedProductByPrice());
//        dispatcher = request.getRequestDispatcher(HOME_JSP);
//        dispatcher.forward(request, response);
//    }
//
//    /**
//     * Method sorts product by name
//     *
//     * @return productList
//     * @throws DaoException
//     * @throws SQLException
//     * @throws IOException
//     */
//    public List<Product> sortedProductByPrice() throws DaoException, SQLException, IOException {
//        List<Product> productList = productDao.getAllProduct();
//        productList.sort(((n1, n2) -> {
//            String name1 = n1.getName();
//            String name2 = n2.getName();
//            return name1.compareTo(name2);
//        }));
//        return productList;
//    }
//}
