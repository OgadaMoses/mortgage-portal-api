package com.mortgage.portal_api.service;

import com.mortgage.portal_api.dto.LoginRequest;
import com.mortgage.portal_api.dto.LoginResponse;
import com.mortgage.portal_api.entity.AddUser;
import com.mortgage.portal_api.repository.UserRepository;
import com.mortgage.portal_api.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       JwtTokenProvider jwtTokenProvider,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request) {
        AddUser user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtTokenProvider.generateToken(user.getUsername(), user.getRoleid());

        return new LoginResponse(
                token,
                user.getRoleid(),
                user.getUsername(),
                user.getUseridentificationnumber()
        );
    }
}
