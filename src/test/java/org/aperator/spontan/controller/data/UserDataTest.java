package org.aperator.spontan.controller.data;

import org.aperator.spontan.controller.util.UserDataConverter;
import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.PasswordEncryptor;
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
        user.setId(1l);
        user.setPhoneNumber("PhoneNumber");
        user.setUsername("Username");
        Password password = new Password();
        password.setPasswordHash("PasswordHash");
        user.setPassword(password);
        user.setNickName("Nickname");
        user.setEmail("Email");
        UserDataConverter userDataConverter = new UserDataConverter(new PasswordEncryptor() {
            @Override
            public String encrypt(String password) {
                return password;
            }
        });

        // when
        UserData userData = userDataConverter.toUserData(user);

        // expect
        assertEquals(userData.getEmail(), user.getEmail());
        assertEquals(userData.getNickname(), user.getNickName());
        assertEquals(userData.getPhoneNumber(), user.getPhoneNumber());
        assertEquals(userData.getUsername(), user.getUsername());
        assertEquals(userData.getUserId(), user.getId());
        assertEquals(userData.getEmail(), user.getEmail());
    }
}
