package com.sagar.installment_calculator_management.repository;

//LoanCalc

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.installment_calculator_management.entity.LoanAppMaster;

public interface loanAppMasterRepo extends JpaRepository<LoanAppMaster, Integer>{

}
