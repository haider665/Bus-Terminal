package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataAccessObject.TransportCompanyDatabase;

public class CompanyRequestForAdmin extends HttpServlet {
	
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
		pw.println("<tr> <th> Company Id </th> <th>Name </th>   <th> Accept </th> <th> Cancel </th>    </tr>	");
		ResultSet rs= TransportCompanyDatabase.getCompany();
		while(rs.next()) {
			pw.println("<tr> <td>"+ rs.getInt("company_id")+" </td>  <td>"+  rs.getString("name")+"  </td>  <td> <a href=\"acceptCompany.jsp?id="+rs.getInt("company_id")+"\">Accept</a></td> <td> <a href=\"deleteCompany.jsp?id="+rs.getInt("company_id")+"\">Reject</a></td> </tr>");  	
		}
		pw.println("</table>");
		
		
	}
	
}













