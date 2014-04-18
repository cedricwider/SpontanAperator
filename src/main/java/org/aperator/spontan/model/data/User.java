package org.aperator.spontan.model.data;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: cedster
 * Date: 24/11/13
 * Time: 15:56
 */
@Entity
public class User implements Serializable {

    private Long id;
    private String username;
    private String nickName;
    private String phoneNumber;
    private Password password;
    private String email;
    private List<Event> events;
    private List<Event> ownedEvents;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "password_id", referencedColumnName = "id")
    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "participants", cascade = CascadeType.ALL)
    public List<Event> getEvents() {
        if (events == null) {
            events = new ArrayList<>();
        }
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) {
        List<Event> eventList = getEvents();
        if (eventList.contains(event)) {
            eventList.remove(event);
        }
        eventList.add(event);
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    public List<Event> getOwnedEvents() {
        if (ownedEvents == null) {
            ownedEvents = new LinkedList<>();
        }
        return ownedEvents;
    }

    public void setOwnedEvents(List<Event> events) {
        this.ownedEvents = events;
    }

    public void addOwnedEvent(Event event) {
        this.ownedEvents.add(event);
        if (event.getOwner() != this) {
            event.setOwner(this);
        }
    }
}
