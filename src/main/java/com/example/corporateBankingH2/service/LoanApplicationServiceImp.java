package com.example.corporateBankingH2.service;

import com.example.corporateBankingH2.entity.LoanApplication;
import com.example.corporateBankingH2.repository.LoanApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationServiceImp implements LoanApplicationService{

    @Autowired
    LoanApplicationRepo loanApplicationRepo;

    @Override
    public LoanApplication submitApplication(LoanApplication loanApplication) {
        loanApplication.setStatus(LoanApplication.TrackStatus.PENDING);
       return loanApplicationRepo.save(loanApplication);
    }

    @Override
    public LoanApplication trackApplication(Integer applicationId, String companyName){
        return loanApplicationRepo.findById(applicationId).get();
    }

    @Override
    public LoanApplication viewApplication(Integer applicationId) {
        return loanApplicationRepo.findById(applicationId).get();

    }
}
