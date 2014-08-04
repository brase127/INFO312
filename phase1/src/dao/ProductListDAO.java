/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Kendall Lauren Chin
 */
public class ProductListDAO implements ProductDAO {

    private static final TreeSet<Product> products = new TreeSet<Product>();
    private static final Set categories = new HashSet();

    @Override
    public void save(Product aProduct) {
        products.add(aProduct);
        String category = aProduct.getCategory();
        categories.add(category);
    }

    @Override
    public TreeSet getProducts() {
        return products; 
                }

    @Override
    public Set getCategory() {
        return categories;
    }

    @Override
    public void delete(Product aProduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
