package org.aperator.spontan.controller.data;

import org.aperator.spontan.controller.util.UserDataConverter;
import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.User;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 12/12/13
 * Time: 20:44
 */
public class UserDataTest {

    @Test
    public void shouldMapToCorrectFieldsOnCreation() {
        // given
        User user = new User();
        user.setUserId(1l);
        user.setPhoneNumber("PhoneNumber");
        user.setUsername("Username");
        Password password = new Password();
        password.setPasswordHash("PasswordHash");
        user.setPassword(password);
        user.setNickName("Nickname");

        // when
        UserData userData = UserDataConverter.toUserData(user);

        // expect
        assertEquals(userData.getEmail(), user.getEmail());
        assertEquals(userData.getNickname(), user.getNickName());
        assertEquals(userData.getPhoneNumber(), user.getPhoneNumber());
        assertEquals(userData.getUsername(), user.getUsername());
        assertEquals(userData.getUserId(), user.getUserId());
    }
}
