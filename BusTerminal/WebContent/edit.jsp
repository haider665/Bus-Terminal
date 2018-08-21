<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.dataAccessObject.SeatDatabase" %>

<%
	int bus_id=Integer.parseInt( request.getParameter("id") );
	ResultSet rs = SeatDatabase.getSeat(bus_id);
	out.println("<table border=\"1\">");
	out.println("<tr> <th> Bus Id </th> <th> Seat Number </th> <th> Book </th>   </tr>	");
	while(rs.next()){
		out.println("<tr> <td>"+ rs.getInt("bus_id")+" </td> <td>"+rs.getInt("seat_id") +"</td>  <td> <a href=\"seatBook.jsp?id="+rs.getInt("bus_id")+"-"+rs.getInt("seat_id")+"\">Book Ticket</a></td>  </tr>");  	

	}
	out.println("</table>");
%>

<img src="seat">
</body>
</html>