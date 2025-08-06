package com.mortgage.portal_api.service;

import com.mortgage.portal_api.dto.UserRequest;
import com.mortgage.portal_api.entity.User;
import com.mortgage.portal_api.repository.RoleRepository;
import com.mortgage.portal_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(UserRequest request) {
        if (!roleRepository.existsByRoleId(request.getRoleId())) {
            throw new RuntimeException("Role ID does not exist: " + request.getRoleId());
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already taken: " + request.getUsername());
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered: " + request.getEmail());
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setUserIdentificationNumber(request.getUserIdentificationNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // hash password
        user.setEmail(request.getEmail());
        user.setRoleid(request.getRoleId());

        return userRepository.save(user);
    }
}
