package org.aperator.spontan.model.data.dao;

import org.aperator.spontan.model.data.Community;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 14/12/13
 * Time: 00:36
 */
public class CommunityDAOImpl  extends HibernateDaoSupport implements CommunityDAO {

    @Override
    public void save(Community community) {
        getHibernateTemplate().save(community);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Community> findByOwnerId(Long userId) {
        List<Community> results = new LinkedList<Community>();
        List list = getHibernateTemplate().find("from Community where owner=?", userId);
        results.addAll(list);
        return results;
    }

    @Override
    public Community findByOwnerIdAndName(Long userId, String name) {
        List list = getHibernateTemplate().find("from Community where owner=? and name=?", userId, name);
        return list.isEmpty() ? null : (Community) list.get(0);
    }

    @Override
    public Community update(Community community) {
        getHibernateTemplate().update(community);
        return community;
    }

    @Override
    public void delete(Community community) {
        getHibernateTemplate().delete(community);
    }
}
