package org.aperator.spontan.model.data;

import java.io.Serializable;

/**
 * User: cedster
 * Date: 24/11/13
 * Time: 15:56
 */
public class User implements Serializable {

    private Long userId;
    private String username;
    private String nickName;
    private String phoneNumber;
    private Password password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
