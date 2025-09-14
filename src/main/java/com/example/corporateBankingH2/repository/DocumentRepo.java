package com.example.corporateBankingH2.repository;

import com.example.corporateBankingH2.entity.Document;
import com.example.corporateBankingH2.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Long> {
    List<Document> findByApplication(LoanApplication application);
//    List<Document> findIsValid(Boolean isValid);
}
