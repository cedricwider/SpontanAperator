package org.aperator.spontan.model.data.manager;

import org.aperator.spontan.model.data.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 24/11/13
 * Time: 16:06
 * To change this template use File | Settings | File Templates.
 */
public interface UserManager {

    public List<User> getAllUsers();

    public User getUserByUsername(String username);
}
