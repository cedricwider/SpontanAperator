package org.aperator.spontan.data;

import org.aperator.spontan.model.data.Community;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.CommunityManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 28/12/13
 * Time: 14:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/test/resources/JUnit_Spring.xml")
public class CommunityTest {

    @Autowired
    private CommunityManager communityManager;

    @Test
    @Ignore("TODO ced: Make sure to refactor other tests first")
    public void creatingCommunitiesShouldWork() {
        User owner = new User();
        owner.setEmail("owner@email.com");
        owner.setId(1l);
        Community community = new Community();
        community.setOwner(owner);
        this.communityManager.save(community);
    }

    @Test
    public void createAndLoadCommunityShouldHoldOnToItsValues() {

    }
}
