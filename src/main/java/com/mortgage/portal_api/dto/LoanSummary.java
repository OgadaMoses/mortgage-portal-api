package com.mortgage.portal_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanSummary {
    private String loanappid;
    private BigDecimal loanamount;
    private int loantenure;
    private String loanstatus;
    private LocalDateTime applicationdate;

    public LoanSummary(String loanappid, BigDecimal loanamount, int loantenure, String loanstatus, LocalDateTime applicationdate) {
        this.loanappid = loanappid;
        this.loanamount = loanamount;
        this.loantenure = loantenure;
        this.loanstatus = loanstatus;
        this.applicationdate = applicationdate;
    }

    public String getLoanappid() {
        return loanappid;
    }

    public BigDecimal getLoanamount() {
        return loanamount;
    }

    public int getLoantenure() {
        return loantenure;
    }

    public String getLoanstatus() {
        return loanstatus;
    }

    public LocalDateTime getApplicationdate() {
        return applicationdate;
    }
}
