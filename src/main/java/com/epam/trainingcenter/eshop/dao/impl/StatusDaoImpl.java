package com.epam.trainingcenter.eshop.dao.impl;

import com.epam.trainingcenter.eshop.connection.ConnectionPool;
import com.epam.trainingcenter.eshop.dao.interfaces.StatusDao;
import com.epam.trainingcenter.eshop.exeption.DaoException;
import com.epam.trainingcenter.eshop.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.trainingcenter.eshop.constant.ConstantNames.ID;
import static com.epam.trainingcenter.eshop.constant.ConstantNames.STATUS_NAME;

/**
 * @author sburch
 * @version 1.0
 */

public class StatusDaoImpl extends ConnectionPool implements StatusDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    private static final String SELECT_ID_BY_STATUS_NAME = "SELECT id FROM ordering_status WHERE status_name = ? ";
    private static final String SELECT_STATUS_FROM_ORDER = "SELECT eshop.ordering_status.status_name, eshop.ordering_status.id FROM eshop.ordering_status " +
            "INNER JOIN eshop.order ON eshop.ordering_status.id = eshop.order.status WHERE eshop.order.id = ?";
    private static final String SELECT_ALL = "SELECT * FROM ordering_status";

    /**
     * Get id by status name
     *
     * @param statusName
     * @return id
     * @throws DaoException
     */
    @Override
    public Long getIdByStatusName(String statusName) throws DaoException {
        long id = 0;
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_ID_BY_STATUS_NAME);
            pstmt.setString(1, statusName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id = rs.getLong("id");
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
            LOGGER.error("Error get id by status name", e);
        }
        return id;
    }

    /**
     * Gets all statuses
     *
     * @return statuses
     */
    @Override
    public List<Status> getAllStatuses() {
        List<Status> statuses = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Status status = new Status();
                status.setId(rs.getLong(ID));
                status.setStatusName(rs.getString(STATUS_NAME));
                statuses.add(status);
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
            LOGGER.error("Error get all statuses", e);
        }
        return statuses;
    }

    /**
     * Gets user status by order id
     *
     * @param orderId
     * @return status
     * @throws DaoException
     */
    @Override
    public Status getStatusByOrderId(Long orderId) throws DaoException {
        Status status = new Status();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_STATUS_FROM_ORDER);
            pstmt.setLong(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                status.setId(rs.getLong(ID));
                status.setStatusName(rs.getString(STATUS_NAME));
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
            LOGGER.error("Error get status by order id", e);
        }
        return status;
    }
}
