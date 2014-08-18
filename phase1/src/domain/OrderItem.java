/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author chike189
 */
public class OrderItem {

    private Integer quantityPurchased;

    public OrderItem(Integer quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public Integer getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Integer quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public double getItemTotal(Product aProduct) {
        Double price = aProduct.getPrice();
        return price * quantityPurchased;
    }
}
