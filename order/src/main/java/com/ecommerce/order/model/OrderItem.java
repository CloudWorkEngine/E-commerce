package com.ecommerce.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @Column(name="order_item_id")
    private String id;

    @Column(name="order_id")
    private String order;

    @Column(name="product_id")
    private String product;

    @Column(name="user_id")
    private String user;

    private Integer quantity;

    @Column(name="item_price")
    private Double itemPrice;

    @Column(name="item_total")
    private Double itemTotal;
}
