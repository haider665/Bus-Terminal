<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%@ page import="com.dataAccessObject.SeatDatabase" %>
<%@ page import="com.dataAccessObject.BookingDatabase" %>
<%@ page import="com.dataAccessObject.CurrentUserDatabase" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.model.Booking" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%
		
	String s = request.getParameter("id");
	String arr[]= s.split("-");
	int user_id=Integer.parseInt(arr[0]);
	int bus_id=Integer.parseInt(arr[1]);
	int seat_id=Integer.parseInt(arr[2]);
	BookingDatabase.deleteBookingHistory(user_id, bus_id, seat_id);
	SeatDatabase.updateSeat(true, bus_id, seat_id);
	response.sendRedirect("userLoggedIn.html");

%>
<body>

</body>
</html>