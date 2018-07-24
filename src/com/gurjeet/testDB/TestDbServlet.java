package com.gurjeet.testDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setup conn variables
		String user="springstudent";
		String password="springstudent";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&allowPublicKeyRetrieval=true";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//get conn to db
		try {
			PrintWriter out=response.getWriter();
			out.println("Connection to db : ");
			Class.forName(driver).newInstance();
			
			Connection myConn=DriverManager.getConnection(jdbcUrl, user, password);
			
			out.println("Connection success!!");
			myConn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			//throw new ServletException(e);
		}
	}

}
