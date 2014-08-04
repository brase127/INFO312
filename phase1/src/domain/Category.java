/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author Kendall Lauren Chin
 */
public class Category {
    private String category;

    public Category(String category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
        return category;
    }
    
}
