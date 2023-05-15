package com.sagar.installment_calculator_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.installment_calculator_management.services.impl.LoanAppDetailMasterServiceImpl;

@Controller
@RestController
@RequestMapping("/api/loan")
public class LoanAppDetailMasterController {

	@Autowired
	private LoanAppDetailMasterServiceImpl loanEMICalculateService;
	
//	Post- Calculate Installment
//	Banker  will use this endpoint to calculate monthly emi 
	@PostMapping("/emicalc")
	public void calculatedEMI(){
		loanEMICalculateService.calculateEMI();
	}
	
}
