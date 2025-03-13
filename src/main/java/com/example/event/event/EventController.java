package com.example.event.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    List<Event> getEvents() { return eventRepository.findAll();}

    @GetMapping("/{Eventid}")
    Event getEventById(@PathVariable long Eventid) { return eventRepository.findById(Eventid).get();}

    @PostMapping
    Event addEvent(@RequestBody Event event) { return eventRepository.save(event);}

    @DeleteMapping
    void deleteEvent(@RequestBody Event event) { eventRepository.delete(event);}
}
