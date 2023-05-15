package com.sagar.installment_calculator_management.entity;

//Loan

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanMaster {
	
	
		public LoanMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
		@Id
		private int loanId;
		
		
		private String typeofloan;
		private int InterestRate;
		private Date dateOfCreation;
		public int getLoanId() {
			return loanId;
		}
		public void setLoanId(int loanId) {
			this.loanId = loanId;
		}
		public String getTypeofloan() {
			return typeofloan;
		}
		public void setTypeofloan(String typeofloan) {
			this.typeofloan = typeofloan;
		}
		public int getInterestRate() {
			return InterestRate;
		}
		public void setInterestRate(int interestRate) {
			InterestRate = interestRate;
		}
		public Date getDateOfCreation() {
			return dateOfCreation;
		}
		public void setDateOfCreation(Date dateOfCreation) {
			this.dateOfCreation = dateOfCreation;
		}
		public LoanMaster(int loanId, String typeofloan, int interestRate, Date dateOfCreation) {
			super();
			this.loanId = loanId;
			this.typeofloan = typeofloan;
			InterestRate = interestRate;
			this.dateOfCreation = dateOfCreation;
		}
		
		
		
}
