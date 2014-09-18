/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author chike189
 */
public class Order {

    private Integer orderId;
    private Timestamp date;
    private Customer customer;

    List<OrderItem> items = new ArrayList();

    public Order(Integer orderId, Timestamp date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }
    
    public Order(Customer cust){
        this.customer = cust;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Double getTotal() {
        double result = 0;
        for (OrderItem item : items) {
            result += item.getItemTotal();
        }
        return result;
    }

    public void addItem(OrderItem anOrderedItem) {
        items.add(anOrderedItem);
    }
}
