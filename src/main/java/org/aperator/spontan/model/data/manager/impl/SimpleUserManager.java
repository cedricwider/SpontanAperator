package org.aperator.spontan.model.data.manager.impl;

import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 24/11/13
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public class SimpleUserManager implements UserManager {

    @Autowired
    private List<User> users;

    @Override
    public List<User> getAllUsers() {
        if (users == null) {
            users = new LinkedList<User>();
        }
        return users;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        for (User tmpUser : this.users) {
            if (tmpUser.getUsername().equals(username)) {
                user = tmpUser;
                break;
            }
        }
        return user;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
