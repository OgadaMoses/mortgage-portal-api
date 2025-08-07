package com.mortgage.portal_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.portal_api.dto.LoanApplicationRequest;
import com.mortgage.portal_api.entity.LoanApplication;
import com.mortgage.portal_api.repository.LoanApplicationRepository;
import com.mortgage.portal_api.util.LoanIdGenerator;

@Service
public class LoanApplicationService {

    @Autowired
    private LoanApplicationRepository loanRepository;

    @Autowired
    private LoanIdGenerator loanIdGenerator;

    public LoanApplication createLoanApplication(LoanApplicationRequest request) {
        LoanApplication loan = new LoanApplication();

        loan.setFullnames(request.getFullnames());
        loan.setEmail(request.getEmail());
        loan.setPhonenumber(request.getPhonenumber());
        loan.setIdpassportnumber(request.getIdpassportnumber());
        loan.setNationality(request.getNationality());
        loan.setCountryresidence(request.getCountryresidence());
        loan.setCountyresidence(request.getCountyresidence());
        loan.setNetmonthlyincome(request.getNetmonthlyincome());
        loan.setLoanamount(request.getLoanamount());
        loan.setLoantenure(request.getLoantenure());
        loan.setDocumenturls(request.getDocumenturls());
        loan.setCheckeradminid(request.getCheckeradminid());

        loan.setLoanappid(loanIdGenerator.generateLoanId());
        loan.setUseridentificationnumber(request.getUseridentificationnumber());
        loan.setUsername(request.getUsername());

        return loanRepository.save(loan);
    }
}
