package com.dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.TransportCompany;
import com.util.DatabaseConnection;

public class TransportCompanyDatabase {
	
	public static boolean insert(TransportCompany tcom)  {
		int n=0;
		Connection con = DatabaseConnection.getConnection();
		try {
			if( checkUserName(con, tcom.getName()) ==true ) { // checking the user name in transportCompany table if the name is unique or not
				return false;
			}
			String sql= "insert into transport_company values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tcom.getCompanyId());
			ps.setString(2, tcom.getName());
			ps.setString(3, tcom.getPassword());
			ps.setString(4, tcom.getBusinessId());
			ps.setBoolean(5, tcom.isMember() );
			n=ps.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();;
		}
		if(n>0) return true;
		else return false;
	}
    public static Boolean checkUserName(Connection c,String name) throws SQLException {
        String q= "select * from transport_company where name=? ";
        PreparedStatement p= c.prepareStatement(q);
        p.setString(1,name);

        ResultSet r = p.executeQuery();
        if(r.next()){
            return true;
        } else return false;


    }

    public static int fetchByNamePass(String name, String pass) throws SQLException {
    	Connection con=DatabaseConnection.getConnection();
    	String sql="select * from transport_company where name=? and password=? and member=?";
    	PreparedStatement p = con.prepareStatement(sql);
    	p.setString(1, name);
    	p.setString(2, pass);
    	p.setBoolean(3, true);
    	ResultSet rs=p.executeQuery();
    	if(rs.next()) {
    		return Integer.parseInt(rs.getString("company_id"));
    	}
    	return 0;
    }
    public static ResultSet getCompany() throws SQLException {
    	Connection con=DatabaseConnection.getConnection();
    	String sql="select * from transport_company where member=?";
    	PreparedStatement p = con.prepareStatement(sql);
    	p.setBoolean(1, false);
    	ResultSet rs=p.executeQuery();
    	
    	return rs;
    }
    public static void updateCompany(int id) throws SQLException {
    	Connection con=DatabaseConnection.getConnection();
    	String sql="update transport_company set member=? where company_id=?";
    	PreparedStatement p = con.prepareStatement(sql);
    	
    	p.setBoolean(1, true);
    	p.setInt(2, id);
    	p.executeUpdate();
    }
    public static void deleteCompany(int id) throws SQLException {
    	Connection con=DatabaseConnection.getConnection();
    	String sql="delete from transport_company where company_id=?";
    	PreparedStatement p = con.prepareStatement(sql);
    	p.setInt(1, id);
    	p.executeUpdate();
    }
    
    
}
