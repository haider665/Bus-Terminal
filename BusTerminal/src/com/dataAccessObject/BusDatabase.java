package com.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Bus;
import com.util.DatabaseConnection;

public class BusDatabase {
	
	public static int insertIntoBus(Bus b) throws SQLException {
		
		Connection con = DatabaseConnection.getConnection();
		String sql="insert into bus values(?,?,?,?,?,?,?,?)";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, b.getBus_id());
		p.setString(2, b.getType());
		p.setInt(3, b.getPrize());
		p.setString(4, b.getLicense() );
		p.setString(5, b.getStarting_time());
		p.setDate(6, b.getDate());
		p.setString(7, b.getDestination() );
		p.setInt(8, b.getCompany_id());
		int n=p.executeUpdate();
		return n;
	}
	public static ResultSet getBus(String destination) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		String sql="select * from bus where destination=?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, destination);
		ResultSet rs= p.executeQuery();
		return rs;
	}
	public static ResultSet getBusById(int id) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		String sql="select * from bus where bus_id=?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs= p.executeQuery();
		return rs;
	}
	
}
