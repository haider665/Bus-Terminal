package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataAccessObject.CurrentCompanyDatabase;
import com.dataAccessObject.CurrentUserDatabase;
import com.dataAccessObject.UserDatabase;
import com.model.CurrentCompany;
import com.model.CurrentUser;
import com.model.User;

public class UserSignInClass extends HttpServlet {
	
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
	
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException, SQLException, ServletException  {
		
		PrintWriter pw = res.getWriter();
		
		String phone=req.getParameter("phone");
		String password=req.getParameter("password");
		
		User us = new User(0, null, null, phone, password, false);
		int user= UserDatabase .checkUser(us);
		if(user!=0) {
			CurrentUser cc = new  CurrentUser(1,user);
			insertUpdateInCurrentUser(cc);
			res.sendRedirect("userLoggedIn.html");
		} else {
			pw.println("<br><h1> Wrong user </h1> <br>");
			RequestDispatcher rd = req.getRequestDispatcher("userSignIn.html");
			rd.include(req, res);
		}
	}
	public void insertUpdateInCurrentUser(CurrentUser cc) {
		
		boolean check=CurrentUserDatabase.insert(cc);
		if(check==false) {
			CurrentUserDatabase.update(cc);
		}
		
		
	}

}
