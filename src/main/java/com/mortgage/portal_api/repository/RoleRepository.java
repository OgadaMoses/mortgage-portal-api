package com.mortgage.portal_api.repository;

import com.mortgage.portal_api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByRoleId(String roleId);
}