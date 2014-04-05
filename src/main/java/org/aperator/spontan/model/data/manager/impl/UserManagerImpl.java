package org.aperator.spontan.model.data.manager.impl;

import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.PasswordDAO;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.aperator.spontan.model.data.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: cedster
 * Date: 30/11/13
 * Time: 01:32
 */
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordDAO passwordDAO;

    @Override
    public void create(User user) {
        this.userDAO.save(user);
    }

    @Override
    public void update(User user) {
        this.userDAO.update(user);
    }

    @Override
    public void delete(User user) {
        this.userDAO.delete(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = this.userDAO.findByUsername(username);
        return user;
    }

    @Override
    public User findByUserId(Long ownerId) {
        return this.userDAO.findById(ownerId);
    }

    @Override
    public List<User> findByCommunityId(Long communityId) {
        return this.userDAO.findByCommunityId(communityId);
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setPasswordDAO(PasswordDAO passwordDAO) {
        this.passwordDAO = passwordDAO;
    }
}
