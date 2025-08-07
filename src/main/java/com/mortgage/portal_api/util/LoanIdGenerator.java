package com.mortgage.portal_api.util;

import com.mortgage.portal_api.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LoanIdGenerator {

    @Autowired
    private LoanApplicationRepository loanRepository;

    public String generateLoanId() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int serial = 1;
        String loanId;

        // Keep generating until you find a unique ID
        do {
            loanId = String.format("LN%03d%s", serial, date);
            serial++;
        } while (loanRepository.existsByLoanappid(loanId));

        return loanId;
    }
}
