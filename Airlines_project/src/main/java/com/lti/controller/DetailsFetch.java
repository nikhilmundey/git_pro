package com.lti.controller;
import java.io.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DetailsFetch
 */
public class DetailsFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsFetch() {
        super();
        // TODO Auto-generated constructor stub
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=Integer.parseInt(request.getParameter("Eid"));
		String name=request.getParameter("Ename");

		PrintWriter out= response.getWriter();
		//out.print("employee id is "+id+" and name is "+name);
		
		InputStream is=getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties prop=new Properties();
		prop.load(is);
		
		String driver=(String)prop.get("db.driver");
		String url=(String)prop.get("db.url");
		String user=(String)prop.get("db.user");
		String pass=(String)prop.get("db.pass");

		
		try{  
			Class.forName(driver);  
			Connection con=DriverManager.getConnection(url,user,pass);  
			  out.println("Connection established with db!");
			PreparedStatement ps =con.prepareStatement("insert into empl7 values(?,?)");    
			 	ps.setInt(1, id);
	            ps.setString(2, name);
	            
	            int i = ps.executeUpdate();
	            if (i > 0)
	                out.print("Data Successfully entered!!");
	            
	            con.close(); 

			}
		
		catch(Exception e){ 
			System.out.println(e);}  
		
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
