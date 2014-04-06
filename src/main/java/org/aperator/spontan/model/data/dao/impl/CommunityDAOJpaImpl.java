package org.aperator.spontan.model.data.dao.impl;

import org.aperator.spontan.model.data.Community;
import org.aperator.spontan.model.data.dao.CommunityDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 03/04/14
 * Time: 23:33
 */
@Repository("CommunityDAO")
public class CommunityDAOJpaImpl extends GenericDaoJpa<Community> implements CommunityDAO {

    public CommunityDAOJpaImpl() {
        super(Community.class);
    }

    @Override
    public List<Community> findByOwnerId(Long userId) {
        return null;
    }

    @Override
    public Community findByOwnerIdAndName(Long userid, String name) {
        return null;
    }
}
