package org.aperator.spontan.model.data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: cedster
 * Date: 24/11/13
 * Time: 15:56
 */
@Entity
public class User implements Serializable {

    private Long id;
    private Integer version;
    private String username;
    private String nickName;
    private String phoneNumber;
    private Password password;
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "name")
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

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "password_id", referencedColumnName = "id")
    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    @Version
    @Transient
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
