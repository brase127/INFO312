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
import utils.MultiMap;

/**
 *
 * @author Kendall Lauren Chin
 */
public class ProductCollectionDAO implements ProductDAO {

    private static final TreeSet<Product> products = new TreeSet<>();
    private static final Set categories = new HashSet();
    private static final SortedMap<Integer, Product> byId = new TreeMap<>();
        private static final MultiMap<String, Product> map = new MultiMap<>();


    @Override
    public void save(Product aProduct) {
        products.add(aProduct);
        categories.add(aProduct.getCategory());
        byId.put(aProduct.getId(), aProduct);
        map.put(aProduct.getCategory(), aProduct);
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
        map.remove(aProduct.getCategory(), aProduct);
        byId.remove(aProduct.getId());
    }

    @Override
    public Product getById(Integer aId) {
        return byId.get(aId);
    }

    @Override
    public Collection<Product> getByCategories(String aCategory) {
        return map.get(aCategory);
        }

}
