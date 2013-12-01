package org.aperator.spontan.model.data;

/**
 * User: cedster
 * Date: 01/12/13
 * Time: 18:33
 */
public class Password {

    private Long passwordId;
    private Long userId;
    private String passwordHash;

    public Long getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(Long passwordId) {
        this.passwordId = passwordId;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
