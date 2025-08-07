package com.mortgage.portal_api.dto;

public class LoginResponse {

    private String token;
    private String role;
    private String username;
    private String useridentificationnumber;

    public LoginResponse() {
    }

    public LoginResponse(String token, String role, String username, String useridentificationnumber) {
        this.token = token;
        this.role = role;
        this.username = username;
        this.useridentificationnumber = useridentificationnumber;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getUseridentificationnumber() {
        return useridentificationnumber;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUseridentificationnumber(String useridentificationnumber) {
        this.useridentificationnumber = useridentificationnumber;
    }
}
