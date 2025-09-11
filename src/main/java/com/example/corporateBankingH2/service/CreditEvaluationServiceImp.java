package com.example.corporateBankingH2.service;

import com.example.corporateBankingH2.entity.CreditEvaluation;
import com.example.corporateBankingH2.entity.LoanApplication;
import com.example.corporateBankingH2.repository.CreditEvaluationRepo;
import com.example.corporateBankingH2.repository.LoanApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class CreditEvaluationServiceImp implements CreditEvaluationService{

    @Autowired
    CreditEvaluationRepo creditEvaluationRepo;

    @Autowired
    LoanApplicationRepo loanApplicationRepo;

    @Override
    public CreditEvaluation evaluateCredit(int applicationId) {

        Optional<LoanApplication> loanApplication=loanApplicationRepo.findById(applicationId);

        int creditScore = new Random().nextInt(250,500)+300;
        double riskscore = new Random().nextDouble(0.00,1.00)*10;

        CreditEvaluation evaluation = new CreditEvaluation();
        evaluation.setApplicationId(applicationId);
        evaluation.setCreditScore(creditScore);
        evaluation.setRiskScore(riskscore);
        evaluation.setEvaluationDate(LocalDateTime.now());

        return creditEvaluationRepo.save(evaluation);

    }

    @Override
    public void getRiskScore() {

    }
}
