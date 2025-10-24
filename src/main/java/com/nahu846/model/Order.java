package com.nahu846.model;

import com.nahu846.enums.OrderStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
public class Order {
    private Long id;

    private LocalDate orderDate;
    private BigDecimal totalAmount;

    private OrderStatus orderStatus;

    private Set<OrderItem> orderItems = new HashSet<>();

    private User user;

    public Order(Long id, User user) {
        this.id = id;
        this.user = user;
    }
}
