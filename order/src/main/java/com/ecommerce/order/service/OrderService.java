package com.ecommerce.order.service;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(String id){
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    public List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        if(orders.isEmpty()) return null;
        return orders;
    }

    public List<Order> getOrdersByUser(String id){
        List<Order> userOrders = orderRepository.findByUser(id);
        if(userOrders.isEmpty()) return null;
        return userOrders;
    }
}
