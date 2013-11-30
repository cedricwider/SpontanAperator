package org.aperator.spontan.model.data.dao;

import org.aperator.spontan.model.data.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 30/11/13
 * Time: 01:34
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

    @Override
    public void save(User user) {
        getHibernateTemplate().save(user);
    }

    @Override
    public void update(User user) {
        getHibernateTemplate().update(user);
    }

    @Override
    public void delete(User user) {
        getHibernateTemplate().delete(user);
    }

    @Override
    public User findByUsername(String username) {
        List list = getHibernateTemplate().find("from User where username=?", username);
        return list.isEmpty() ? null : (User) list.get(0);
    }
}
