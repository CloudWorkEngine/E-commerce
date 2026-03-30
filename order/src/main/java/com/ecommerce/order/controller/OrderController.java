package com.ecommerce.order.controller;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderItem;
import com.ecommerce.order.service.OrderItemService;
import com.ecommerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable String orderId){
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getUserOrders(@PathVariable String userId){
        return orderService.getOrdersByUser(userId);
    }

    @GetMapping("/itemsByOrder/{orderId}")
    public List<OrderItem> getOrderItemsByOrder(@PathVariable String orderId){
        return orderItemService.getOrderItemsByOrder(orderId);
    }

    @GetMapping("/itemsByUser/{userId}")
    public List<OrderItem> getOrderItemsByUser(@PathVariable String userId){
        return orderItemService.getOrderItemsByUser(userId);
    }
}
