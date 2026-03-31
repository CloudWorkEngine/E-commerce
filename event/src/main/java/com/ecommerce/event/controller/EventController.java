package com.ecommerce.event.controller;

import com.ecommerce.event.enums.Type;
import com.ecommerce.event.model.Event;
import com.ecommerce.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvent();
    }

    @GetMapping("/type={type}")
    public List<Event> getEventsByType(@PathVariable Type type){
        return eventService.getEventsByType(type);
    }

    @GetMapping("/userId={userId}")
    public List<Event> getUserEvents(@PathVariable String userId){
        return eventService.getEventsByUser(userId);
    }

    @GetMapping("/id={eventId}")
    public Event getEventById(@PathVariable String eventId){
        return eventService.getEventsById(eventId);
    }
}
