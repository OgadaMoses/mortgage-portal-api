package com.mortgage.portal_api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loanapplications")
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idxno;

    private String fullnames;
    private String email;
    private String phonenumber;
    private String idpassportnumber;
    private String nationality;
    private String countryresidence;
    private String countyresidence;
    private BigDecimal netmonthlyincome;
    private BigDecimal loanamount;
    private Integer loantenure;

    @ElementCollection
    private List<String> documenturls = new ArrayList<>();

    private String loanappid;
    private String loanstatus = "PENDING";
    private LocalDateTime applicationdate = LocalDateTime.now();
    private LocalDateTime approrejectiondate;
    private String useridentificationnumber;
    private String checkeradminid;
    private String username;
    
   

    public Integer getIdxno() {
        return idxno;
    }

    public void setIdxno(Integer idxno) {
        this.idxno = idxno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getFullnames() {
        return fullnames;
    }

    public void setFullnames(String fullnames) {
        this.fullnames = fullnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getIdpassportnumber() {
        return idpassportnumber;
    }

    public void setIdpassportnumber(String idpassportnumber) {
        this.idpassportnumber = idpassportnumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCountryresidence() {
        return countryresidence;
    }

    public void setCountryresidence(String countryresidence) {
        this.countryresidence = countryresidence;
    }

    public String getCountyresidence() {
        return countyresidence;
    }

    public void setCountyresidence(String countyresidence) {
        this.countyresidence = countyresidence;
    }

    public BigDecimal getNetmonthlyincome() {
        return netmonthlyincome;
    }

    public void setNetmonthlyincome(BigDecimal netmonthlyincome) {
        this.netmonthlyincome = netmonthlyincome;
    }

    public BigDecimal getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(BigDecimal loanamount) {
        this.loanamount = loanamount;
    }

    public Integer getLoantenure() {
        return loantenure;
    }

    public void setLoantenure(Integer loantenure) {
        this.loantenure = loantenure;
    }

    public List<String> getDocumenturls() {
        return documenturls;
    }

    public void setDocumenturls(List<String> documenturls) {
        this.documenturls = documenturls;
    }

    public String getLoanappid() {
        return loanappid;
    }

    public void setLoanappid(String loanappid) {
        this.loanappid = loanappid;
    }

    public String getLoanstatus() {
        return loanstatus;
    }

    public void setLoanstatus(String loanstatus) {
        this.loanstatus = loanstatus;
    }

    public LocalDateTime getApplicationdate() {
        return applicationdate;
    }

    public void setApplicationdate(LocalDateTime applicationdate) {
        this.applicationdate = applicationdate;
    }

    public LocalDateTime getApprorejectiondate() {
        return approrejectiondate;
    }

    public void setApprorejectiondate(LocalDateTime approrejectiondate) {
        this.approrejectiondate = approrejectiondate;
    }

    public String getUseridentificationnumber() {
        return useridentificationnumber;
    }

    public void setUseridentificationnumber(String useridentificationnumber) {
        this.useridentificationnumber = useridentificationnumber;
    }

    public String getCheckeradminid() {
        return checkeradminid;
    }

    public void setCheckeradminid(String checkeradminid) {
        this.checkeradminid = checkeradminid;
    }
}
