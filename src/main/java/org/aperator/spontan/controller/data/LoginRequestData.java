package org.aperator.spontan.controller.data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: cedster
 * Date: 24/11/13
 * Time: 19:42
 * To change this template use File | Settings | File Templates.
 */
public class LoginRequestData implements Serializable{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
