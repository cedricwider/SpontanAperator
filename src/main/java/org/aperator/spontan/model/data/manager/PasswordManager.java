package org.aperator.spontan.model.data.manager;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 30/11/13
 * Time: 00:06
 * To change this template use File | Settings | File Templates.
 */
public interface PasswordManager {

    public boolean isValidPassword(String username, String password);
}
