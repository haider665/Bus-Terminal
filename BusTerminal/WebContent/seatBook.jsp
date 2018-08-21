<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.dataAccessObject.SeatDatabase" %>
<%@ page import="com.dataAccessObject.BusDatabase" %>
<%@ page import="com.dataAccessObject.BookingDatabase" %>
<%@ page import="com.dataAccessObject.CurrentUserDatabase" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.model.Booking" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%
	String key=request.getParameter("id");
	String arr[]=key.split("-");
	int bus_id=Integer.parseInt(arr[0]);
	int seat=Integer.parseInt(arr[1]);
	int insertValue= SeatDatabase.updateSeat(false,bus_id, seat);
	if(insertValue>0){
		int user_id=CurrentUserDatabase.getCurrentUser();
		ResultSet rs= BusDatabase.getBusById(bus_id);
		Booking b=null;
		if(rs.next()){
			b= new Booking(user_id,bus_id,seat,rs.getString("destination"), rs.getString("starting_time"),rs.getDate("date"));
		}
		try{
			BookingDatabase.insert(b);
		} catch(Exception e){
			out.println("failed");
		}
		
		out.println("successful");
		RequestDispatcher rd= request.getRequestDispatcher("userLoggedIn.html");
		rd.include(request, response);
	}
%>
</body>
</html>