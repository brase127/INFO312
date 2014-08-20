/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author chike189
 */
public class ProductJdbcDAO implements ProductDAO {

    @Override
    public void save(Product aProduct) {
        String sql = "merge into products (id, name, description, category, price, quantity) values (?,?,?,?,?,?)";
        try (
                // get connection to database
                Connection dbCon = JdbcConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setInt(1, aProduct.getId());
            stmt.setString(2, aProduct.getName());
            stmt.setString(3, aProduct.getDescription());
            stmt.setString(4, aProduct.getCategory());
            stmt.setDouble(5, aProduct.getPrice());
            stmt.setInt(6, aProduct.getQuantity());
            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Product aProduct) {
        String sql = "delete from products where id = (?)";

        try (
                // get connection to database
                Connection dbCon = JdbcConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
            // copy the data from the student domain object into the SQL parameters
            stmt.setInt(1, aProduct.getId());

            // execute the statement
            stmt.executeUpdate();
        } catch (SQLException ex) { // we are forced to catch SQLException
            // don't let the SQLException leak from our DAO encapsulation
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Collection<Product> getAll() {
        String sql = "select * from products order by id";
        try (
                // get a connection to the database
                Connection dbCon = JdbcConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();
// Create a collection for holding the student we get from the query.
// We are using a List in order to preserve the order in which
// the data was returned from the query.
            TreeSet<Product> products;
            products = new TreeSet<>();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String category = rs.getString("category");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
// use the data to create a student object
                Product s = new Product(id, name, description, category, price, quantity);
// and put it in the collection
                products.add(s);
            }
            return products;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Collection<String> getCategories() {
        String sql = "select category from products order by category";
        try (
                // get a connection to the database
                Connection dbCon = JdbcConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();
// Create a collection for holding the student we get from the query.
// We are using a List in order to preserve the order in which
// the data was returned from the query.
            Set categories = new HashSet();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query

                String category = rs.getString("category");
// use the data to create a student object

// and put it in the collection
                categories.add(category);
            }
            return categories;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Product getById(Integer aId) {
        String sql = "select * from products where id = " + aId + ";";
        try (
                // get a connection to the database
                Connection dbCon = JdbcConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String category = rs.getString("category");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
// use the data to create a student object
                Product s = new Product(id, name, description, category, price, quantity);
// and put it in the collection
                return s;
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Collection<Product> getByCategories(String aCategory) {
        String sql = "select * from products where category = '" + aCategory + "' order by id;";
        try (
                // get a connection to the database
                Connection dbCon = JdbcConnection.getConnection();
                // create the statement
                PreparedStatement stmt = dbCon.prepareStatement(sql);) {
// execute the query
            ResultSet rs = stmt.executeQuery();

            Set products = new HashSet();
            // iterate through the query results
            while (rs.next()) {
// get the data out of the query
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String category = rs.getString("category");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
// use the data to create a student object
                Product s = new Product(id, name, description, category, price, quantity);
// and put it in the collection
                products.add(s);
            }
            return products;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
