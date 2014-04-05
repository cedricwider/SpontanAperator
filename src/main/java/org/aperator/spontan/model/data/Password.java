package org.aperator.spontan.model.data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: cedster
 * Date: 01/12/13
 * Time: 18:33
 */
@Entity
public class Password implements Serializable {


    private Long id;
    private String passwordHash;
    private Long userId;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "hash")
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = {})
    @PrimaryKeyJoinColumn
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "user_id", unique = true, nullable = false)
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
