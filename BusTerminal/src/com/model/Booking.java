package com.model;

import java.sql.Date;

public class Booking {
	protected int user_id;
	protected int bus_id;
	protected int seat_id;
	protected String destination;
	protected String time;
	protected Date date;
	
	public Booking() {
		
	}

	public Booking(int user_id, int bus_id, int seat_id, String destination, String time, Date date) {
		
		this.user_id = user_id;
		this.bus_id = bus_id;
		this.seat_id = seat_id;
		this.destination = destination;
		this.time = time;
		this.date = date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBus_id() {
		return bus_id;
	}

	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}

	public int getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}




















