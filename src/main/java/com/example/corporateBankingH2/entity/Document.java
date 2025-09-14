package com.example.corporateBankingH2.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    @ManyToOne
    @JoinColumn(name = "application_id") // foreign key column
    private LoanApplication application;

    private String documentType;
    private String filePath;
    private LocalDate uploadDate;
    private Boolean isValid = false;

    public Document() {}

    public Document(LoanApplication application, String documentType, String filePath) {
        this.application = application;
        this.documentType = documentType;
        this.filePath = filePath;
        this.uploadDate = LocalDate.now();
        this.isValid = false;
    }

    // Getters and setters...

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public LoanApplication getApplication() {
        return application;
    }

    public void setApplication(LoanApplication application) {
        this.application = application;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate() {
        this.uploadDate = LocalDate.now();
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", application=" + application +
                ", documentType='" + documentType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", uploadDate=" + uploadDate +
                ", isValid=" + isValid +
                '}';
    }
}


