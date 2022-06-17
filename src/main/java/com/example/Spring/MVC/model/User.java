package com.example.Spring.MVC.model;

public class User {
    Integer Id;
    String username;
    String lastname;
    String firstname;
    String password;
    String salt;

    public User(Integer id, String username, String lastname, String firstname, String password, String salt) {
        Id = id;
        this.username = username;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
        this.salt = salt;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
