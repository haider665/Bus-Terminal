package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataAccessObject.UserDatabase;
import com.model.User;
import com.util.DatabaseConnection;

//protected int user_id;
//protected String name;
//protected String nid;
//protected int phone;
//protected String password;
//protected boolean member;

public class UserSignUpClass extends HttpServlet {
	
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
		RequestDispatcher rd= req.getRequestDispatcher("userSignUp.html");
		PrintWriter pw = res.getWriter();
		int user_id=getKey();
		String name=req.getParameter("name");
		String nid = req.getParameter("nid");
		String phone= req.getParameter("phone");
		String password= req.getParameter("password");
		String confirmPassword=req.getParameter("confirmPassword");
		boolean member=false;
		if(password.equals(confirmPassword)) {
			User us = new User(user_id, name, nid, phone, confirmPassword, member);
			boolean checkInsert=UserDatabase.insertIntoUser(us);
			if(checkInsert==true) {
				res.sendRedirect("signUpMessage.html");
			} else {
				pw.println("<h1> Sign up failed, try again</h1><br>");
				rd.include(req, res);
			}
		} else {
			pw.println("<h1> wrong password</h1><br>");
			rd.include(req, res);
		}
		
		
		pw.println("hello world");
		
	}
	public int getKey() throws Exception{
		Connection con=DatabaseConnection.getConnection();
        Statement s = con.createStatement();
        String s2 = "select * from user";
        ResultSet r = s.executeQuery(s2);
        int i=0;
        while (r.next()){
            i= r.getInt("user_id");

        }
        return i+1;
    }

}
