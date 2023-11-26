package com.example.demo.dto;

import java.util.Set;

public class SingupRequest {
    private String email;
    private String password;
    private Set<String> roles;
    private String username;

    public SingupRequest() {
    }

    public SingupRequest(String email, String password, Set<String> roles, String username) {
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
