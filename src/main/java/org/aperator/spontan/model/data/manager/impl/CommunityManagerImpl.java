package org.aperator.spontan.model.data.manager.impl;

import org.aperator.spontan.model.data.Community;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.CommunityDAO;
import org.aperator.spontan.model.data.manager.CommunityManager;
import org.aperator.spontan.model.data.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 14/12/13
 * Time: 00:48
 */
public class CommunityManagerImpl implements CommunityManager {

    @Autowired
    private CommunityDAO communityDAO;

    @Autowired
    private UserManager userManager;

    @Override
    public void save(Community community) {
        this.communityDAO.save(community);
    }

    @Override
    public void update(Community community) {
        this.communityDAO.update(community);
    }

    @Override
    public void delete(Community community) {
        this.communityDAO.delete(community);
    }

    @Override
    public List<Community> findByOwnerId(Long ownerId) {
        User user = userManager.findByUserId(ownerId);
        if ( user != null ) {
            List<Community> communities = this.communityDAO.findByOwnerId(ownerId);
            if ( communities != null ) {
                for ( Community community : communities ) {
                    community.setOwner(user);
                    community.setMembers(userManager.findByCommunityId(community.getCommunityId()));
                }
            }
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Community findByOwnerAndName(Long ownerId, String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
