package org.aperator.spontan.model.data.manager;

import org.aperator.spontan.model.data.Community;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 14/12/13
 * Time: 00:46
 */
public interface CommunityManager {

    public void save(Community community);
    public void update(Community community);
    public void delete(Community community);
    public List<Community> findByOwnerId(Long ownerId);
    public Community findByOwnerAndName(Long ownerId, String name);
}
