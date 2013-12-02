package org.aperator.spontan.data;

import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.UserManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * User: cedster
 * Date: 30/11/13
 * Time: 02:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/resources/JUnit_Spring.xml")
public class DatabaseUserTest {

    @Autowired
    private ApplicationContext applicationContext;
    private UserManager userManager;

    @Before
    public void setUp() {
        this.userManager = (UserManager) applicationContext.getBean("userManager");
    }

    @Test
    public void createUserShouldWork() {
        String username = "JUnit_CreateUser_Username";
        createUserInDatabaseWithUsername(username);

        User dbUser = userManager.findByUsername(username);
        assertNotNull(dbUser);
        assertNotNull(dbUser.getUserId());
        assertEquals(username, dbUser.getUsername());
    }

    @Test
    public void updateUserShouldWork() {
        String username = "JUnit_UpdateUser_Username";
        createUserInDatabaseWithUsername(username);
        User user = this.userManager.findByUsername(username);
        user.setNickName("updated");
        this.userManager.update(user);

        user = this.userManager.findByUsername(username);
        assertEquals("updated", user.getNickName());
    }

    @Test
    public void deleteUserShouldWork() {
        String username = "JUnit_DeleteUser_Username";
        createUserInDatabaseWithUsername(username);

        User user = this.userManager.findByUsername(username);
        this.userManager.delete(user);

        assertNull(this.userManager.findByUsername(username));
    }

    private void createUserInDatabaseWithUsername(String username) {
        User myUser = new User();
        myUser.setPhoneNumber("+41 79 136 75 01");
        myUser.setUsername(username);
        myUser.setNickName("JUnitNickname");
        Password myPassword = new Password();
        myPassword.setPasswordHash("JUnitPassword");
        myUser.setPassword(myPassword);
        userManager.create(myUser);
    }
}
