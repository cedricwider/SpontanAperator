package org.aperator.spontan.model.data.manager.impl;

import org.aperator.spontan.model.data.User;
import org.aperator.spontan.model.data.manager.PasswordManager;
import org.aperator.spontan.model.data.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 30/11/13
 * Time: 00:11
 */
public class SimplePasswordManager implements PasswordManager {

    @Autowired
    private UserManager userManager;

    @Autowired
    SecurePasswordEncryptor passwordEncryptor;

    @Override
    public boolean isValidPassword(String username, String password) {
        User user = userManager.findByUsername(username);
        return user != null && user.getPassword().getPasswordHash().equals(passwordEncryptor.encrypt(password));
    }
}
