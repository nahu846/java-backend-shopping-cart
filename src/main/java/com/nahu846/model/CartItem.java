package com.nahu846.model;

import lombok.*;

import java.math.BigDecimal;

@Data
public class CartItem {

    private Long id;

    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    private Product product;

    private Cart cart;

    public void setTotalPrice() {
        this.totalPrice = this.unitPrice.multiply(new BigDecimal(quantity));
    }
}