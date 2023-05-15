package com.sagar.installment_calculator_management.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.installment_calculator_management.DTO.LoanAppDetailMasterDTO;
import com.sagar.installment_calculator_management.entity.LoanAppDetailMaster;
import com.sagar.installment_calculator_management.repository.loanAppDetailMasterRepo;
import com.sagar.installment_calculator_management.repository.loanMasterRepo;
import com.sagar.installment_calculator_management.services.LoanAppDetailMasterService;

@Service
public class LoanAppDetailMasterServiceImpl implements LoanAppDetailMasterService {

	@Autowired
	private loanAppDetailMasterRepo loanEMICalculateRepo;
	
	@Autowired
	private loanMasterRepo loanTypeRepo;
	
	@Override
	public void calculateEMI() {
		// TODO Auto-generated method stub
//		LoanAppDetailMaster emiCalc= this.dtoTOLoanType(loanAppId);
//		LoanMaster loanmasterType1 = this.loanTypeRepo.findById(loanId).get();
//		Optional<LoanAppDetailMaster> emiCalculateId = this.loanEMICalculateRepo.findById(loanAppId);
//		if(emiCalculateId.isPresent())
			
			List<LoanAppDetailMaster>  listofEMICalculated = loanEMICalculateRepo.findAll();
			
			for(LoanAppDetailMaster element:listofEMICalculated) {
//				LoanAppDetailMasterDTO emiCalculateByIdDTO = this.emiCalculateTODto(emiCalculateId.get());
//				return emiCalculateByIdDTO;
//				P fetching it from shunham's module
//				int principal = emiCalculateByIdDTO.getpOutStandingBeginOfMon();
				int principal = element.getpOutStandingBeginOfMon();
//				N
				int loanTenure = element.getMonthNo();
//				Rate of Interest
				int interestRate = element.getLoanAppMaster().getInterestRate();
//				R
				int monthlyInterestRate = interestRate/12/100;
//				(1+R)^N
				double one = Math.pow((1+interestRate), loanTenure);	
//				R*(1+R)^N
				double remainder = monthlyInterestRate*one;
//				(1+R)^N - 1
				double denominator = one - 1;
//				R*(1+R)^N  /  (1+R)^N - 1
				double entity = remainder/denominator;
//				P * R*(1+R)^N  /  (1+R)^N - 1
				double emiInstallment = principal*entity;
//				total amount payable
				double payable = emiInstallment * 120;
				
				element.setInstallment(monthlyInterestRate);
				loanEMICalculateRepo.save(element);
			}
			
//		}
	}
	
	public LoanAppDetailMasterDTO emiCalculateTODto(LoanAppDetailMaster loanAppId) {
		LoanAppDetailMasterDTO emiCalculateDTO = new LoanAppDetailMasterDTO();
		emiCalculateDTO.setId(loanAppId.getId());
		emiCalculateDTO.setLoanAppMaster(loanAppId.getLoanAppMaster());
		emiCalculateDTO.setMonthNo(loanAppId.getMonthNo());
		emiCalculateDTO.setInstallment(loanAppId.getInstallment());
		emiCalculateDTO.setInterestRate(loanAppId.getInterestRate());
		emiCalculateDTO.setpOutStandingBeginOfMon(loanAppId.getpOutStandingBeginOfMon());
		emiCalculateDTO.setpRepayment(loanAppId.getpRepayment());
		emiCalculateDTO.setPrOutStandingEndOfMon(loanAppId.getPrOutStandingEndOfMon());
		emiCalculateDTO.setLastDateofinstallPay(loanAppId.getLastDateofinstallPay());
		return emiCalculateDTO;
	}

}
