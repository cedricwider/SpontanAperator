package org.aperator.spontan.controller.rest;

import com.sun.servicetag.UnauthorizedAccessException;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;

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


    @RequestMapping(value = "/{userid}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUser(@PathVariable Long userid, HttpSession session) {
        if ( session.getAttribute("user") == null ) {
            throw new UnauthorizedAccessException("Please log in first");
        }
        return userDAO.findById(userid);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }

    @RequestMapping(value="/{userid}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@PathVariable Long userid, @RequestBody String userAsString) throws IOException {
        User user = new ObjectMapper().readValue(userAsString, User.class);
        User userFromDb = userDAO.findById(userid);
        user = mergeUserFrom(user, userFromDb);
        return userDAO.update(user);
    }

    @RequestMapping(value = "{userid}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long userid) {
        userDAO.delete(userDAO.findById(userid));
    }

    private User mergeUserFrom(User fromUser, User toUser) {
        toUser.setNickName(fromUser.getNickName());
        toUser.setEmail(fromUser.getEmail());
        toUser.setPhoneNumber(fromUser.getPhoneNumber());
        toUser.setUsername(fromUser.getUsername());
        return toUser;
    }

}
