package com.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.CurrentCompany;
import com.model.CurrentUser;
import com.util.DatabaseConnection;

public class CurrentUserDatabase {
	
	
	public static boolean insert(CurrentUser cc) {
		Connection con = DatabaseConnection.getConnection();
		String sql="insert into currentUser values(?,?)";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, cc.getId());
			p.setInt(2, cc.getUserNum());
			p.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	public static boolean update(CurrentUser cc) {
		Connection con = DatabaseConnection.getConnection();
		String sql= "update currentUser set userNum=? where id=?";
		PreparedStatement p;
		try {
			p = con.prepareStatement(sql);
			p.setInt(1, cc.getUserNum());
			p.setInt(2, cc.getId() );
			p.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
		
		
	}
	public static int getCurrentUser() throws SQLException {
//		System.out.println("start-----------");
		Connection con = DatabaseConnection.getConnection();
		String sql="select userNum from currentuser where id=1";
		PreparedStatement p = con.prepareStatement(sql);
		ResultSet rs=p.executeQuery();
		
		int n=0;
		while(rs.next()) {
			n= Integer.parseInt(rs.getString("userNum"));
		}
//		System.out.println("end-------------");
		return n;
		
	}
	
}
