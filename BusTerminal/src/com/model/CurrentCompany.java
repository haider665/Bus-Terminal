package com.model;

public class CurrentCompany {
	private int index;
	private int companyNum;
	public CurrentCompany(int index, int companyNum) {
		super();
		this.index = index;
		this.companyNum = companyNum;
	}
	public CurrentCompany() {
		
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getCompanyNum() {
		return companyNum;
	}
	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}
	
	
}
