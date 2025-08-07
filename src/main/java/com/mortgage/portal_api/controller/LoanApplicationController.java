package com.mortgage.portal_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.portal_api.dto.LoanApplicationRequest;
import com.mortgage.portal_api.entity.LoanApplication;
import com.mortgage.portal_api.service.LoanApplicationService;


@RestController
@RequestMapping("/api/loans")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanService;

    @PostMapping
    public ResponseEntity<LoanApplication> apply(@RequestBody LoanApplicationRequest request) {
        LoanApplication created = loanService.createLoanApplication(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
