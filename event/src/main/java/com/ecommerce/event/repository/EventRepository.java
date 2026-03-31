package com.ecommerce.event.repository;

import com.ecommerce.event.enums.Type;
import com.ecommerce.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    public List<Event> findEventByUser(String userId);
    public List<Event> findEventByEventType(Type eventType);
}
