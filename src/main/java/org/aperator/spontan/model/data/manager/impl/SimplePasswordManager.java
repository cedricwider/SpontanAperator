package org.aperator.spontan.model.data.manager.impl;

import org.aperator.spontan.model.data.manager.PasswordManager;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 30/11/13
 * Time: 00:11
 * To change this template use File | Settings | File Templates.
 */
public class SimplePasswordManager implements PasswordManager {

    @Override
    public boolean isValidPassword(String username, String password) {
        return ("JUnitUsername".equals(username) && "JUnitPassword".equals(password));
    }

    @Override
    public void updatePassword(String username, String oldPassword, String newPassword) throws Exception {
    }
}
