package com.epam.trainingcenter.eshop.dao.impl;

import com.epam.trainingcenter.eshop.connection.ConnectionPool;
import com.epam.trainingcenter.eshop.dao.interfaces.ProductDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.*;

/**
 * @author sburch
 * @version 1.0
 */

public class ProductDaoImpl extends ConnectionPool implements ProductDao {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    //Main requests
    private static final String GET_ALL_PRODUCTS = "SELECT * FROM product";
    private static final String GET_PRODUCT = "SELECT * FROM product WHERE id = ?";
    private static final String INSERT_PRODUCT = "INSERT product(name, description, price, image_url, user_id) VALUES(?,?,?,?,?)";
    private static final String UPDATE_PRODUCT = "UPDATE product SET  name = ?, description = ?, price = ?, image_url= ? WHERE id = ?";
    private static final String SELECT_SEARCHED_PRODUCT = "SELECT * FROM product WHERE name like ? ";
    private static final String DELETE_PRODUCT = "DELETE FROM product WHERE id = ? ";
    //pagination
    private static final String GET_PRODUCTS = "SELECT * FROM product limit ? offset ?";
    private static final String GET_PRODUCTS_SIZE = "SELECT COUNT(*) FROM product";
    //Sorting requests a-z
    private static final String SORT_NAME_ASC = "SELECT * FROM product ORDER BY name ASC limit ? offset ?";
    private static final String SORT_NAME_DESC = "SELECT * FROM product ORDER BY name DESC limit ? offset ?";
    //Sorting requests price
    private static final String SORT_LOW_PRICE = "SELECT * FROM product ORDER BY price ASC limit ? offset ?";
    private static final String SORT_HIGH_PRICE = "SELECT * FROM product ORDER BY price DESC limit ? offset ?";
    //Sorting requests capacity
    private static final String SORT_CAP_033_L = "SELECT * FROM product WHERE description LIKE '%0.33%' limit ? offset ?";
    private static final String SORT_CAP_05_L = "SELECT * FROM product WHERE description LIKE '%0.5%' limit ? offset ?";
    private static final String SORT_CAP_075_L = "SELECT * FROM product WHERE description LIKE '%0.75%' limit ? offset ?";
    private static final String SORT_CAP_1_L = "SELECT * FROM product WHERE description LIKE '%1 L%' limit ? offset ?";
    private static final String SORT_CAP_1_5_L = "SELECT * FROM product WHERE description LIKE '%1.5%' limit ? offset ?";
    private static final String SORT_CAP_2_L = "SELECT * FROM product WHERE description LIKE '%2%' limit ? offset ?";
    private static final String GET_SIZE_CAP_033_L = "SELECT COUNT(*) FROM product WHERE description LIKE '%0.33%'";
    private static final String GET_SIZE_CAP_05_L = "SELECT COUNT(*) FROM product WHERE description LIKE '%0.5%'";
    private static final String GET_SIZE_CAP_075_L = "SELECT COUNT(*) FROM product WHERE description LIKE '%0.75%'";
    private static final String GET_SIZE_CAP_1_L = "SELECT COUNT(*) FROM product WHERE description LIKE '%1 L%'";
    private static final String GET_SIZE_CAP_1_5_L = "SELECT COUNT(*) FROM product WHERE description LIKE '%1.5%'";
    private static final String GET_SIZE_CAP_2_L = "SELECT COUNT(*) FROM product WHERE description LIKE '%2%'";
    //Sorting requests material
    private static final String SORT_MAT_PLASTIC = "SELECT * FROM product WHERE description LIKE '%PL%' limit ? offset ?";
    private static final String SORT_MAT_GLASS = "SELECT * FROM product WHERE description LIKE '%GL%' limit ? offset ?";
    private static final String SORT_MAT_METAL = "SELECT * FROM product WHERE description LIKE '%CAN%' limit ? offset ?";
    private static final String GET_SIZE_MAT_PLASTIC = "SELECT COUNT(*) FROM product WHERE description LIKE '%PL%'";
    private static final String GET_SIZE_MAT_GLASS = "SELECT COUNT(*) FROM product WHERE description LIKE '%GL%'";
    private static final String GET_SIZE_MAT_METAL = "SELECT COUNT(*) FROM product WHERE description LIKE '%CAN%'";

