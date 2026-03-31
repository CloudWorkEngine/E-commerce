package com.ecommerce.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private String user;
    private List<CartItem> items = new ArrayList<>();

    public Cart(String userId) {
        this.user = userId;
    }
}
