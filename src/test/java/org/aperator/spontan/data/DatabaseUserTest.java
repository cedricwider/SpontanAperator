package org.aperator.spontan.data;

import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.*;

/**
 * User: cedster
 * Date: 30/11/13
 * Time: 02:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/resources/JUnit_Spring.xml")
public class DatabaseUserTest {

    @Autowired private ApplicationContext applicationContext;
    @Autowired private UserDAO userDAO;


    @Test
    public void createUserShouldWork() {
        String username = "JUnit_CreateUser_Username";
        createUserInDatabaseWithUsername(username);

        User dbUser = userDAO.findByUsername(username);
        assertNotNull(dbUser);
        assertNotNull(dbUser.getId());
        assertEquals(username, dbUser.getUsername());
    }

    @Test
    public void updateUserShouldWork() {
        String username = "JUnit_UpdateUser_Username";
        createUserInDatabaseWithUsername(username);
        User user = this.userDAO.findByUsername(username);
        user.setNickName("updated");
        this.userDAO.update(user);

        user = this.userDAO.findByUsername(username);
        assertEquals("updated", user.getNickName());
    }

    @Test
    public void deleteUserShouldWork() {
        String username = "JUnit_DeleteUser_Username";
        createUserInDatabaseWithUsername(username);

        User user = this.userDAO.findByUsername(username);
        this.userDAO.delete(user);

        assertNull(this.userDAO.findByUsername(username));
    }

    private void createUserInDatabaseWithUsername(String username) {
        User myUser = TestDataGenerator.user(username);
        userDAO.save(myUser);
    }
}
