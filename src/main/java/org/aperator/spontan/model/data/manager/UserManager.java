package org.aperator.spontan.model.data.manager;

import org.aperator.spontan.model.data.User;

/**
 * User: cedster
 * Date: 30/11/13
 * Time: 01:27
 */
public interface UserManager {

    public void create(User user);
    public User findByUsername(String username);
    public void update(User user);
    public void delete(User user);
}
