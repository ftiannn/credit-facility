package com.example.clientFacility.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOKEN_ID")
    private Integer id;

    @Column(name = "token")
    private String token;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "USER_ID")
    private User user;

    public Token(User user) {
        this.user = user;
        this.token = UUID.randomUUID().toString();
        this.createdDate = new Date();
    }

    public Token() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
