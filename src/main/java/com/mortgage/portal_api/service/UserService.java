package com.mortgage.portal_api.service;

import com.mortgage.portal_api.dto.UserRequest;
import com.mortgage.portal_api.entity.AddUser;
import com.mortgage.portal_api.repository.RoleRepository;
import com.mortgage.portal_api.repository.UserRepository;
import com.mortgage.portal_api.util.UserIdGenerator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserIdGenerator userIdGenerator;

    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       UserIdGenerator userIdGenerator) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userIdGenerator = userIdGenerator;
    }

    public AddUser createUser(UserRequest request) {
        if (!roleRepository.existsByRoleId(request.getRoleId())) {
            throw new RuntimeException("Role ID does not exist: " + request.getRoleId());
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already taken: " + request.getUsername());
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered: " + request.getEmail());
        }

        // ✅ Auto-generate userIdentificationNumber
        String generatedUserId = userIdGenerator.generateUserId(request.getRoleId());

        if (userRepository.existsByUseridentificationnumber(generatedUserId)) {
            throw new RuntimeException("Generated User ID already exists: " + generatedUserId);
        }

        AddUser user = new AddUser();
        user.setUsername(request.getUsername());
        user.setUseridentificationnumber(generatedUserId); 
        user.setPassword(passwordEncoder.encode(request.getPassword())); 
        user.setEmail(request.getEmail());
        user.setRoleid(request.getRoleId());

        return userRepository.save(user);
    }
}
