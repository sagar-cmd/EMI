package com.sagar.installment_calculator_management.DTO;

//LoanCalcDTO 

import java.util.Date;
import java.util.List;

//LoanCalcDTO

import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sagar.installment_calculator_management.entity.LoanAppDetailMaster;

public class LoanAppMasterDTO {
	
	public LoanAppMasterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private int loanAppId;
	

	private int interestRate;
	private Date applicationDate;
	
	@OneToMany(mappedBy="loanAppMaster")
	private List<LoanAppDetailMaster> loanAppDetailMaster;
	
	public int getLoanAppId() {
		return loanAppId;
	}
	public void setLoanAppId(int loanAppId) {
		this.loanAppId = loanAppId;
	}
	public int getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public LoanAppMasterDTO(int loanAppId, int interestRate, Date applicationDate) {
		super();
		this.loanAppId = loanAppId;
		this.interestRate = interestRate;
		this.applicationDate = applicationDate;
	}
	@Override
	public String toString() {
		return "LoanAppMasterDTO [loanAppId=" + loanAppId + ", interestRate=" + interestRate + ", applicationDate="
				+ applicationDate + "]";
	}
}
