package org.aperator.spontan.model.data.dao;

import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.impl.GenericDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 30/11/13
 * Time: 01:31
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO extends GenericDao<User> {

    public User findByUsername(String username);
    public List<User> findByCommunityId(Long communityId);
}
