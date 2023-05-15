package com.sagar.installment_calculator_management.services.impl;

import java.util.ArrayList;

//Loan

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.installment_calculator_management.DTO.LoanMasterDTO;
import com.sagar.installment_calculator_management.entity.LoanMaster;
import com.sagar.installment_calculator_management.repository.loanMasterRepo;
import com.sagar.installment_calculator_management.services.LoanMasterService;

@Service
public class LoanMasterServiceImpl implements LoanMasterService {

	@Autowired
	private loanMasterRepo loanTypeRepo;
	
	@Override
	public boolean addLoanMaster(LoanMasterDTO loanTypeDTO) {
		// TODO Auto-generated method stub
		LoanMaster loanType = this.dtoTOLoanType(loanTypeDTO);
		Optional<LoanMaster> checksavedLoanType = loanTypeRepo.findById(loanTypeDTO.getLoanId());
		
		if(checksavedLoanType.isPresent()) {
			return false;
		}
		
		loanTypeRepo.save(loanType);
		return true;
	}

	@Override
	public LoanMasterDTO updateLoanMaster(LoanMasterDTO loanMasterDTO, Integer loanId) {
		// TODO Auto-generated method stub
		LoanMaster loanmasterType = this.dtoTOLoanType(loanMasterDTO);
		LoanMaster loanmasterType1 = this.loanTypeRepo.findById(loanId).get();
		this.loanTypeRepo.delete(loanmasterType1);
		this.loanTypeRepo.save(loanmasterType);
		
		return loanMasterDTO;
	}

	@Override
	public LoanMasterDTO getLoanTypeByLoanID(Integer loanId) {
		// TODO Auto-generated method stub
		Optional<LoanMaster> checkLoanTypeById = this.loanTypeRepo.findById(loanId);
		if(checkLoanTypeById.isPresent()) {
			LoanMasterDTO loanTypeByIdDTO = this.loanTypeTODto(checkLoanTypeById.get());
			return loanTypeByIdDTO;
		}else {
			return null;
		}
		
		
	}

	@Override
	public List<LoanMasterDTO> getAllLoanType() {
		// TODO Auto-generated method stub
		List<LoanMaster> loanTypes = loanTypeRepo.findAll();
		List<LoanMasterDTO> loanTypesDTO=new ArrayList<LoanMasterDTO>();
		for(LoanMaster res:loanTypes) {
			loanTypesDTO.add(loanTypeTODto(res));
		}
		return loanTypesDTO;
	}
	
	public LoanMaster dtoTOLoanType(LoanMasterDTO loanTypeDTO) {
		LoanMaster loanType = new LoanMaster();
		loanType.setLoanId(loanTypeDTO.getLoanId());
		loanType.setTypeofloan(loanTypeDTO.getTypeofloan());
		loanType.setInterestRate(loanTypeDTO.getInterestRate());
		loanType.setDateOfCreation(loanTypeDTO.getDateOfCreation());
		return loanType;
	}
	
	public LoanMasterDTO loanTypeTODto(LoanMaster loanType) {
		LoanMasterDTO loanTypeDTO = new LoanMasterDTO();
		loanTypeDTO.setLoanId(loanType.getLoanId());
		loanTypeDTO.setTypeofloan(loanType.getTypeofloan());
		loanTypeDTO.setInterestRate(loanType.getInterestRate());
		loanTypeDTO.setDateOfCreation(loanType.getDateOfCreation());
		return loanTypeDTO;
	}

}
