package com.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataAccessObject.BusDatabase;
import com.dataAccessObject.CurrentCompanyDatabase;
import com.dataAccessObject.SeatDatabase;
import com.model.Bus;
import com.model.Seat;
import com.util.DatabaseConnection;

//private int bus_id;
//private String type;
//private int prize;
//private String license;
//private String starting_time;
//private Date date;
//private String destination;
//private int company_id;

public class BusClass extends HttpServlet {
	
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
	
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws Exception  {
		PrintWriter pw= res.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("transportCompanyLoggedIn.html");
		int bus_id=getKey();
		int company_id= CurrentCompanyDatabase.getCurrentCompany();
//		System.out.println(bus_id +"  "+company_id);
		String type=req.getParameter("type");
		int prize= Integer.parseInt(req.getParameter("prize"));
		String license= req.getParameter("license");
		String starting_time=req.getParameter("time");
		String demoDate=req.getParameter("date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(demoDate);
		java.sql.Date date = new java.sql.Date(startDate.getTime());
		String destination=req.getParameter("destination");
		Bus b = new Bus(bus_id, type, prize, license, starting_time, date, destination, company_id);
		System.out.println(111111111);
		int insert=BusDatabase.insertIntoBus(b);
//		System.out.println(000000000);
		if( insert>0) {
			Seat s = new Seat(bus_id);
			SeatDatabase.insertIntoSeat(s);
			pw.println("<h1>insert successful</h1><br>");
			rd.include(req, res);
		} else {
			pw.println("<h1>insert failed</h1><br>");
			rd.include(req, res);
		}
		
		
	}
	public int getKey() throws Exception{
		System.out.println(2222222);
		Connection con=DatabaseConnection.getConnection();
        Statement s = con.createStatement();
        String s2 = "select * from bus";
        ResultSet r = s.executeQuery(s2);
        int i=0;
        while (r.next()){
            i= r.getInt("bus_id");
//            System.out.println(i);
        }
        System.out.println(2222222);
        return i+1;
    }


}





























