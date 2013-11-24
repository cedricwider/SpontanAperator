package org.aperator.spontan.data;

import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.UserManager;
import org.aperator.spontan.model.data.manager.impl.SimpleUserManager;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 24/11/13
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class UserTest {

    @Autowired
    private UserManager userManager;

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

    @Test
    public void noUserIsReturnedWhenNoUsersPresent() {
        SimpleUserManager userManager = new SimpleUserManager();
        List<User> allUsers = userManager.getAllUsers();
        assertNotNull(allUsers);
        assertTrue(allUsers.isEmpty());
    }

    @Test
    @Ignore("Not really working here - Check spring documentation to see how to autowire in test classes")
    public void shouldContainConfiguredUser() {
        List<User> allUsers = this.userManager.getAllUsers();
        User user = allUsers.get(0);
        assertEquals("JUnitUsername", user.getUsername());
        assertEquals("JUnitNickname", user.getNickName());
        assertEquals("JUnitPhonenumber", user.getPhoneNumber());
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
