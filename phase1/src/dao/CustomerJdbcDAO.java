/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.DAOException;
import dao.ShoppingConnection;
import domain.Customer;
import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chike189
 */
public class CustomerJdbcDAO {

    public void save(Customer aCustomer) {
        String sql = "merge into customers (username, name, address, creditCardDetails, password, email) values (?,?,?,?,?,?)";
        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setString(1, aCustomer.getUsername());
            stmt.setString(2, aCustomer.getName());
            stmt.setString(3, aCustomer.getAddress());
            stmt.setString(4, aCustomer.getCreditCardDetails());
            stmt.setString(5, aCustomer.getPassword());
            stmt.setString(6, aCustomer.getEmail());

            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public void delete(Customer aCustomer) {
        String sql = "delete from customers where username = (?);";

        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setString(1, aCustomer.getUsername());

            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public Customer login(String aUsername, String aPassword) {
        String sql = "select * from customers where username = (?) and password = (?)";
        try (
                // get connection to database
                Connection dbCon = ShoppingConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setString(1, aUsername);
            stmt.setString(2, aPassword);

            // execute the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                String username = rs.getString("username");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String creditCardDetails = rs.getString("creditCardDetails");
                String password = rs.getString("password");
                String email = rs.getString("email");
// use the data to create a student object
                Customer c = new Customer(username, name, address, creditCardDetails, password, email);
// and put it in the collection
                return c;
            }
            return null;
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
}
