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
    private Integer Quantity;

    public Product(Integer id, String name, String description, String category, Double price, Integer Quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.Quantity = Quantity;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
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

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + category;
    }

    @Override
    public int compareTo(Product aProduct) {
        Integer cid = this.getId();
        Integer tid = aProduct.getId();
        return cid.compareTo(tid);
                }

}
