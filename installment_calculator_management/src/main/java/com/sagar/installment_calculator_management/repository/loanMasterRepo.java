package com.sagar.installment_calculator_management.repository;

//Loan

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.installment_calculator_management.entity.LoanMaster;

public interface loanMasterRepo extends JpaRepository<LoanMaster, Integer> {

}
