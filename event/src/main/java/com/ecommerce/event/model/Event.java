package com.ecommerce.event.model;

import com.ecommerce.event.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="events")
@Data
public class Event {

    @Id
    @Column(name="event_id")
    private String id;

    @Column(name="user_id")
    private String user;

    @Column(name="product_id")
    private String product;

    @Column(name="event_type")
    @Enumerated(EnumType.STRING)
    private Type eventType;

    @Column(name="event_timestamp")
    private LocalDateTime eventTime;
}
