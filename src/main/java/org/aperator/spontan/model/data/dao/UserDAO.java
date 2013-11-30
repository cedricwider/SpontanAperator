package org.aperator.spontan.model.data.dao;

import org.aperator.spontan.model.data.User;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 30/11/13
 * Time: 01:31
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {

    public void save(User user);
    public void update(User user);
    public void delete(User user);
    public User findByUsername(String username);
}
