package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataAccessObject.BookingDatabase;
import com.dataAccessObject.CurrentUserDatabase;

public class BookingHistory extends HttpServlet {
	
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
		int id= CurrentUserDatabase.getCurrentUser();
		ResultSet rs= BookingDatabase.getBookingHistory(id);
		
		pw.println("<table border=\"1\">");
		pw.println("<tr> <th> User Id </th> <th> Bus Id </th> <th> Seat Number </th> <th> Destination </th> <th> Time </th> <th> Date </th> <th> Cancel </th>    </tr>	");
		while(rs.next()) {
			pw.println("<tr> <td>"+ rs.getInt("user_id")+" </td> <td>"+rs.getInt("bus_id") +"</td>   <td>"+  rs.getInt("seat_id")+"  </td> <td>"+  rs.getString("destination")+"  </td> <td>"+  rs.getString("time")+"  </td> <td>"+  rs.getDate("date")+"  </td> <td> <a href=\"deleteBooking.jsp?id="+rs.getInt("user_id")+"-"+rs.getInt("bus_id")+"-"+rs.getInt("seat_id")+"\">Cancel Ticket</a></td>  </tr>");  	
		}
		pw.println("</table>");
		
	}

}
