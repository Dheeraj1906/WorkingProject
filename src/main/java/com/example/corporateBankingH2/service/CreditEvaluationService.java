package com.example.corporateBankingH2.service;

import com.example.corporateBankingH2.entity.CreditEvaluation;
import org.springframework.stereotype.Service;

@Service
public interface CreditEvaluationService {
    CreditEvaluation evaluateCredit(int applicationId);
    void getRiskScore();
}
