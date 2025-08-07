package com.mortgage.portal_api.repository;


import com.mortgage.portal_api.entity.AddUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AddUser, Long> {
	boolean existsByUseridentificationnumber(String useridentificationnumber);
    Optional<AddUser> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
