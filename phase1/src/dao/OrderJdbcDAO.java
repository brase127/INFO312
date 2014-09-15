/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Customer;
import domain.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author chike189
 */
public class OrderJdbcDAO {
    public void save(Order anOrder) {
        String sql = "merge into Order (orderId, data, customer) values (?,?,?)";
        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setInt(1, anOrder.getOrderId());
            stmt.setString(2, anOrder.getDate());
            stmt.setString(3, anOrder.getCustomer().toString());
            
            
            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

public void delete(Order anOrder) {
        String sql = "delete from Order where orderId = (?)";

        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setInt(1, anOrder.getOrderId());

            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }
}
