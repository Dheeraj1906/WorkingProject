package com.example.corporateBankingH2.controller;

import com.example.corporateBankingH2.entity.CreditEvaluation;
import com.example.corporateBankingH2.service.CreditEvaluationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class CreditEvaluationController {

    @Autowired
    CreditEvaluationServiceImp creditEvaluationServiceImp;

    @PostMapping("/credit")
    public ResponseEntity<CreditEvaluation> creditEvaluation(@RequestBody CreditEvaluation creditEvaluation ){
        return ResponseEntity.ok().body( creditEvaluationServiceImp.evaluateCredit(creditEvaluation.getApplicationId()));

    }
}
