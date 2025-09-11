package com.example.corporateBankingH2.repository;

import com.example.corporateBankingH2.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LoanApplicationRepo extends CrudRepository<LoanApplication,Integer> {
}
