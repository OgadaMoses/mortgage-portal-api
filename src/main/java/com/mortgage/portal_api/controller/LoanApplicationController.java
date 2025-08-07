package com.mortgage.portal_api.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import  com.mortgage.portal_api.event.LoanEventProducer;
import com.mortgage.portal_api.kafka.LoanEventPublisher;
import com.mortgage.portal_api.dto.LoanApplicationRequest;
import com.mortgage.portal_api.dto.LoanSummary;
import com.mortgage.portal_api.entity.LoanApplication;
import com.mortgage.portal_api.repository.LoanApplicationRepository;
import com.mortgage.portal_api.service.LoanApplicationService;



@RestController
@RequestMapping("/api/loans")
public class LoanApplicationController {

    private final LoanApplicationService loanService;
    private final LoanApplicationRepository loanRepo;
    private final LoanEventPublisher eventPublisher;

    @Autowired
    public LoanApplicationController(LoanApplicationService loanService,
                                     LoanApplicationRepository loanRepo,LoanEventPublisher eventPublisher) {
        this.loanService = loanService;
        this.loanRepo = loanRepo;
        this.eventPublisher = eventPublisher;
    }

    @PostMapping
    public ResponseEntity<LoanApplication> apply(@RequestBody LoanApplicationRequest request) {
        LoanApplication created = loanService.createLoanApplication(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/my-applications")
    public List<LoanSummary> getUserLoanApplications(
            @RequestParam String username,
            @RequestParam String useridentificationnumber) {

        return loanRepo.findByUsernameAndUseridentificationnumber(username, useridentificationnumber)
                .stream()
                .map(app -> new LoanSummary(app.getLoanappid(),app.getLoanamount(),app.getLoantenure(),app.getLoanstatus(),app.getApplicationdate()))
                .collect(Collectors.toList());
    }
    
    @GetMapping("/status")
    public List<LoanApplication> getApplicationsByStatus(@RequestParam String status) {
        return loanRepo.findByLoanstatus(status.toUpperCase());
    }
    
       //Admin approves loans: mogada
	    @PutMapping("/{loanAppId}/decision")
	    public ResponseEntity<?> makeDecision(@PathVariable String loanAppId,@RequestParam("status") String status,@RequestParam("checkerId") String checkerId) {
	
	        return loanRepo.findByLoanappid(loanAppId)
	                .map(application -> {
	                    application.setLoanstatus(status.toUpperCase());
	                    application.setApprorejectiondate(LocalDateTime.now());
	                    application.setCheckeradminid(checkerId);
	                    loanRepo.save(application);
	                  
	                    String eventMsg = "Loan Application [" + loanAppId + "] updated to status [" + status.toUpperCase() + "]";
	                  //  eventPublisher.publishLoanUpdateEvent(eventMsg);
	
	                    return ResponseEntity.ok("Loan application status updated successfully.");
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }
}

