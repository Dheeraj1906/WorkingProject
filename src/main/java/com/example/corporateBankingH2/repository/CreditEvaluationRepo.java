package com.example.corporateBankingH2.repository;

import com.example.corporateBankingH2.entity.CreditEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditEvaluationRepo extends JpaRepository<CreditEvaluation,Integer> {

}
