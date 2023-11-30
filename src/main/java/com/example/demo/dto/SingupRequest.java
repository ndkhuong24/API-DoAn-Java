package com.example.demo.dto;

import java.util.Set;

public class SingupRequest {
    private String fullname;
    private String email;
    private String password;
    private String phone;
    private Integer roles;
    private String username;

    public SingupRequest() {
    }

    public SingupRequest(String email, String password, Integer roles, String username) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SingupRequest(String fullname, String email, String password, String phone, Integer roles, String username) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.roles = roles;
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
