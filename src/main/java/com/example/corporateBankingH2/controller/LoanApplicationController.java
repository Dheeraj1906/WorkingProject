package com.example.corporateBankingH2.controller;

import com.example.corporateBankingH2.dto.TrackDTO;
import com.example.corporateBankingH2.entity.LoanApplication;
import com.example.corporateBankingH2.service.LoanApplicationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
////@RequestMapping("/api")
public class LoanApplicationController {
//
//    @GetMapping("/home")
//    public ModelAndView homePage(){
//        System.out.println("Gives LaunchingPage!!!!");
////        model.addAttribute("index");
//        return new ModelAndView("index");
////        @GetMapping("/")
////        public String home() {
////            return "index"; // Renders home.jsp from src/main/resources/templates
////        }
//
//    }
//
//
//
    @Autowired
    LoanApplicationServiceImp loanApplicationServiceImp;

    @PostMapping("/appli")
    public ResponseEntity<LoanApplication> submitApplication(@RequestBody LoanApplication loanApplication){
        return ResponseEntity.status(HttpStatus.CREATED).body(loanApplicationServiceImp.submitApplication(loanApplication));
    }

    @GetMapping("/track")
    public ResponseEntity<TrackDTO> trackApplication(@RequestParam Integer applicationId,@RequestParam String companyName) {

        int appId = loanApplicationServiceImp.trackApplication(applicationId,companyName).getApplicationId();
        String companyId = loanApplicationServiceImp.trackApplication(applicationId,companyName).getCompanyName();
        LoanApplication.TrackStatus status = loanApplicationServiceImp.trackApplication(applicationId,companyName).getStatus();

        TrackDTO obj = new TrackDTO();
        obj.setApplicationId(appId);
        obj.setStatus(status);
        obj.setCompanyName(companyName);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/view")
    public ResponseEntity<LoanApplication> viewApplication(@RequestParam Integer applicationId){
        return ResponseEntity.ok().body(loanApplicationServiceImp.viewApplication(applicationId));
    }


    }
