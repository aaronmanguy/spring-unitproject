package com.example.event.event;

import com.example.event.particpant.Participant;
import com.example.event.user.Users;
import com.example.event.user.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    List<Event> getEvents() { return eventRepository.findAll();}

    @GetMapping("/{Eventid}")
    Event getEventById(@PathVariable long Eventid) { return eventRepository.findById(Eventid).get();}

    @PostMapping
    Event addEvent(@RequestBody Event event) { return eventRepository.save(event);}

    @PutMapping("/{userid}/event/{eventid}")
    Users addEventtoUser(
            @PathVariable Long eventid,
            @PathVariable Long userid
    ) {
        Event event = eventRepository.findById(eventid).get();
            Users user = usersRepository.findById(userid).get();
            user.addeventtouser(event);


        return usersRepository.save(user);
    }

    @DeleteMapping("/{eventid}")
    void deleteEventById(@PathVariable long Eventid) { eventRepository.deleteById(Eventid);}

    }

