package org.aperator.spontan.controller.rest;

import org.apache.log4j.Logger;
import org.aperator.spontan.controller.data.EventData;
import org.aperator.spontan.controller.data.mapper.EventDataMapper;
import org.aperator.spontan.model.data.Event;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.EventDAO;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 10/04/14
 * Time: 22:00
 */
@Controller
@RequestMapping(value = "/rest/event")
public class RestEventResource {

    private static final Logger LOGGER = Logger.getLogger(RestEventResource.class.getName());

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private EventDataMapper mapper;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<EventData> getAllEvents() {
        List<Event> events = eventDAO.getAll();
        return mapper.fromEvent(events);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody EventData getEventById(Long id) {
        return mapper.fromEvent(eventDAO.findById(id));
    }

    @RequestMapping(value = "/q",
            params = {"owner={ownerId}"},
            method = RequestMethod.GET)
    public @ResponseBody List<EventData> queryEventsByOwnerId(@PathVariable Long ownerId) {
        User owner = userDAO.findById(ownerId);
        List<Event> events = eventDAO.findByOwner(owner);
        return mapper.fromEvent(events);
    }

    @RequestMapping(value = "/q",
            params = {"participant={participantId}"},
            method = RequestMethod.GET)
    public @ResponseBody List<EventData> queryEventsByParticipantId(@PathVariable Long participantId) {
        User participant = userDAO.findById(participantId);
        List<Event> events = eventDAO.findByParticipant(participant);
        return mapper.fromEvent(events);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody EventData createEvent(@RequestBody String eventAsString) throws IOException {
        LOGGER.debug(String.format("POST-Data: %s", eventAsString));
        EventData eventData = new ObjectMapper().readValue(eventAsString, EventData.class);
        Event event = mapper.toEvent(eventData);
        // eventDAO.save(event);
        userDAO.save(event.getOwner());
        return mapper.fromEvent(event);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody EventData updateEvent(@PathVariable Long id, @RequestBody String eventAsString) throws IOException {
        LOGGER.debug(String.format("POST-Data: %s", eventAsString));
        EventData eventData = new ObjectMapper().readValue(eventAsString, EventData.class);
        Event event = mapper.toEvent(eventData);
        if (!id.equals(event.getId())) {
            throw new IllegalArgumentException("Can't change event's id");
        }

        eventDAO.update(event);
        return mapper.fromEvent(event);
    }
}
