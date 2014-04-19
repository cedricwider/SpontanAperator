package org.aperator.spontan.controller.data.mapper;

import org.aperator.spontan.controller.data.RegisterUserRequestData;
import org.aperator.spontan.controller.data.UserData;
import org.aperator.spontan.model.data.Password;
import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.PasswordEncryptor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 12/12/13
 * Time: 21:07
 */
public class UserDataMapper {

    private PasswordEncryptor passwordEncryptor;

    public UserDataMapper(PasswordEncryptor passwordEncryptor) {
        this.passwordEncryptor = passwordEncryptor;
    }

    public User toUser(RegisterUserRequestData registerData) {
        User user = new User();
        user.setNickName(registerData.getNickname());
        user.setFirstname(registerData.getFirstname());
        user.setLastname(registerData.getLastname());
        Password password = new Password();
        password.setPasswordHash(passwordEncryptor.encrypt(registerData.getPassword()));
        user.setPassword(password);
        user.setPhoneNumber(registerData.getPhonenumber());
        user.setUsername(registerData.getUsername());
        user.setEmail(registerData.getEmail());
        return user;
    }

    public UserData toUserData(User user) {
        if (user == null) return null;

        UserData userData = new UserData();
        userData.setUserId(user.getId());
        userData.setFirstname(user.getFirstname());
        userData.setLastname(user.getLastname());
        userData.setNickname(user.getNickName());
        userData.setPhoneNumber(user.getPhoneNumber());
        userData.setEmail(user.getEmail());
        return userData;
    }

    public List<UserData> toUserData(List<User> allUsers) {
        List<UserData> userData = new LinkedList<>();
        for (User user : allUsers) {
            userData.add(toUserData(user));
        }
        return userData;
    }
}
