package com.mortgage.portal_api.controller;

import com.mortgage.portal_api.dto.RoleRequest;
import com.mortgage.portal_api.entity.Role;
import com.mortgage.portal_api.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@Tag(name = "Role Management API")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody RoleRequest request) {
        Role role = new Role(request.getRoleId(), request.getRoleDescription());
        Role savedRole = roleService.createRole(role);
        return ResponseEntity.ok(savedRole);
    }
}
