package com.example.corporateBankingH2.dto;

import com.example.corporateBankingH2.entity.LoanApplication;

public class TrackDTO {
    private Integer applicationId;
    private String companyName;
    private LoanApplication.TrackStatus status;

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LoanApplication.TrackStatus getStatus() {
        return status;
    }

    public void setStatus(LoanApplication.TrackStatus status) {
        this.status = status;
    }
}
