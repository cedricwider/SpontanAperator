package org.aperator.spontan.model.data.dao.impl;

import org.aperator.spontan.model.data.Event;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.EventDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 06/04/14
 * Time: 18:31
 */
@Repository("eventDAO")
public class EventDAOJpaImpl extends GenericDaoJpa<Event> implements EventDAO {

    public EventDAOJpaImpl() {
        super(Event.class);
    }

    @Override
    public List<Event> findByOwner(User owner) {
        String queryString = "from Event as e where e.owner = :owner";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("owner", owner);
        return query.getResultList();
    }

    @Override
    public List<Event> findByParticipant(User participant) {
        String queryString = "from Event as e where :participant in elements(e.participants)";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("participant", participant);
        return query.getResultList();
    }

    @Override
    public void save(Event object) {
        super.save(object);
    }
}
