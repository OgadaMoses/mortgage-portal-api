package com.mortgage.portal_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idxno;

    @Column(name = "role_id", nullable = false, unique = true, length = 50)
    private String roleId;

    @Column(name = "role_description", nullable = false, length = 255)
    private String roleDescription;

    public Role() {
    }

    public Role(String roleId, String roleDescription) {
        this.roleId = roleId;
        this.roleDescription = roleDescription;
    }

    public Long getIdxno() {
        return idxno;
    }

    public void setIdxno(Long idxno) {
        this.idxno = idxno;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
