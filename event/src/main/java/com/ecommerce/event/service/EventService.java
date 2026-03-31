package com.ecommerce.event.service;

import com.ecommerce.event.enums.Type;
import com.ecommerce.event.model.Event;
import com.ecommerce.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvent(){
        List<Event> events = eventRepository.findAll();
        if(events.isEmpty()) return null;
        return events;
    }

    public List<Event> getEventsByUser(String userId){
        List<Event> userEvents = eventRepository.findEventByUser(userId);
        if(userEvents.isEmpty()) return null;
        return userEvents;
    }

    public Event getEventsById(String eventId){
        Optional<Event> event = eventRepository.findById(eventId);
        return event.orElse(null);
    }

    public List<Event> getEventsByType(Type eventType){
        List<Event> events = eventRepository.findEventByEventType(eventType);
        if(events.isEmpty()) return null;
        return events;
    }
}
