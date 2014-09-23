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
    private Product aProduct;
    private Order anOrder;

    public OrderItem(Integer quantityPurchased, Product aProduct) {
        this.quantityPurchased = quantityPurchased;
        this.aProduct = aProduct;
    }

    public Integer getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Integer quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public Product getaProduct() {
        return aProduct;
    }

    public void setaProduct(Product aProduct) {
        this.aProduct = aProduct;
    }

    public Order getAnOrder() {
        return anOrder;
    }

    public void setAnOrder(Order anOrder) {
        this.anOrder = anOrder;
    }

    public double getItemTotal() {
        Double price = aProduct.getPrice();
        return price * quantityPurchased;
    }
}
