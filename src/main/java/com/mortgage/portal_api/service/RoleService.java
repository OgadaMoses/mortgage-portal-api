package com.mortgage.portal_api.service;

import com.mortgage.portal_api.entity.Role;
import com.mortgage.portal_api.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        if (roleRepository.existsByRoleId(role.getRoleId())) {
            throw new RuntimeException("Role with ID '" + role.getRoleId() + "' already exists!");
        }
        return roleRepository.save(role);
    }
}
