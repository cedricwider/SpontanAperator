package org.aperator.spontan.controller.rest;

import org.aperator.spontan.controller.AbstractWebPageTest;
import org.aperator.spontan.data.TestDataGenerator;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.aperator.spontan.model.data.manager.impl.SecurePasswordEncryptor;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 06/04/14
 * Time: 19:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = "file:src/test/resources/JUnit_Spring.xml")
@Ignore("This test can't be run together with the other tests...!") // TODO: ced - make this work, please
public class RestResourcesTest extends AbstractWebPageTest {

    private static final String USER_URL = "/rest/user";

    @Autowired UserDAO userDAO;
    @Autowired SecurePasswordEncryptor passwordEncryptor;

    private static User USER;

    @Before
    public void storeUserInDatabase() {
        if (USER == null) {
            User user = userDAO.findByUsername("ValudJUnitUsername");
            if (user != null) {
                USER = user;
            } else {
                USER = TestDataGenerator.user("ValidJUnitUsername");
                USER.getPassword().setPasswordHash(passwordEncryptor.encrypt("JUnitPassword"));
                userDAO.save(USER);
            }
        }
    }


    @Test
    @Ignore("Wait until Spring Security is implemented")
    public void noLoginNoAnswer() throws Exception {
        mockMvc.perform(get(USER_URL+ "/" + USER.getId()))
                .andExpect(status().isForbidden());
    }

    @Test
    public void shouldReturnCurrentUser() throws Exception {
        doLogin();
        mockMvc.perform(get(USER_URL))
                .andExpect(status().isOk());
    }

    @Test
    public void userShouldBeAbleToUpdateHimself() throws Exception {
        //given
        doLogin();
        USER.setNickName("ChangedNickname");
        String userAsString = new ObjectMapper().writeValueAsString(USER);
        System.out.println(userAsString);

        // when
        mockMvc.perform(put(USER_URL + "/" + USER.getId()).content(userAsString))

        // then
        .andExpect(status().isOk());
        assertEquals("ChangedNickname", userDAO.findById(USER.getId()).getNickName());

    }

    @Test
    public void userShouldBeAbleToDeleteHimself() throws Exception {
        // given
        doLogin();
        Long userId = USER.getId();

        // when
        mockMvc.perform(delete(USER_URL + "/" + userId))

        // then
        .andExpect(status().isOk());
        assertNull(userDAO.findById(userId));
    }

    private void doLogin() throws Exception {
        mockMvc.perform(post("/user/login")
                .param("username", USER.getUsername())
                .param("password", "JUnitPassword"))
                .andExpect(status().isOk());
    }

}
