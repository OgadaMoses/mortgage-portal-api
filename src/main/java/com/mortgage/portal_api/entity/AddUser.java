package com.mortgage.portal_api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class AddUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idxno;

    @Column(name = "username")
    private String username;

    @Column(name = "useridentificationnumber")
    private String useridentificationnumber;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "roleid")
    private String roleid;

    @Column(name = "createdat")
    private LocalDateTime createdat = LocalDateTime.now();

    @Column(name = "updatedat")
    private LocalDateTime updatedat = LocalDateTime.now();

    @Column(name = "activestatus")
    private boolean activestatus = true;

    @Column(name = "ispasswordexpired")
    private boolean ispasswordexpired = false;

    @Column(name = "lastlogin")
    private LocalDateTime lastlogin;

    @Column(name = "full_name")
    private String fullName;


    public Long getIdxno() {
        return idxno;
    }

    public void setIdxno(Long idxno) {
        this.idxno = idxno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseridentificationnumber() {
        return useridentificationnumber;
    }

    public void setUseridentificationnumber(String useridentificationnumber) {
        this.useridentificationnumber = useridentificationnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
    }

    public boolean isActivestatus() {
        return activestatus;
    }

    public void setActivestatus(boolean activestatus) {
        this.activestatus = activestatus;
    }

    public boolean isIspasswordexpired() {
        return ispasswordexpired;
    }

    public void setIspasswordexpired(boolean ispasswordexpired) {
        this.ispasswordexpired = ispasswordexpired;
    }

    public LocalDateTime getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(LocalDateTime lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
