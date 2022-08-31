package com.dxc.model;

public class LoanModel {
	private int sn;
	private String username;
	private int loanAmount;
	private String loanType;
	
	public int getSn() {
		return sn;
	}
	
	public void setSn(int sn) {
		this.sn = sn;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
}
