package org.aperator.spontan.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * User: cedster
 * Date: 01/12/13
 * Time: 20:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = "file:src/test/resources/JUnit_Spring.xml")
public class RegisterUserTest extends AbstractWebPageTest {

    @Test
    public void registerUserWithCorrectDataShouldReturnOk() throws Exception {
        mockMvc.perform(post("/user/new")
            .param("username", "JUnitUsername")
            .param("password", "JUnitPassword")
            .param("passwordConfirmation", "JUnitPassword")
            .param("nickname", "JUnitNickname")
            .param("phonenumber", "JUnitPhonenumber")
            .param("email", "JUnitEmail"))
        .andExpect(status().isOk());
    }
}
