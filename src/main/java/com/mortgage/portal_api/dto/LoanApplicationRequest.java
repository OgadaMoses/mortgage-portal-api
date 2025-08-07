package com.mortgage.portal_api.dto;

import java.math.BigDecimal;
import java.util.List;

public class LoanApplicationRequest {

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
    private List<String> documenturls;
    private String checkeradminid;
    private String username;
    private String useridentificationnumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseridentificationnumber() {
        return useridentificationnumber;
    }

    public void setUseridentificationnumber(String useridentificationnumber) {
        this.useridentificationnumber = useridentificationnumber;
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

   

    public String getCheckeradminid() {
        return checkeradminid;
    }

    public void setCheckeradminid(String checkeradminid) {
        this.checkeradminid = checkeradminid;
    }
}
