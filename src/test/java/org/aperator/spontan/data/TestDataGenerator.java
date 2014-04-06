package org.aperator.spontan.data;

import org.aperator.spontan.model.data.Event;
import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.User;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 06/04/14
 * Time: 01:50
 */
public class TestDataGenerator {
    public static User user(String username) {
        User myUser = new User();
        myUser.setEmail(username+"@unit.com");
        myUser.setPhoneNumber("+41 79 136 75 01");
        myUser.setUsername(username);
        myUser.setNickName("JUnitNickname");
        Password myPassword = new Password();
        myPassword.setPasswordHash("JUnitPassword");
        myUser.setPassword(myPassword);
        return myUser;
    }

    public static Event event() {
        Event event = new Event();
        event.setOwner(user("Owner"));
        List<User> participants = new LinkedList<User>();
        for (int i = 0; i < 10; i++) {
            participants.add(user("Participant" + i));
        }
        event.setParticipants(participants);
        event.setDate(new Date());
        event.setDescription("JUnit_Description");
        event.setLocation("JUnit_Location");
        event.setMotto("JUnit_Motto");
        return event;
    }
}
