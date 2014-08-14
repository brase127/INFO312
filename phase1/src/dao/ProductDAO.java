/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import domain.Product;
import java.util.Collection;

/**
 *
 * @author Kendall Lauren Chin
 */
public interface ProductDAO {
    void save(Product aProduct);
    Collection<Product> getAll();
}
