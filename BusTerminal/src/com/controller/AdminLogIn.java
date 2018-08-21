package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLogIn extends HttpServlet {
	
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
	
	
	public void process(HttpServletRequest req, HttpServletResponse res) throws IOException  {
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		if(name.equals("haider") && password.equals("haider") ) {
			res.sendRedirect("adminPanel.html");
		}
		
	}

}
