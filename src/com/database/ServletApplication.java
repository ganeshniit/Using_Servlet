package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletApplication extends HttpServlet {
	Connection conn;
	Statement stmt;
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3333/register","root","ganesh");
		      stmt=conn.createStatement();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		System.out.println(lastname);
		
		try {
			int i=stmt.executeUpdate("insert into register values('"+firstname+"','"+lastname+"','"+mobile+"','"+email+"','"+password+"')");
			if(i!=0)
			{
				out.print("hello"+"you are in");
			}
			else
			{
				out.print("hello"+"you are not in");
			}
		
		  }
		catch (Exception e) {
			
			e.printStackTrace();
		}
 
	}

}
