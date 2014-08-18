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
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Kendall Lauren Chin
 */
public class ProductCollectionDAO implements ProductDAO {

    private static final TreeSet<Product> products = new TreeSet<>();
    private static final Set categories = new HashSet();
    private static final SortedMap<Integer, Product> byId = new TreeMap<>();

    @Override
    public void save(Product aProduct) {
        products.add(aProduct);
        categories.add(aProduct.getCategory());
        byId.put(aProduct.getId(), aProduct);
    }

    @Override
    public Collection<Product> getAll() {
        return products;
    }

    @Override
    public Collection<Product> getCategories() {
        return categories;
    }

    @Override
    public void delete(Product aProduct) {
        products.remove(aProduct);
        categories.remove(aProduct.getCategory());
    }

    @Override
    public Product getById(Integer aId) {
        return byId.get(aId);
    }

}
