package org.aperator.spontan.controller.rest;

import org.aperator.spontan.controller.data.UserData;
import org.aperator.spontan.controller.data.mapper.UserDataMapper;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 06/04/14
 * Time: 19:48
 */
@Controller
@RequestMapping(value = "/rest/user")
public class RestUserResource {

    @Autowired private UserDAO userDAO;
    @Autowired private UserDataMapper mapper;

    @RequestMapping(value = "/{userid}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody UserData getUser(@PathVariable Long userid, HttpSession session) {
        User user = userDAO.findById(userid);
        return mapper.toUserData(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<UserData> getAllUsers() {
        List<User> allUsers = userDAO.getAll();
        return mapper.toUserData(allUsers);
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public @ResponseBody UserData getCurrentUser(HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        return mapper.toUserData(sessionUser);
    }

    @RequestMapping(value="/{userid}", method = RequestMethod.PUT)
    public @ResponseBody UserData updateUser(@PathVariable Long userid, @RequestBody String userAsString) throws IOException {
        UserData userData = new ObjectMapper().readValue(userAsString, UserData.class);
        User userFromDb = userDAO.findById(userid);
        User user = mergeUserFrom(userData, userFromDb);
        return mapper.toUserData(userDAO.update(user));
    }

    @RequestMapping(value = "{userid}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long userid) {
        userDAO.delete(userDAO.findById(userid));
    }

    private User mergeUserFrom(UserData userData, User user) {
        user.setNickName(userData.getNickname());
        user.setFirstname(userData.getFirstname());
        user.setLastname(userData.getLastname());
        user.setEmail(userData.getEmail());
        user.setPhoneNumber(userData.getPhoneNumber());
        return user;
    }

}
