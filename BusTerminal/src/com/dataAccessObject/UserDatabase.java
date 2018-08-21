package com.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;
import com.util.DatabaseConnection;

public class UserDatabase {
	
	public static boolean insertIntoUser(User us) {
		
		Connection con = DatabaseConnection.getConnection();
		String sql="insert into user values(?,?,?,?,?,?)";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, us.getUser_id());
			p.setString(2, us.getName() );
			p.setString(3, us.getNid() );
			p.setString(4, us.getPhone() );
			p.setString(5, us.getPassword() );
			p.setBoolean(6, us.isMember());
			p.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	public static int checkUser(User us) throws SQLException {
		
		Connection con = DatabaseConnection.getConnection();
		String sql="select * from user where phone=? and password=? and member=?";
		PreparedStatement p = con.prepareStatement(sql);
		p.setString(1, us.getPhone());
		p.setString(2, us.getPassword());
		p.setBoolean(3, true);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			int n=rs.getInt("user_id");
			return n;
		}
		
		return 0;
	}
	public static ResultSet getUser() throws SQLException {
    	Connection con=DatabaseConnection.getConnection();
    	String sql="select * from user where member=?";
    	PreparedStatement p = con.prepareStatement(sql);
    	p.setBoolean(1, false);
    	ResultSet rs=p.executeQuery();
    	
    	return rs;
    }
    public static void updateUser(int id) throws SQLException {
    	Connection con=DatabaseConnection.getConnection();
    	String sql="update user set member=? where user_id=?";
    	PreparedStatement p = con.prepareStatement(sql);
    	
    	p.setBoolean(1, true);
    	p.setInt(2, id);
    	p.executeUpdate();
    }
    public static void deleteUser(int id) throws SQLException {
    	Connection con=DatabaseConnection.getConnection();
    	String sql="delete from user where user_id=?";
    	PreparedStatement p = con.prepareStatement(sql);
    	p.setInt(1, id);
    	p.executeUpdate();
    }
    
	
	
}



















