package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataAccessObject.CurrentCompanyDatabase;
import com.dataAccessObject.TransportCompanyDatabase;
import com.model.CurrentCompany;

public class TransportCompany extends HttpServlet {
	
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
	
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ServletException  {
	
		String name= req.getParameter("name");
		String pass= req.getParameter("pass");
		
		int companyId=TransportCompanyDatabase.fetchByNamePass(name, pass);
		if(companyId!=0) {
			CurrentCompany cc = new  CurrentCompany(1,companyId);
			insertUpdateInCurrentCompany(cc);
			res.sendRedirect("transportCompanyLoggedIn.html");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("transportCompany.html");
			PrintWriter pw = res.getWriter();
			pw.println("<h1> Wrong User </h1>");
			rd.include(req, res);
		}
		
	}
	public void insertUpdateInCurrentCompany(CurrentCompany cc) {
		
		boolean check=CurrentCompanyDatabase.insert(cc);
		if(check==false) {
			CurrentCompanyDatabase.update(cc);
		}
		
		
	}
}



















