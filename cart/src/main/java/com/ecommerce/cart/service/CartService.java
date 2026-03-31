package com.ecommerce.cart.service;


import com.ecommerce.cart.model.Cart;
import com.ecommerce.cart.model.CartItem;
import com.ecommerce.cart.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository repo;

    public CartService(CartRepository repo) {
        this.repo = repo;
    }

    public Cart getCart(String userId) {
        return repo.getOrCreate(userId);
    }

    public Cart addItem(String userId, String productId, int quantity) {
        Cart cart = repo.getOrCreate(userId);

        cart.getItems().stream()
                .filter(i -> i.getProduct().equals(productId))
                .findFirst()
                .ifPresentOrElse(
                        i -> i.setQuantity(i.getQuantity() + quantity),
                        () -> cart.getItems().add(new CartItem(productId, quantity))
                );

        repo.save(userId, cart);
        return cart;
    }

    public Cart updateQuantity(String userId, String productId, int quantity) {
        Cart cart = repo.getOrCreate(userId);

        cart.getItems().forEach(i -> {
            if (i.getProduct().equals(productId)) {
                i.setQuantity(quantity);
            }
        });

        repo.save(userId, cart);
        return cart;
    }

    public Cart removeItem(String userId, String productId) {
        Cart cart = repo.getOrCreate(userId);

        cart.getItems().removeIf(i -> i.getProduct().equals(productId));
        repo.save(userId, cart);

        return cart;
    }

    public void clearCart(String userId) {
        repo.clearCart(userId);
    }
}