    /**
     * Method gets product by id
     *
     * @param id
     * @return product
     * @throws DaoException
     */
    public Product getProductById(Long id) throws DaoException {
        Product product = null;
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(GET_PRODUCT);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setId(rs.getLong(ID));
                product.setName(rs.getString(NAME));
                product.setDescription(rs.getString(DESCRIPTION));
                product.setPrice(rs.getLong(PRICE));
                product.setImage_url(rs.getString(IMAGE_URL));
                product.setUserId(rs.getLong(ID_USER));
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
                LOGGER.error("Error connection", e);
            }
            LOGGER.error("Error get product by id", e);
        }
        return product;
    }

    /**
     * Method gets all products
     *
     * @return products
     * @throws DaoException
     */
    public List<Product> getAllProduct() throws DaoException {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(GET_ALL_PRODUCTS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong(ID));
                product.setName(rs.getString(NAME));
                product.setDescription(rs.getString(DESCRIPTION));
                product.setPrice(rs.getLong(PRICE));
                product.setImage_url(rs.getString(IMAGE_URL));
                product.setUserId(rs.getLong(ID_USER));
                products.add(product);
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
                LOGGER.error("Error connection", e2);
            }
            LOGGER.error("Error get all product", e);
        }
        return products;
    }

    /**
     * Method updates product
     *
     * @param product
     * @throws DaoException
     */
    public void updateProduct(Product product) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getImage_url());
            preparedStatement.setLong(5, product.getId());
            int count = preparedStatement.executeUpdate();
            if (count != 1)
                throw new SQLException("Updated " + count + " rows");
            preparedStatement.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error update product", e);
        }
    }

    /**
     * Method gets product by id
     *
     * @param product
     * @throws SQLException
     * @throws IOException
     */
    public void createProduct(Product product) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_PRODUCT);
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setString(4, product.getImage_url());
            pstmt.setLong(5, product.getUserId());
            int count = pstmt.executeUpdate();
            if (count != 1)
                throw new SQLException("Insert updated " + count + " rows");
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error create product", e);
        }
    }

    /**
     * @param productName Get searched products
     * @return
     * @throws DaoException
     */
    public List<Product> getSearchedProducts(String productName) throws DaoException {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_SEARCHED_PRODUCT);
            String newWord = "'%";
            newWord += productName;
            newWord += "%'";
            System.out.println(newWord);
            pstmt.setString(1, productName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong(ID));
                product.setName(rs.getString(NAME));
                product.setDescription(rs.getString(DESCRIPTION));
                product.setPrice(rs.getLong(PRICE));
                product.setImage_url(rs.getString(IMAGE_URL));
                product.setUserId(rs.getLong(ID_USER));
                products.add(product);
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error get searched products", e);
        }
        return products;

    }

    /**
     * @param productId Delete product
     * @throws DaoException
     */
    public void deleteProduct(long productId) throws DaoException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setLong(1, productId);
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error("Error delete product", e);
        }
    }

