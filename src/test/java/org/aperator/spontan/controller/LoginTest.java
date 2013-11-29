package org.aperator.spontan.controller;

import org.aperator.spontan.controller.data.LoginRequestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 24/11/13
 * Time: 15:16
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spontanaperator-servlet.xml")
public class LoginTest extends AbstractWebPageTest {

    @Test
    public void loginPageShouldBeReachable() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void loginWithEmptyBodyShouldReturn401() throws Exception {
        callServiceAndExpect401For(new LoginRequestData());
    }


    @Test
    public void loginWithUsernameOnlyShouldReturn401() throws Exception {
        LoginRequestData usernameOnly = new LoginRequestData();
        usernameOnly.setUsername("JUnitUsername");
        callServiceAndExpect401For(usernameOnly);
    }

    @Test
    public void loginWithPasswordOnlyShouldReturn401() throws Exception {
        LoginRequestData passwordOnly = new LoginRequestData();
        passwordOnly.setPassword("JUnitPassword");
        this.callServiceAndExpect401For(passwordOnly);
    }

    @Test
    public void loginWithValidCredentialsShouldWork() throws Exception {
        LoginRequestData loginRequestData = new LoginRequestData();
        loginRequestData.setUsername("JUnitUsername");
        loginRequestData.setPassword("JUnitPassword");
        mockMvc.perform(post("/login")
                .param("username", "JUnitUsername")
                .param("password", "JUnitPassword"))

                .andExpect(status().isOk());
    }

    private void callServiceAndExpect401For(LoginRequestData loginRequestData) throws Exception {
        mockMvc.perform(post("/login")
                .param("username", loginRequestData.getUsername())
                .param("password", loginRequestData.getPassword()))

                .andExpect(status().isUnauthorized());
    }
}
