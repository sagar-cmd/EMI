package com.sagar.installment_calculator_management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.installment_calculator_management.DTO.LoanMasterDTO;
import com.sagar.installment_calculator_management.services.impl.LoanMasterServiceImpl;

@Controller
@RestController
@RequestMapping("/api/loan")
public class LoanMasterController {

	@Autowired
	private LoanMasterServiceImpl loanTypeService;
	
	//Post-create loan type
    //Using this endpoint the banker will introduce a new loan type  in  bank. It means loan master table 
	@PostMapping("/new")
	public ResponseEntity<Void> createNewLoanType( @RequestBody LoanMasterDTO loanTypeDTO){
		boolean checkLoanTypeDTO= this.loanTypeService.addLoanMaster(loanTypeDTO);
		if(checkLoanTypeDTO)
			return ResponseEntity.status(HttpStatus.CREATED).build();
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	//Put- update loan type
    //Using this endpoint the banker will be able edit the loan information
	@PutMapping("/{loanId}/update")
	public ResponseEntity<LoanMasterDTO> updateLoanType( @RequestBody@Valid LoanMasterDTO userDto,@PathVariable Integer loanId){
		LoanMasterDTO updatedLoan = this.loanTypeService.updateLoanMaster(userDto,loanId);
		return ResponseEntity.ok(updatedLoan);
	}
	
	//GET- single loan
    //Using this endpoint the banker will be able to view a particular type of loan 
	@GetMapping("/{loanId}")
	public ResponseEntity<LoanMasterDTO> getSingleLoanType(@PathVariable Integer loanId){
		if(this.loanTypeService.getLoanTypeByLoanID(loanId) == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(this.loanTypeService.getLoanTypeByLoanID(loanId));
		}
	}
	
	//GET - all loan
    //Using this endpoint the banker will be able to view all types of loan
	@GetMapping("")
	public List<LoanMasterDTO> getAllLoanTypes() {
		return loanTypeService.getAllLoanType();
	}
	
	
}
