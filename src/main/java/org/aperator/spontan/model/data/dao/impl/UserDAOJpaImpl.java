package org.aperator.spontan.model.data.dao.impl;

import org.apache.commons.collections.CollectionUtils;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.UserDAO;
import org.aperator.spontan.model.data.manager.impl.GenericDaoJpa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 30/11/13
 * Time: 01:34
 * To change this template use File | Settings | File Templates.
 */
@Repository("userDao")
public class UserDAOJpaImpl extends GenericDaoJpa<User> implements UserDAO {

    public UserDAOJpaImpl() {
        super(User.class);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        User user = null;
        String queryString = "from User as u where u.username = :username";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("username", username);
        List<User> resultList = query.getResultList();
        if (!CollectionUtils.isEmpty(resultList)) {
            user = resultList.get(0);
        }
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByCommunityId(Long communityId) {
        throw new IllegalStateException("Method not implemented yet");
    }
}
