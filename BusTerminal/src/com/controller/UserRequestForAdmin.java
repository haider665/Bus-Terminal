package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataAccessObject.TransportCompanyDatabase;
import com.dataAccessObject.UserDatabase;

public class UserRequestForAdmin extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {	
		try {
			process(req, res);
		}catch (Exception e) {
			
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			process(req, res);
		}catch (Exception e) {
			
		}
	}
	
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException, SQLException  {
	
		PrintWriter pw = res.getWriter();
		
		
		pw.println("<table border=\"1\">");
		pw.println("<tr> <th> User Id </th> <th>Name </th>   <th> Accept </th> <th> Cancel </th>    </tr>	");
		ResultSet rs= UserDatabase.getUser();
		while(rs.next()) {
			pw.println("<tr> <td>"+ rs.getInt("user_id")+" </td>  <td>"+  rs.getString("name")+"  </td>  <td> <a href=\"acceptUser.jsp?id="+rs.getInt("user_id")+"\">Accept</a></td> <td> <a href=\"deleteUser.jsp?id="+rs.getInt("user_id")+"\">Reject</a></td> </tr>");  	
		}
		pw.println("</table>");
		
		
	}

}
