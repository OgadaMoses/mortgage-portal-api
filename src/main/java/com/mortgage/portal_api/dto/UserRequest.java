package com.mortgage.portal_api.dto;

public class UserRequest {

    private String username;
    private String userIdentificationNumber;
    private String password;
    private String email;
    private String roleId; 

    public UserRequest() {}

    public UserRequest(String username, String userIdentificationNumber, String password, String email, String roleId) {
        this.username = username;
        this.userIdentificationNumber = userIdentificationNumber;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getUserIdentificationNumber() { return userIdentificationNumber; }
    public void setUserIdentificationNumber(String userIdentificationNumber) { this.userIdentificationNumber = userIdentificationNumber; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRoleId() { return roleId; }
    public void setRoleId(String roleId) { this.roleId = roleId; }
}
