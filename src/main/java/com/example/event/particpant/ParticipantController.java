package com.example.event.particpant;

import com.example.event.event.Event;
import com.example.event.event.EventRepository;
import com.example.event.user.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    ParticipantRepository participantRepository;
    @Autowired
    EventRepository eventRepository;

    @GetMapping
    List<Participant> getParticipants() { return participantRepository.findAll(); }

    @GetMapping("/{id}")
    Participant getParticipant(@PathVariable long id) { return participantRepository.findById(id).get(); }

    @Transactional
    @PostMapping
    Participant createParticipant(@RequestBody Participant participant) { return participantRepository.save(participant); }

    @PutMapping("/{eventId}/participant/{participantId}")
    Participant assignParticipantToEvent(
            @PathVariable long eventId,
            @PathVariable long participantId
    ) {
        Participant participant = participantRepository.findById(participantId).get();
        Event event = eventRepository.findById(eventId).get();

        participant.assignEvent(event);

        return participantRepository.save(participant);
    }

    @Transactional
    @DeleteMapping("/{parid}")
    void deleteParticipant(@PathVariable long parid) {
        participantRepository.deleteById(parid);
    }
}


