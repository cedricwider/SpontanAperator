package org.aperator.spontan.model.data.manager.impl;

import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.PasswordDAO;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.aperator.spontan.model.data.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void save(User user) {
        this.userDAO.save(user);
        Password password = user.getPassword();
        password.setUserId(user.getUserId());
        this.passwordDAO.save(password);

    }

    @Override
    public void update(User user) {
        this.passwordDAO.update(user.getPassword());
        this.userDAO.update(user);
    }

    @Override
    public void delete(User user) {
        this.passwordDAO.delete(user.getPassword());
        this.userDAO.delete(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = this.userDAO.findByUsername(username);
        if (user != null) {
            user.setPassword(this.passwordDAO.findByUserId(user.getUserId()));
        }
        return user;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setPasswordDAO(PasswordDAO passwordDAO) {
        this.passwordDAO = passwordDAO;
    }
}
