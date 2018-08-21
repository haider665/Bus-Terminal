package com.model;

import java.sql.Date;

public class Bus {
	private int bus_id;
	private String type;
	private int prize;
	private String license;
	private String starting_time;
	private Date date;
	private String destination;
	private int company_id;
	public Bus() {
		
	}
	public Bus(int bus_id, String type, int prize, String license, String starting_time, Date date, String destination,int company_id) {
		this.bus_id = bus_id;
		this.type = type;
		this.prize = prize;
		this.license = license;
		this.starting_time = starting_time;
		this.date = date;
		this.destination = destination;
		this.company_id = company_id;
	}
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getStarting_time() {
		return starting_time;
	}
	public void setStarting_time(String starting_time) {
		this.starting_time = starting_time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	
	
	
	
}
