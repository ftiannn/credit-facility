package com.example.clientFacility.model;

import com.example.clientFacility.DTO.Enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer Id;
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private Role role;

    public User(String firstName, String lastName, String email, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = null;
    }

    public User() {}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
