package org.aperator.spontan.model.data.dao;

import org.aperator.spontan.model.data.Event;
import org.aperator.spontan.model.data.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 06/04/14
 * Time: 15:56
 */
public interface EventDAO extends GenericDao<Event> {

    public List<Event> findByOwner(User owner);

    public List<Event> findByParticipant(User participant);
}
