package org.aperator.spontan.model.data.bo;

import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 30/11/13
 * Time: 01:32
 * To change this template use File | Settings | File Templates.
 */
public class UserBOImpl implements UserBO {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void save(User user) {
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
       return this.userDAO.findByUsername(username);
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
