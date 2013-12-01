package org.aperator.spontan.data;

import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.UserManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 30/11/13
 * Time: 02:22
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/resources/JUnit_Spring.xml")
public class DatabaseUserTest {

    public static final String USERNAME = "DatabaseUserTest_Username";
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void crudOperationsShouldBeSupported() {
        UserManager userManager = (UserManager) applicationContext.getBean("userBo");

        User myUser = new User();
        myUser.setPhoneNumber("+41 79 136 75 01");
        myUser.setUsername(USERNAME);
        myUser.setNickName("JUnitNickname");
        Password myPassword = new Password();
        myPassword.setPasswordHash("JUnitPassword");
        myUser.setPassword(myPassword);

        userManager.save(myUser);

        User dbUser = userManager.findByUsername(USERNAME);
        assertNotNull(dbUser);
        assertEquals(myUser.getNickName(), dbUser.getNickName());

        dbUser.setNickName("Updated");
        userManager.update(dbUser);

        User updatedDbUser = userManager.findByUsername(USERNAME);
        assertNotNull(updatedDbUser);
        assertEquals("Updated", updatedDbUser.getNickName());

        userManager.delete(updatedDbUser);
    }
}