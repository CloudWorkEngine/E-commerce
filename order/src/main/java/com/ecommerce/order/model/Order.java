package com.ecommerce.order.model;

import com.ecommerce.order.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Order {

    @Id
    @Column(name="order_id")
    private String id;

    @Column(name="user_id")
    private String user;

    @Column(name="order_date")
    private LocalDateTime orderDate;

    @Column(name="order_status")
    @Enumerated(EnumType.STRING)
    private Status orderStatus;

    @Column(name="total_amount")
    private Double totalAmount;
}
