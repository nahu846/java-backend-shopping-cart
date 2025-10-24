package com.nahu846.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private Long id;

    private Order order;

    private Product product;

    private int quantity;
    private BigDecimal price;

    public OrderItem(Order order, Product product, int quantity, BigDecimal price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
