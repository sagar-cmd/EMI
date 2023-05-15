package com.sagar.installment_calculator_management.entity;

//LoanCalc

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LoanAppMaster {

	
	public LoanAppMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private int Id;
	

	private int interestRate;
	private Date applicationDate;
	
	@OneToMany(mappedBy="loanAppMaster")
	List<LoanAppDetailMaster> loanAppDetailMaster;
	
	public int getLoanAppId() {
		return Id;
	}
	public void setLoanAppId(int loanAppId) {
		this.Id = loanAppId;
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
	public LoanAppMaster(int loanAppId, int interestRate, Date applicationDate) {
		super();
		this.Id = loanAppId;
		this.interestRate = interestRate;
		this.applicationDate = applicationDate;
	}
	
}
