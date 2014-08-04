/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kendall Lauren Chin
 */
public class ProductListDAO implements ProductDAO{
    private static ArrayList students = new ArrayList();

    @Override
    public void save(Product aProduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
