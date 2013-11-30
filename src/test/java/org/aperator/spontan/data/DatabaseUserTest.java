package org.aperator.spontan.data;

import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.bo.UserBO;
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
@ContextConfiguration("file:src/main/webapp/WEB-INF/spontanaperator-servlet.xml")
public class DatabaseUserTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void crudOperationsShouldBeSupported() {
        UserBO userBO = (UserBO) applicationContext.getBean("userBo");

        User myUser = new User();
        myUser.setPhoneNumber("+41 79 136 75 01");
        myUser.setUsername("JUnitUsername");
        myUser.setNickName("JUnitNickname");

        userBO.save(myUser);

        User dbUser = userBO.findByUsername("JUnitUsername");
        assertNotNull(dbUser);
        assertEquals(myUser.getNickName(), dbUser.getNickName());

        dbUser.setNickName("Updated");
        userBO.update(dbUser);

        User updatedDbUser = userBO.findByUsername("JUnitUsername");
        assertNotNull(updatedDbUser);
        assertEquals("Updated", updatedDbUser.getNickName());

        userBO.delete(updatedDbUser);
    }
}
