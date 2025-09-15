package com.example.corporateBankingH2.service;

import com.example.corporateBankingH2.entity.Document;
import com.example.corporateBankingH2.entity.LoanApplication;
import com.example.corporateBankingH2.repository.DocumentRepo;
import com.example.corporateBankingH2.repository.LoanApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.event.DocumentEvent;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepo documentRepo;

    @Autowired
    LoanApplicationRepo loanApplicationRepo;

    private static final String UPLOAD_DIR = "uploads/documents/";

    @Override
    public Document uploadDocument(int applicationId, String documentType, MultipartFile file) throws IOException {
        Optional<LoanApplication> applicationOpt = loanApplicationRepo.findById(applicationId);
        if (!applicationOpt.isPresent()) {
            throw new RuntimeException("Application not found with ID : " + applicationId);
        }

        LoanApplication application = applicationOpt.get();

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        if(fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("File name cannot be empty");
        }
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

        Path filePath = uploadPath.resolve(uniqueFileName);
        Files.copy(file.getInputStream(), filePath);

        Document document = new Document(application, documentType, filePath.toString());

        return documentRepo.save(document);

    }

    @Override
    public List<Document> uploadMultipleDocuments(int applicationId, String[] documentTypes, MultipartFile[] files) throws IOException{
        if(files.length != documentTypes.length) {
            throw new IllegalArgumentException("Number of files must be equal to number of document types.");
        }

        Optional<LoanApplication> applicationOpt = loanApplicationRepo.findById(applicationId);
        if(!applicationOpt.isPresent()) {
            throw new RuntimeException("Application not found with ID : " + applicationId);
        }

        LoanApplication applictaion = applicationOpt.get();
        List<Document> uploadedDocuments = new ArrayList<>();

        Path uploadPath = Paths.get(UPLOAD_DIR);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        for(int i = 0; i <files.length; i++) {
            MultipartFile file = files[i];
            String docType = documentTypes[i];
            if(file.isEmpty()) {
                continue;
            }
            String fileName = file.getOriginalFilename();
            if(fileName == null || fileName.isEmpty()) {
                throw new IllegalArgumentException("File name cannot be empty for file at index : " + i);
            }
            if(!validateDocumentFormat(fileName)) {
                throw new IllegalArgumentException("invalid file format for file : " + fileName);
            }

            String fileExtension = fileName.substring(fileName.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

            Path filePath = uploadPath.resolve(uniqueFileName);
            Files.copy(file.getInputStream(), filePath);

            Document document = new Document(applictaion, docType, filePath.toString());
            Document savedDocument = documentRepo.save(document);
        }
        return uploadedDocuments;
    }

    @Override
    public Document validateDocument(Long documentId, Boolean isValid) {
        Optional<Document> documentOpt = documentRepo.findById(documentId);
        if (!documentOpt.isPresent()) {
            throw new RuntimeException("Document not found with ID : " + documentId);
        }

        Document document = documentOpt.get();
        document.setValid(isValid);
        return documentRepo.save(document);
    }

    @Override
    public List<Document> viewUploadedDocuments(int applicationId) {
        Optional<LoanApplication> applicationOpt = loanApplicationRepo.findById(applicationId);
        if(!applicationOpt.isPresent()) {
            throw new RuntimeException("Application not found with ID : " + applicationId);
        }
        return documentRepo.findByApplication(applicationOpt.get());
    }

    @Override
    public boolean validateDocumentFormat(String fileName) {
        String[] allowedExtensions = {".pdf", ".doc", ".docx", ".jpg", ".jpeg", ".png"};
        String fileExtension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();

        for (String extension : allowedExtensions) {
            if(fileExtension.equals(extension)) {
                return true;
            }
        }
        return false;
    }
}
