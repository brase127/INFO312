/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author chike189
 */
public class Order {

    private Integer orderId;
    private String date;
    List<OrderItem> items = new ArrayList();

    public Order(Integer orderId, String data) {
        this.orderId = orderId;
        this.date = date;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
// GET HELP WITH THIS

    public Integer getTotal() {
        return null;
    }

    public Collection<OrderItem> addItem(OrderItem anOrderedItem) {
        items.add(anOrderedItem);
        return items;
    }
}
