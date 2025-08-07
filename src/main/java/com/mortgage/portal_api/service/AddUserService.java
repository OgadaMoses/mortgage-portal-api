package com.mortgage.portal_api.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mortgage.portal_api.dto.AddUserRequest;
import com.mortgage.portal_api.entity.AddUser;
import com.mortgage.portal_api.repository.UserRepository;
import com.mortgage.portal_api.util.UserIdGenerator;

@Service
public class AddUserService {

    private final UserRepository userRepository;
    private final UserIdGenerator userIdGenerator;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AddUserService(UserRepository userRepository, UserIdGenerator userIdGenerator) {
        this.userRepository = userRepository;
        this.userIdGenerator = userIdGenerator;
    }

    public AddUser registerUser(AddUserRequest request) {
        String userId = userIdGenerator.generateUserId(request.getRole());
        String roleId = userIdGenerator.resolveRoleId(request.getRole());

        if (userRepository.existsByUseridentificationnumber(userId)) {
            throw new RuntimeException("User ID already exists: " + userId);
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use.");
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already taken.");
        }

        AddUser user = new AddUser();
        user.setUsername(request.getUsername());
        user.setUseridentificationnumber(userId);
        user.setEmail(request.getEmail());
        user.setRoleid(roleId);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());

        return userRepository.save(user);
    }
    
    public List<AddUser> getAllUsers() {
        return userRepository.findAll();
    }

}
