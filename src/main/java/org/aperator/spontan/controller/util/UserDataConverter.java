package org.aperator.spontan.controller.util;

import org.aperator.spontan.controller.RegisterUserRequestData;
import org.aperator.spontan.controller.data.UserData;
import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.User;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 12/12/13
 * Time: 21:07
 */
public class UserDataConverter {

    public static User fromRegisterUserRequestData(RegisterUserRequestData registerData) {
        User user = new User();
        user.setNickName(registerData.getNickname());
        Password password = new Password();
        password.setPasswordHash(registerData.getPassword());
        user.setPassword(password);
        user.setPhoneNumber(registerData.getPhonenumber());
        user.setUsername(registerData.getUsername());
        user.setEmail(registerData.getEmail());
        return user;
    }

    public static UserData toUserData(User user) {
        UserData userData = new UserData();
        userData.setUserId(user.getUserId());
        userData.setUsername(user.getUsername());
        userData.setNickname(user.getNickName());
        userData.setPhoneNumber(user.getPhoneNumber());
        userData.setEmail(user.getEmail());
        return userData;
    }
}