//    public List<Product> findProductsForPagination(int limit, int offset) throws DaoException {
//        List<Product> products = new ArrayList<>();
//        Connection con = null;
//        try {
//            con = ConnectionPool.getConnection();
//            PreparedStatement pstmt = con.prepareStatement(GET_PRODUCTS);
//            pstmt.setInt(1, limit);
//            pstmt.setInt(2, offset);
//            ResultSet rs = pstmt.executeQuery(); //
//            while (rs.next()) {
//                Product product = new Product();
//                product.setId(rs.getInt(ID));
//                product.setName(rs.getString(NAME));
//                product.setDescription(rs.getString(DESCRIPTION));
//                product.setPrice(rs.getDouble(PRICE));
//                product.setImage_url(rs.getString(IMAGE_URL));
//                products.add(product);
//            }
//            pstmt.close();
//            releaseConnection(con);
//        } catch (Exception e) {
//            try {
//                if (con != null)
//                    con.close();
//            } catch (SQLException e2) {
//                LOGGER.error("Error connection", e2);
//            }
//            LOGGER.error("Error get all product", e);
//        }
//        return products;
//    }

    /**
     * Method finds products for pagination on page
     *
     * @param limit
     * @param offset
     * @return products
     * @throws DaoException
     */
    public List<Product> findProductsForPagination(int limit, int offset) throws DaoException {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        try {
            con = ConnectionPool.getConnection();
            PreparedStatement pstmt = con.prepareStatement(GET_PRODUCTS);
            pstmt.setInt(1, limit);
            pstmt.setInt(2, offset);
            ResultSet rs = pstmt.executeQuery(); //
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(ID));
                product.setName(rs.getString(NAME));
                product.setDescription(rs.getString(DESCRIPTION));
                product.setPrice(rs.getDouble(PRICE));
                product.setImage_url(rs.getString(IMAGE_URL));
                products.add(product);
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
                LOGGER.error("Error connection", e2);
            }
            LOGGER.error("Error get all product", e);
        }
        return products;
    }

    /**
     * Method counts size of products for pagination on page
     *
     * @return size
     * @throws DaoException
     */
    public int getProductsSizeForPagination() throws DaoException {
        int size = 0;
        try {
            Connection con = ConnectionPool.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(GET_PRODUCTS_SIZE);
            if (rs.next()) {
                size = rs.getInt(1);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    /**
     * Method finds products for pagination to sort products on page
     *
     * @param limit
     * @param offset
     * @param sortBy
     * @return products
     * @throws DaoException
     */
    public List<Product> findProductsForPaginationAndSort(int limit, int offset, String sortBy) throws DaoException {
        List<Product> products = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt;
        try {
            con = ConnectionPool.getConnection();
            switch (sortBy) {
                case "nameAsc":
                    pstmt = con.prepareStatement(SORT_NAME_ASC);
                    break;
                case "nameDesc":
                    pstmt = con.prepareStatement(SORT_NAME_DESC);
                    break;
                case "lowPrice":
                    pstmt = con.prepareStatement(SORT_LOW_PRICE);
                    break;
                case "highPrice":
                    pstmt = con.prepareStatement(SORT_HIGH_PRICE);
                    break;
                case "capacity0_3":
                    pstmt = con.prepareStatement(SORT_CAP_033_L);
                    break;
                case "capacity0_5":
                    pstmt = con.prepareStatement(SORT_CAP_05_L);
                    break;
                case "capacity0_7":
                    pstmt = con.prepareStatement(SORT_CAP_075_L);
                    break;
                case "capacity1":
                    pstmt = con.prepareStatement(SORT_CAP_1_L);
                    break;
                case "capacity1_5":
                    pstmt = con.prepareStatement(SORT_CAP_1_5_L);
                    break;
                case "capacity2":
                    pstmt = con.prepareStatement(SORT_CAP_2_L);
                    break;
                case "materialPlastic":
                    pstmt = con.prepareStatement(SORT_MAT_PLASTIC);
                    break;
                case "materialGlass":
                    pstmt = con.prepareStatement(SORT_MAT_GLASS);
                    break;
                case "materialMetal":
                    pstmt = con.prepareStatement(SORT_MAT_METAL);
                    break;
                case "all":
                default:
                    pstmt = con.prepareStatement(GET_PRODUCTS);
            }
            pstmt.setInt(1, limit);
            pstmt.setInt(2, offset);
            ResultSet rs = pstmt.executeQuery(); //
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(ID));
                product.setName(rs.getString(NAME));
                product.setDescription(rs.getString(DESCRIPTION));
                product.setPrice(rs.getDouble(PRICE));
                product.setImage_url(rs.getString(IMAGE_URL));
                products.add(product);
            }
            pstmt.close();
            releaseConnection(con);
        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
                LOGGER.error("Error connection", e2);
            }
            LOGGER.error("Error get all product", e);
        }
        return products;
    }

    /**
     * Method counts size of products for pagination to sort products on page
     *
     * @param sortBy
     * @return size
     * @throws DaoException
     */
    public int getProductsSizeForPaginationAndSort(String sortBy) throws DaoException {
        int size = 0;
        try {
            Connection con = ConnectionPool.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            switch (sortBy) {
                case "capacity0_3":
                    rs = stmt.executeQuery(GET_SIZE_CAP_033_L);
                    break;
                case "capacity0_5":
                    rs = stmt.executeQuery(GET_SIZE_CAP_05_L);
                    break;
                case "capacity0_7":
                    rs = stmt.executeQuery(GET_SIZE_CAP_075_L);
                    break;
                case "capacity1":
                    rs = stmt.executeQuery(GET_SIZE_CAP_1_L);
                    break;
                case "capacity1_5":
                    rs = stmt.executeQuery(GET_SIZE_CAP_1_5_L);
                    break;
                case "capacity2":
                    rs = stmt.executeQuery(GET_SIZE_CAP_2_L);
                    break;
                case "materialPlastic":
                    rs = stmt.executeQuery(GET_SIZE_MAT_PLASTIC);
                    break;
                case "materialGlass":
                    rs = stmt.executeQuery(GET_SIZE_MAT_GLASS);
                    break;
                case "materialMetal":
                    rs = stmt.executeQuery(GET_SIZE_MAT_METAL);
                    break;
                case "all":
                default:
                    rs = stmt.executeQuery(GET_PRODUCTS_SIZE);
            }
            if (rs.next()) {
                size = rs.getInt(1);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return size;
    }
}
