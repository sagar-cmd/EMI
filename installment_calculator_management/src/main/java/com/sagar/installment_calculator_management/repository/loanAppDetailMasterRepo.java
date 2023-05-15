package com.sagar.installment_calculator_management.repository;

//ReducedPayment

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.installment_calculator_management.entity.LoanAppDetailMaster;

public interface loanAppDetailMasterRepo extends JpaRepository<LoanAppDetailMaster, Integer> {

}
