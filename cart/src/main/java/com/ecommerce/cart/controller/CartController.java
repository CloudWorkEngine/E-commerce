package com.ecommerce.cart.controller;

import com.ecommerce.cart.model.Cart;
import com.ecommerce.cart.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    // GET CART
    @GetMapping("/user={userId}")
    public Cart getCart(@PathVariable String userId) {
        return service.getCart(userId);
    }

    // ADD ITEM
    @PostMapping("/{userId}/add")
    public Cart addItem(
            @PathVariable String userId,
            @RequestParam String productId,
            @RequestParam int quantity
    ) {
        return service.addItem(userId, productId, quantity);
    }

    // UPDATE QUANTITY
    @PutMapping("/{userId}/update")
    public Cart updateQuantity(
            @PathVariable String userId,
            @RequestParam String productId,
            @RequestParam int quantity
    ) {
        return service.updateQuantity(userId, productId, quantity);
    }

    // REMOVE ITEM
    @DeleteMapping("/{userId}/remove")
    public Cart removeItem(
            @PathVariable String userId,
            @RequestParam String productId
    ) {
        return service.removeItem(userId, productId);
    }

    // CLEAR CART
    @DeleteMapping("/{userId}/clear")
    public void clearCart(@PathVariable String userId) {
        service.clearCart(userId);
    }
}
