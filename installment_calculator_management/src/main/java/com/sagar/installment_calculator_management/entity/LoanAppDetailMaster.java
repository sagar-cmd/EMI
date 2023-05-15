package com.sagar.installment_calculator_management.entity;

//ReducedPayment

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LoanAppDetailMaster {

	public LoanAppDetailMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "loanAppId")
	private LoanAppMaster loanAppMaster;
	
	
	private int monthNo;
	private double installment;
	private int interestRate;
	private int pOutStandingBeginOfMon;
	private int pRepayment;
	private int prOutStandingEndOfMon;
	private Date lastDateofinstallPay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoanAppMaster getLoanAppMaster() {
		return loanAppMaster;
	}

	public void setLoanAppMaster(LoanAppMaster loanAppMaster) {
		this.loanAppMaster = loanAppMaster;
	}

	public int getMonthNo() {
		return monthNo;
	}

	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}

	public double getInstallment() {
		return installment;
	}

	public void setInstallment(int installment) {
		this.installment = installment;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	public int getpOutStandingBeginOfMon() {
		return pOutStandingBeginOfMon;
	}

	public void setpOutStandingBeginOfMon(int pOutStandingBeginOfMon) {
		this.pOutStandingBeginOfMon = pOutStandingBeginOfMon;
	}

	public int getpRepayment() {
		return pRepayment;
	}

	public void setpRepayment(int pRepayment) {
		this.pRepayment = pRepayment;
	}

	public int getPrOutStandingEndOfMon() {
		return prOutStandingEndOfMon;
	}

	public void setPrOutStandingEndOfMon(int prOutStandingEndOfMon) {
		this.prOutStandingEndOfMon = prOutStandingEndOfMon;
	}

	public Date getLastDateofinstallPay() {
		return lastDateofinstallPay;
	}

	public void setLastDateofinstallPay(Date lastDateofinstallPay) {
		this.lastDateofinstallPay = lastDateofinstallPay;
	}

	public LoanAppDetailMaster(int id, LoanAppMaster loanAppMaster, int monthNo, int installment, int interestRate,
			int pOutStandingBeginOfMon, int pRepayment, int prOutStandingEndOfMon, Date lastDateofinstallPay) {
		super();
		this.id = id;
		this.loanAppMaster = loanAppMaster;
		this.monthNo = monthNo;
		this.installment = installment;
		this.interestRate = interestRate;
		this.pOutStandingBeginOfMon = pOutStandingBeginOfMon;
		this.pRepayment = pRepayment;
		this.prOutStandingEndOfMon = prOutStandingEndOfMon;
		this.lastDateofinstallPay = lastDateofinstallPay;
	}



}
