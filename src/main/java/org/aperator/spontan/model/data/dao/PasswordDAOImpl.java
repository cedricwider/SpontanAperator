package org.aperator.spontan.model.data.dao;

import org.aperator.spontan.model.data.Password;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * User: cedster
 * Date: 01/12/13
 * Time: 18:27
 */
public class PasswordDAOImpl extends HibernateDaoSupport implements PasswordDAO {

    @Override
    public void save(Password password) {
        getHibernateTemplate().save(password);
    }

    @Override
    public Password findByUserId(Long userId) {
        List list = getHibernateTemplate().find("from Password where user_id=?", userId);
        return list.isEmpty() ? null : (Password) list.get(0);
    }

    @Override
    public Password update(Password password) {
        getHibernateTemplate().update(password);
        return password;
    }

    @Override
    public void delete(Password password) {
        getHibernateTemplate().delete(password);
    }
}
