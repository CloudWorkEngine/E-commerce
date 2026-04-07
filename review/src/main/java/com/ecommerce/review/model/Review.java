package com.ecommerce.review.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="reviews")
public class Review {

    @Id
    @Column(name="review_id")
    private String id;

    @Column(name="order_id")
    private String order;

    @Column(name="product_id")
    private String product;

    @Column(name="user_id")
    private String user;

    private Integer rating;

    @Column(name="review_text")
    private String reviewText;

    @Column(name="review_date")
    private LocalDateTime reviewDate;
}
