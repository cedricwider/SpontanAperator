package org.aperator.spontan.model.data.manager.impl;

import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.bo.UserBO;
import org.aperator.spontan.model.data.manager.PasswordManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 30/11/13
 * Time: 00:11
 */
public class SimplePasswordManager implements PasswordManager {

    @Autowired
    private UserBO userBo;

    @Override
    public boolean isValidPassword(String username, String password) {
        User user = userBo.findByUsername(username);
        return user != null && user.getPassword().getPasswordHash().equals(password);
    }

    @Override
    public void updatePassword(String username, String oldPassword, String newPassword) throws Exception {
    }
}
