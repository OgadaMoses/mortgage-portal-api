package com.mortgage.portal_api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idxno;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "useridentificationnumber", nullable = false, unique = true, length = 50)
    private String userIdentificationNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "roleid", nullable = false, length = 50)
    private String roleid;  

    @Column(name = "createdat", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updatedat", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "activestatus", nullable = false)
    private boolean activeStatus = true;

    @Column(name = "lastlogin")
    private LocalDateTime lastLogin;

    @Column(name = "ispasswordexpired", nullable = false)
    private boolean isPasswordExpired = false;
   
    public User() {}

    public Long getIdxno() { return idxno; }
    public String getUsername() { return username; }
    public String getUserIdentificationNumber() { return userIdentificationNumber; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getRoleid() { return roleid; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public boolean isActiveStatus() { return activeStatus; }
    public LocalDateTime getLastLogin() { return lastLogin; }
    public boolean isPasswordExpired() { return isPasswordExpired; }

    public void setIdxno(Long idxno) { this.idxno = idxno; }
    public void setUsername(String username) { this.username = username; }
    public void setUserIdentificationNumber(String userIdentificationNumber) {
        this.userIdentificationNumber = userIdentificationNumber;
    }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email) { this.email = email; }
    public void setRoleid(String roleid) { this.roleid = roleid; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public void setActiveStatus(boolean activeStatus) { this.activeStatus = activeStatus; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }
    public void setPasswordExpired(boolean passwordExpired) {
        isPasswordExpired = passwordExpired;
    }
}
