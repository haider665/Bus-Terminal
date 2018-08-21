package com.model;

public class CurrentUser {
	private int id;
	private int userNum;
	
	public CurrentUser() {
		
	}

	public CurrentUser(int id, int userNum) {

		this.id = id;
		this.userNum = userNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
	
}
