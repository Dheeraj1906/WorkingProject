package com.example.corporateBankingH2.service;

import com.example.corporateBankingH2.entity.LoanApplication;

public interface LoanApplicationService {

    LoanApplication submitApplication(LoanApplication loanApplication);

    LoanApplication trackApplication(Integer applicationId, String companyName);

    LoanApplication viewApplication(Integer applicationId);

}
