package org.aperator.spontan.controller.data.mapper;

import org.aperator.spontan.controller.data.EventData;
import org.aperator.spontan.model.data.Event;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.UserDAO;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 11/04/14
 * Time: 17:58
 */
public class EventDataMapper {

    private UserDAO userDAO;

    public EventDataMapper(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Event toEvent(EventData eventdata) {
        if (eventdata == null) return null;

        Event event = new Event();
        event.setId(eventdata.getId());
        event.setOwner(userById(eventdata.getOwnerId()));
        event.setLocation(eventdata.getLocation());
        event.setMotto(eventdata.getMotto());
        event.setDescription(eventdata.getDescription());
        event.setDate(eventdata.getDate());
        for (Long participantId : eventdata.getParticipantIds()) {
            event.addParticipant(userById(participantId));
        }
        return event;
    }

    public EventData fromEvent(Event event) {
        if (event == null) return null;

        EventData data = new EventData();
        data.setId(event.getId());
        data.setDescription(event.getDescription());
        data.setMotto(event.getMotto());
        data.setDate(event.getDate());
        data.setLocation(event.getLocation());
        data.setOwnerId(event.getOwner().getId());
        List<Long> participantIds = new LinkedList<>();
        for (User participant : event.getParticipants()) {
            participantIds.add(participant.getId());
        }
        data.setParticipantIds(participantIds);

        return data;
    }

    public List<EventData> fromEvent(List<Event> events) {
        if (events == null) return null;

        List<EventData> dataList = new LinkedList<>();
        for (Event event : events) {
            dataList.add(fromEvent(event));
        }
        return dataList;
    }

    private User userById(Long id) {
        return userDAO.findById(id);
    }


}
