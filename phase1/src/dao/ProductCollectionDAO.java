/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Product;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Kendall Lauren Chin
 */
public class ProductCollectionDAO implements ProductDAO {

    private static final TreeSet<Product> products = new TreeSet<>();
    private static final Set categories = new HashSet();

    @Override
    public void save(Product aProduct) {
        products.add(aProduct);
        categories.add(aProduct.getCategory());
    }

    @Override
    public Collection<Product> getAll() {
        return products;
    }

    @Override
    public Collection<Product> getCategories() {
        return categories;
    }

}
