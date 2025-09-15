package com.example.corporateBankingH2.controller;

import com.example.corporateBankingH2.entity.Document;
import com.example.corporateBankingH2.service.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    DocumentServiceImpl documentService;

    @GetMapping("/upload")
    public ModelAndView uploadPage(){
        System.out.println("UploadPage");
        return new ModelAndView("upload");
    }

    @PostMapping("/upload/{applicationId}")
    public ResponseEntity<Document> uploadDocument(
            @PathVariable int applicationId,
            @RequestParam String documentType,
            @RequestParam("file") MultipartFile file) {
        System.out.println("Uploaded file....!!!!");
        try {
            if(!documentService.validateDocumentFormat(file.getOriginalFilename())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Document document = documentService.uploadDocument(applicationId, documentType, file);
            return new ResponseEntity<>(document, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/uploadmultiple")
    public ModelAndView uploadMultiplePage(){
        System.out.println("UploadMultiplePage");
        return new ModelAndView("uploadmultiple");
    }

    @PostMapping("/uploadmultiple/{applicationId}")
    public ResponseEntity<List<Document>> uploadMultipleDocuments(
            @PathVariable int applicationId,
            @RequestParam("documentTypes") String[] documentTypes,
            @RequestParam("files") MultipartFile[] files) {
        System.out.println("Uploading ... Multiple Files...!!");
        try {
            // Validate that we have the same number of files and document types
            if (files.length != documentTypes.length) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            for (MultipartFile file : files) {
                if (!documentService.validateDocumentFormat(file.getOriginalFilename())) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }

            List<Document> documents = documentService.uploadMultipleDocuments(applicationId, documentTypes, files);
            return new ResponseEntity<>(documents, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{documentId}/validate")
    public ResponseEntity<Document> validateDocument(
            @PathVariable Long documentId,
            @RequestParam Boolean isValid) {
        try{
            Document document = documentService.validateDocument(documentId, isValid);
            return new ResponseEntity<>(document, HttpStatus.OK);
        } catch(RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/application/{applicationId}")
    public ResponseEntity<List<Document>> viewUploadedDocuments(
            @PathVariable int applicationId) {
        try {
            List<Document> documents = documentService.viewUploadedDocuments(applicationId);
            return new ResponseEntity<>(documents, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view")
    public ModelAndView viewDocuments() {
        System.out.println("Viewing Dovuments....!!");
        return new ModelAndView("viewDocs");
    }



//    @PostMapping("/upload/{applicationId}")
//    public ModelAndView uploadDocument(
//            @PathVariable int applicationId,
//            @RequestParam String documentType,
//            @RequestParam("file") MultipartFile file) {
//
//        ModelAndView modelAndView = new ModelAndView("upload"); // View name (e.g., uploadResult.html or .jsp)
//
//        try {
//            Document document = documentService.uploadDocument(applicationId, documentType, file);
//            modelAndView.addObject("message", "Document uploaded successfully!");
//            modelAndView.addObject("document", document);
//        } catch (IOException e) {
//            modelAndView.addObject("message", "Internal server error during upload.");
//        } catch (RuntimeException e) {
//            modelAndView.addObject("message", "Application ID not found.");
//        } catch (Exception e) {
//            modelAndView.addObject("message", "Bad request or invalid data.");
//        }
//
//        return modelAndView;
//    }

}
