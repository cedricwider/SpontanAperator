package org.aperator.spontan.data;

import org.apache.commons.collections.CollectionUtils;
import org.aperator.spontan.model.data.Event;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.EventDAO;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 06/04/14
 * Time: 15:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/resources/JUnit_Spring.xml")
public class EventDAOTest {

    @Autowired private EventDAO eventDAO;
    @Autowired private UserDAO userDAO;
    private static Event event;

    @Before
    public void prepareDatabase() {
        if (event == null) {
            event = TestDataGenerator.event();
            userDAO.save(event.getOwner());
        }
    }

    @Test
    public void createEventShouldStoreItInDatabase() {
        // when
        Event eventFromDb = eventDAO.findById(event.getId());

        // then
        assertNotNull(eventFromDb);
        assertNotNull(event.getId());
    }

    @Test
    public void eventShouldBeFoundByOwner() {
        // given
        User owner = event.getOwner();

        // when
        List<Event> byOwnerId = eventDAO.findByOwner(owner);

        // then
        assertNotNull(byOwnerId);
        assertTrue(CollectionUtils.isNotEmpty(byOwnerId));
    }

    @Test
    public void eventShouldBeFoundByParticipant() {
        //given
        User participant = event.getParticipants().get(0);

        // when
        List<Event> byParticipant = eventDAO.findByParticipant(participant);

        // then
        assertNotNull(byParticipant);
        assertTrue(CollectionUtils.isNotEmpty(byParticipant));
    }

    @Test
    public void updatesShouldBeReflectedOnDb() {
        // given
        String description = "My brand new Description";

        // when
        event.setDescription(description);
        eventDAO.update(event);
        Event fromDb = eventDAO.findById(event.getId());

        //then
        assertEquals(description, fromDb.getDescription());
    }
}
