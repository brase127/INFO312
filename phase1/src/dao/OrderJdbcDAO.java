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
            con = ShoppingConnection.getConnection();

            insertOrderStmt = con.prepareStatement(
                    "insert into orders values (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            insertOrderItemStmt = con.prepareStatement(
                    "insert into orderitems values (?, ?, ?)");

            updateProductStmt = con.prepareStatement(
                    "update Products set quantity='(?)' where quantity='(?)'");

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
            insertOrderStmt.setTimestamp(2, timestamp);
            insertOrderStmt.setString(3, username);

            // get the auto-generated order ID from the database
            ResultSet rs = insertOrderStmt.getGeneratedKeys();

            Integer orderId = null;

            if (rs.next()) {
                orderId = rs.getInt(1);
            } else {
                throw new DAOException("Problem getting generated Order ID");
            }
            insertOrderStmt.setInt(1, orderId);
            // -- save the order items --
            Collection<OrderItem> items = order.getItems();

            // ****
            // write code here that iterates through the order items and saves
            // them using the insertOrderItemStmt prepared statement.
            // ****
            for (OrderItem item : items) {
                insertOrderItemStmt.setInt(1, item.getQuantityPurchased());

                Product product = item.getaProduct();
                Integer productId = product.getId();
                insertOrderItemStmt.setInt(2, productId);

                Order orderNew = item.getAnOrder();
                Integer orderNewId = orderNew.getOrderId();
                insertOrderItemStmt.setInt(3, orderNewId);

            }

            // -- update the product quantities --
            for (OrderItem item : items) {

                Product product = item.getaProduct();
                Integer productId = product.getId();
                Product originalProduct = new ProductJdbcDAO().getById(productId);
                // *******************************************************************
                // write code here that updates the product quantity using the
                // using the updateProductStmt prepared statement.
                // *******************************************************************
                Integer productQuantity = product.getQuantity();
                Integer originalQuantity = originalProduct.getQuantity();
                Integer newQuantity = originalQuantity - productQuantity;
                updateProductStmt.setInt(1, newQuantity);
                updateProductStmt.setInt(2, originalQuantity);
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
