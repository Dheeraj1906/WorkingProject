package com.example.corporateBankingH2.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CreditEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int evaluationId;
    private int applicationId;
    private double riskScore;
    private int creditScore;
    private LocalDateTime evaluationDate;

    @ManyToOne
    @JoinColumn(name = "applicationId", insertable = false,updatable = false)
    private LoanApplication loanApplication;


    public CreditEvaluation() {
    }

    public CreditEvaluation(LocalDateTime evaluationDate, int evaluationId, int applicationId, int creditScore, double riskScore, LoanApplication loanApplication) {
        this.evaluationDate = evaluationDate;
        this.evaluationId = evaluationId;
        this.applicationId = applicationId;
        this.creditScore = creditScore;
        this.riskScore = riskScore;
        this.loanApplication = loanApplication;
    }

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public LocalDateTime getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDateTime evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    @Override
    public String toString() {
        return "CreditEvaluation{" +
                "evaluationId=" + evaluationId +
                ", applicationId=" + applicationId +
                ", riskScore=" + riskScore +
                ", creditScore=" + creditScore +
                ", evaluationDate=" + evaluationDate +
                ", loanApplication=" + loanApplication +
                '}';
    }
}