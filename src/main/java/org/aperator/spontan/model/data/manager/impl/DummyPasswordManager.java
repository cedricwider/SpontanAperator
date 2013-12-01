package org.aperator.spontan.model.data.manager.impl;

import org.aperator.spontan.model.data.manager.PasswordManager;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 01/12/13
 * Time: 19:12
 */
public class DummyPasswordManager implements PasswordManager {
    @Override
    public boolean isValidPassword(String username, String password) {
        return ("JUnitUsername".equals(username) && "JUnitPassword".equals(password));
    }
}
