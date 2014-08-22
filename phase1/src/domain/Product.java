/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author Kendall Lauren Chin
 */
public class Product implements Comparable<Product> {

    @NotNull(message = "ID must be provided.")
    @NotNegative(message = "ID must be a postive number.")
    @Length(min = 3, max = 7,
            message = "ID must contain between 3 and 7 digits (inclusive).")
    private Integer id;
    
    @NotNull(message = "Name must be provided.")
    @NotBlank(message = "Name must be provided.")
    @Length(min = 2, message = "Name must contain at least two characters.")
    private String name;
    
    @NotNull(message = "Description must be provided.")
    @NotBlank(message = "Description must be provided.")
    @Length(min = 2, message = "Description must contain at least two characters.")
    private String description;
    
    @NotNull(message = "Category must be provided.")
    @NotBlank(message = "Category must be provided.")
    @Length(min = 2, message = "Category must contain at least two characters.")
    private String category;
    
    @NotNull(message = "Price must be provided.")
    @NotBlank(message = "Price must be provided.")
    @NotNegative(message = "Price must be a postive number.")
    @Length(min = 1, message = "Price must contain at least one digit.")
    private Double price;
    
    @NotNull(message = "Quantity must be provided.")
    @NotBlank(message = "Quantity must be provided.")
    @NotNegative(message = "Quantity must be a postive number.")
    
    @Length(min = 1, message = "Price must contain at least one digit.")
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
        return "ID: " + id + ", Name: " + name + ", Description: " + description + ", Category: " + category + ", Price: " + price + ", Quantity: " + Quantity;
    }

    @Override
    public int compareTo(Product aProduct) {
        Integer cid = this.getId();
        Integer tid = aProduct.getId();
        return cid.compareTo(tid);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
