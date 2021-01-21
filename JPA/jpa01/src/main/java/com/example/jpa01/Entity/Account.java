package com.example.jpa01.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long uid;

    @Column(nullable=false)
    private String userId;

    @Column(nullable = false)
    private String pwd;

    private String email;

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {

        this.userId = userId;
    }

    public Long getUid() {

        return uid;
    }

    public void setUid(Long uid) {

        this.uid = uid;
    }

    public String getPwd() {

        return pwd;
    }

    public void setPwd(String pwd) {

        this.pwd = pwd;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    public String toString() {

        return "Account{" +
                "uid=" + uid +
                ", userId='" + userId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
