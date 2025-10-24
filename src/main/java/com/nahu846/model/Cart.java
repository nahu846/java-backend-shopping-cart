package com.nahu846.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class Cart {

    private Long id;
    private BigDecimal totalAmount = BigDecimal.ZERO;

    private Set<CartItem> cartItems = new HashSet<>();

    private User user;

    public Cart(long l, CartItem cartItem) {

    }

    public void addItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
        cartItem.setCart(this);
        updateTotalAmount();
    }

    private void updateTotalAmount() {
        this.totalAmount = cartItems.stream().map( cartItem -> {
            BigDecimal unitPrice = cartItem.getUnitPrice();
            if (unitPrice == null)  {
                return BigDecimal.ZERO;
            }
            return unitPrice.multiply(BigDecimal.valueOf(cartItem.getQuantity()));
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void removeItem(CartItem itemToRemove) {
        this.cartItems.remove(itemToRemove);
        itemToRemove.setCart(null);
        updateTotalAmount();
    }



}