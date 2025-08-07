package com.mortgage.portal_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mortgage.portal_api.entity.LoanApplication;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Integer> {
    Optional<LoanApplication> findByLoanappid(String loanappid);
    boolean existsByLoanappid(String loanappid);
    List<LoanApplication> findByUsernameAndUseridentificationnumber(String username, String useridentificationnumber);
    List<LoanApplication> findByLoanstatus(String loanstatus);
}
