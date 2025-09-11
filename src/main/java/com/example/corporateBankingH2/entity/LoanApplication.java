package com.example.corporateBankingH2.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int applicationId;
    private String companyName;
    private String loanType;
    private double loanAmount;
    @Enumerated(EnumType.STRING)
    private TrackStatus status;

    private LocalDateTime date;

    public enum TrackStatus{
        PENDING,
        REJECTED,
        APPROVED
    }

    public LoanApplication() {
    }

    public LoanApplication(int applicationId, LocalDateTime date, TrackStatus status, double loanAmount, String loanType, String companyName) {
        this.applicationId = applicationId;
        this.date = date;
        this.status = status;
        this.loanAmount = loanAmount;
        this.loanType = loanType;
        this.companyName = companyName;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public TrackStatus getStatus() {
        return status;
    }

    public void setStatus(TrackStatus status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @PrePersist
    public void setDate() {
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "applicationId=" + applicationId +
                ", companyName='" + companyName + '\'' +
                ", loanType='" + loanType + '\'' +
                ", loanAmount=" + loanAmount +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}
