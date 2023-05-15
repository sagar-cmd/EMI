package com.sagar.installment_calculator_management.services;

//Loan

import java.util.List;

import com.sagar.installment_calculator_management.DTO.LoanMasterDTO;

public interface LoanMasterService {
	
	/*
	 * LoanMasterService is the Service Layer for the Loan Master Module
	 * The requirements include:
	 * 
	 * 1.Creating a new Loan Type  and storing it into the database
	 * 
	 * 2.Reading and retrieving information about particular type of loan based on the given loanId
	 * 
	 * 3.Reading and retrieving information about all types of loan
	 * 
	 * 4.Updating loan information based on the given loanID
	 * 
	 */

	
	
//	1. Creating a new Loan Type  and storing it into the database
	public boolean addLoanMaster(LoanMasterDTO loanType);
	
	
//	2. Reading and retrieving information about particular type of loan based on the given loanId
	public LoanMasterDTO getLoanTypeByLoanID(Integer loanId);
	
	
//	3. Reading and retrieving information about all types of loan
	public List<LoanMasterDTO> getAllLoanType();
	
//	4. Updating loan information based on the given loanID 
	public LoanMasterDTO updateLoanMaster(LoanMasterDTO loanMasterDTO, 
			Integer loanId);
	
}
