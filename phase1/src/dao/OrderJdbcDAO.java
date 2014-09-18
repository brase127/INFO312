/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import domain.Order;
import domain.OrderItem;
import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author chike189
 */
public class OrderJdbcDAO {

    public void save(Order order) {

        Connection con = null;
        PreparedStatement insertOrderStmt = null;
        PreparedStatement insertOrderItemStmt = null;
        PreparedStatement updateProductStmt = null;

        try {
            con = JdbcConnection.getConnection();

            insertOrderStmt = con.prepareStatement(
                    "**** SQL for saving an Order goes here",
                    Statement.RETURN_GENERATED_KEYS);

            insertOrderItemStmt = con.prepareStatement(
                    "**** SQL for saving an Order Item goes here");

            updateProductStmt = con.prepareStatement(
                    "**** SQL for updating product quantity goes here");

            // since saving and order involves multiple statements across
            // multiple tables we need to control the transaction ourselves
            // to ensure our DB remains consistent
            // turn off auto-commit which effectively starts a new transaction
            con.setAutoCommit(false);

            // -- save the order --
            // convert the order's java.util.Date into a java.sql.Timestamp
            Timestamp timestamp = new Timestamp(order.getDate().getTime());

            // get the customer's username since it is the FK that links order and customer
            String username = order.getCustomer().getUsername();

            // ****
            // write code here that saves the timestamp and username in the order table
            // using the insertOrderStmt prepared statement
            // ****
            // get the auto-generated order ID from the database
            ResultSet rs = insertOrderStmt.getGeneratedKeys();

            Integer orderId = null;

            if (rs.next()) {
                orderId = rs.getInt(1);
            } else {
                throw new DAOException("Problem getting generated Order ID");
            }

            // -- save the order items --
            Collection<OrderItem> items = order.getItems();

		// ****
            // write code here that iterates through the order items and saves
            // them using the insertOrderItemStmt prepared statement.
            // ****
            // -- update the product quantities --
            for (OrderItem item : items) {

                Product product = item.getaProduct();

                // *******************************************************************
                // write code here that updates the product quantity using the
                // using the updateProductStmt prepared statement.
                // *******************************************************************
            }

            // -- commit and clean-up --
            // commit the transaction
            con.commit();

            // turn auto-commit back on
            con.setAutoCommit(true);

            // close the statements and connection
            insertOrderStmt.close();
            insertOrderItemStmt.close();
            updateProductStmt.close();
            con.close();

        } catch (SQLException ex) {

            // something went wrong so rollback the entire transaction
            try {
                con.rollback();
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }

            // and throw an exception to tell the user what happened
            throw new DAOException(ex.getMessage(), ex);
        }
    }
}
