package com.ecommerce.cart.repository;


import com.ecommerce.cart.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CartRepository {

    private final Map<String, Cart> carts = new ConcurrentHashMap<>();

    public Cart getOrCreate(String userId) {
        return carts.computeIfAbsent(userId, Cart::new);
    }

    public void save(String userId, Cart cart) {
        carts.put(userId, cart);
    }

    public void clearCart(String userId) {
        carts.remove(userId);
    }
}