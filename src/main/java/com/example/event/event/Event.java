package com.example.event.event;

import com.example.event.particpant.Participant;
import com.example.event.user.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long userId1;
    private String eventname;
    private String description;


    @JsonIgnore
    @ManyToMany(mappedBy = "UserEvent")
    private Set<Users> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId1() {
        return userId1;
    }

    public void setUserId1(long userId1) {
        this.userId1 = userId1;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "event")
    private Set<Participant> participant;

    public void setParticipant(Set<Participant> participant) {this.participant = participant;}
    public void addParticipant(Participant participant) {this.participant.add(participant);}

    public Set<Participant> getParticipant() {return participant;}

}
