package org.aperator.spontan.data;

import org.aperator.spontan.model.data.Community;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.dao.CommunityDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.LinkedList;
import java.util.List;

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
    private CommunityDAO communityDAO;

    @Test
    public void creatingCommunitiesShouldWork() {
        User owner = TestDataGenerator.user("owner");
        List<User> members = new LinkedList<User>();
        for ( int i = 0; i < 10 ; i++ ) {
            members.add(TestDataGenerator.user("member" + i));
        }
        Community community = new Community();
        community.setName("JUnit_Name");
        community.setOwner(owner);
        community.setMembers(members);
        community.setDescription("JUnit_Description");
        this.communityDAO.save(community);

        // assertNotNull(this.communityDAO.findByOwnerIdAndName(owner.getId(), "JUnit_Name"));
    }

    @Test
    public void createAndLoadCommunityShouldHoldOnToItsValues() {

    }
}
