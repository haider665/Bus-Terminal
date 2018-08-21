package com.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Booking;
import com.util.DatabaseConnection;

public class BookingDatabase {
	
	public static void insert(Booking b) throws SQLException {
		Connection con= DatabaseConnection.getConnection();
		String sql="insert into booking values(?,?,?,?,?,?)";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1,b.getUser_id());
		p.setInt(2, b.getBus_id());
		p.setInt(3, b.getSeat_id());
		p.setString(4, b.getDestination());
		p.setString(5, b.getTime());
		p.setDate(6, b.getDate());
		p.executeUpdate();
		
	} 
	public static ResultSet getBookingHistory(int id) throws SQLException {
		Connection con= DatabaseConnection.getConnection();
		String sql="select * from booking where user_id=?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs = p.executeQuery();
		return rs;
	}
	public static void deleteBookingHistory(int user_id, int bus_id, int seat_id) throws SQLException {
		Connection con= DatabaseConnection.getConnection();
		String sql="delete from booking where user_id=? and bus_id=? and seat_id=?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, user_id);
		p.setInt(2, bus_id);
		p.setInt(3, seat_id);
		p.executeUpdate();
		
	}

}









