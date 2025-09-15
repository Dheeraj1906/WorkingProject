package com.example.corporateBankingH2.service;

import com.example.corporateBankingH2.entity.Document;
import com.example.corporateBankingH2.entity.LoanApplication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocumentService {
    Document uploadDocument(int applicationId, String documentType, MultipartFile file) throws IOException;
    Document validateDocument(Long documentId, Boolean isValid);
    List<Document> viewUploadedDocuments(int applicationId);
    boolean validateDocumentFormat(String fileName);
    List<Document> uploadMultipleDocuments(int applicationId, String[] documentType, MultipartFile[] files) throws IOException;
}
