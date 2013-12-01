package org.aperator.spontan.data;

import org.aperator.spontan.model.data.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: cedster
 * Date: 24/11/13
 * Time: 15:59
 */
public class UserTest {

    @Test
    public void userShouldHoldOnToHisValues() {
        User user = new User();
        user.setNickName("JUnitNickname");
        user.setUsername("JUnitUsername");
        user.setPhoneNumber("JUnitPhoneNumber");

        assertEquals("JUnitNickname", user.getNickName());
        assertEquals("JUnitUsername", user.getUsername());
        assertEquals("JUnitPhoneNumber", user.getPhoneNumber());
    }
}
