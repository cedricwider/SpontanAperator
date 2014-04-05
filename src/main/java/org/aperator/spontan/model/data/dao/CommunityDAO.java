package org.aperator.spontan.model.data.dao;

import org.aperator.spontan.model.data.Community;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 14/12/13
 * Time: 00:34
 */
public interface CommunityDAO {

    public void save(Community community);

    public List<Community> findByOwnerId(Long userId);

    public Community findByOwnerIdAndName(Long userid, String name);

    public Community update(Community community);

    public void delete(Community community);
}
