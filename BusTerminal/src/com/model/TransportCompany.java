package com.model;

public class TransportCompany {
	
	private int companyId;
	private String name;
	private String password;
	private String businessId;
	private boolean member;
	
	public TransportCompany() {
	}
	
	public TransportCompany(int companyId, String name, String password, String businessId, boolean member) {
		
		this.companyId = companyId;
		this.name = name;
		this.password = password;
		this.businessId = businessId;
		this.member = member;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}
	
	
	
}
