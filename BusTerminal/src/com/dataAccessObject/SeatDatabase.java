package com.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Seat;
import com.util.DatabaseConnection;

public class SeatDatabase {
	
	public static void insertIntoSeat(Seat s) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		String sql="insert into seat values(?,?,?)";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1,s.getBus_id());
		p.setBoolean(3, true);
		for(int i=1; i<=48; i++) {
			p.setInt(2, i);
			p.executeUpdate();
		}
	}
	public static ResultSet getSeat(int id) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		String sql="select * from seat where bus_id=? and available=?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		p.setBoolean(2, true);
		ResultSet r= p.executeQuery();
		return r;
	}
	public static int updateSeat(boolean value,int bus_id, int seat) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		String sql="update seat set available=? where bus_id=? and seat_id=?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setBoolean(1, value);
		p.setInt(2, bus_id);
		p.setInt(3, seat);
		int n=0;
		n=p.executeUpdate();
		return n;
	}

}


















