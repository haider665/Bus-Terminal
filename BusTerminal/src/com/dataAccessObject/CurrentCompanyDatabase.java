package com.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.CurrentCompany;
import com.util.DatabaseConnection;

public class CurrentCompanyDatabase {
	
	public static boolean insert(CurrentCompany cc) {
		Connection con = DatabaseConnection.getConnection();
		String sql="insert into currentcompany values(?,?)";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, cc.getIndex());
			p.setInt(2, cc.getCompanyNum());
			p.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	public static boolean update(CurrentCompany cc) {
		Connection con = DatabaseConnection.getConnection();
		String sql= "update currentcompany set companyNum=? where id=?";
		PreparedStatement p;
		try {
			p = con.prepareStatement(sql);
			p.setInt(1, cc.getCompanyNum());
			p.setInt(2, cc.getIndex() );
			p.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
		
		
	}
	public static int getCurrentCompany() throws SQLException {
		System.out.println("start-----------");
		Connection con = DatabaseConnection.getConnection();
		String sql="select companyNum from currentcompany where id=1";
		PreparedStatement p = con.prepareStatement(sql);
		ResultSet rs=p.executeQuery();
		
		int n=0;
		while(rs.next()) {
			n= Integer.parseInt(rs.getString("companyNum"));
		}
		System.out.println("end-------------");
		return n;
		
	}
	
}
