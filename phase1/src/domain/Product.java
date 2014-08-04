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
public class Product implements Comparable<Product>{
    private Integer id;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer quantityInStock;

    public Product(Integer id, String name, String description, String category, Double price, Integer quantityInStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return  id + ", " + name + ", " + description + ", " + category + ", " + price + ", " + quantityInStock;
    }

    public int compareTo(Product aProduct) {
        Integer cid = this.getId();
        Integer tid = aProduct.getId();
        return cid.compareTo(tid);
    }
    
    
}
