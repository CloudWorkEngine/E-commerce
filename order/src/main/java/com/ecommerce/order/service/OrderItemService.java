package com.ecommerce.order.service;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderItem;
import com.ecommerce.order.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getOrderItemsByOrder(String orderId){
        List<OrderItem> orderItems = orderItemRepository.findByOrder(orderId);

        if(orderItems.isEmpty()) return null;

        return orderItems;
    }

    public List<OrderItem> getOrderItemsByUser(String userId){
        List<OrderItem> orderItems = orderItemRepository.findByUser(userId);
        if(orderItems.isEmpty()) return null;
        return orderItems;
    }
}
