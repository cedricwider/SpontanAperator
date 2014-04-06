package org.aperator.spontan.data;

import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.User;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 06/04/14
 * Time: 01:50
 */
public class TestDataGenerator {
    public static User user(String username) {
        User myUser = new User();
        myUser.setEmail(username+"@unit.com");
        myUser.setPhoneNumber("+41 79 136 75 01");
        myUser.setUsername(username);
        myUser.setNickName("JUnitNickname");
        Password myPassword = new Password();
        myPassword.setPasswordHash("JUnitPassword");
        myUser.setPassword(myPassword);
        return myUser;
    }
}
