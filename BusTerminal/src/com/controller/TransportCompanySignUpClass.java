package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataAccessObject.TransportCompanyDatabase;
import com.model.TransportCompany;
import com.util.DatabaseConnection;

public class TransportCompanySignUpClass extends HttpServlet {
		
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
		System.out.println("hello world 1");
		RequestDispatcher rd = req.getRequestDispatcher("transportCompanySignUp.html");
		PrintWriter pw = res.getWriter();
		int companyId=getKey();
		System.out.println("hello world 2");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String confirmPassword=req.getParameter("confirmPassword");
		String businessId=req.getParameter("businessId");
		boolean member=false;
		System.out.println("hello world 3");
		if(password.equals(confirmPassword)) {
			System.out.println("hello world 4");
			TransportCompany tcom= new TransportCompany(companyId,name,password,businessId,member);
			boolean check=TransportCompanyDatabase.insert(tcom);
//			System.out.println("hello world 5");
			pw.print(check);
			if(check==true) {
				System.out.println("hello world 6");
				res.sendRedirect("signUpMessage.html");
			} else {
				System.out.println("hello world 7");
				pw.println("<h1>Sign up failed</h1>");
				pw.println("<br><br>");
				rd.include(req, res);
			}
			
		} else {
			
			pw.println("<h1>     pasword doesn't match</h1>");
			pw.println("<br><br>");
			rd.include(req, res);
		}
//		pw.print("hello");
		
	}
	
	public int getKey() throws Exception{
		System.out.println(2222222);
		Connection con=DatabaseConnection.getConnection();
        Statement s = con.createStatement();
        String s2 = "select * from transport_company";
        ResultSet r = s.executeQuery(s2);
        int i=0;
        while (r.next()){
            i= r.getInt("company_id");

        }
        System.out.println(2222222);
        return i+1;
    }
	
	
}
