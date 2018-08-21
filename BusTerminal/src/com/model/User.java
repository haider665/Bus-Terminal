package com.model;

public class User {
	
	protected int user_id;
	protected String name;
	protected String nid;
	protected String phone;
	protected String password;
	protected boolean member;
	

	public User() {
		
	}

	public User(int user_id, String name, String nid, String phone, String password, boolean member) {
		this.user_id = user_id;
		this.name = name;
		this.nid = nid;
		this.phone = phone;
		this.password = password;
		this.member = member;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}
	
	
	
	
	
}
