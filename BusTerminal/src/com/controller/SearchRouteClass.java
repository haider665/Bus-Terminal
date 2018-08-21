package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataAccessObject.BusDatabase;

public class SearchRouteClass extends HttpServlet {
	
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
	
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException  {
		
		String destination=req.getParameter("route");
		ResultSet rs = BusDatabase.getBus(destination);
		PrintWriter pw = res.getWriter();
		
		pw.println("<table border=\"1\">");
		pw.println("<tr> <th> Bus Id </th> <th> Type </th> <th> Ticket Prize </th> <th> License </th> <th>Starting Time</th> <th> Date </th> <th>Destination  </th> <th>Book Ticket</th>  </tr>	");
		while(rs.next()) {
			pw.println("<tr> <td>"+ rs.getInt("bus_id")+" </td> <td>"+rs.getString("type") +"</td> <td>"+ rs.getString("prize") +"</td> <td>"+ rs.getString("license")+" </td> <td>"+rs.getString("starting_time")+"</td> <td>"+ rs.getDate("date") +"</td> <td>"+  rs.getString("destination")+"  </td> <td> <a href=\"edit.jsp?id="+rs.getInt("bus_id")+"\">Book Ticket</a></td>  </tr>");                       
			
		}
		pw.println("</table>");
		
	}
	
}










