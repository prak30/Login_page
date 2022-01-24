package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class Registration extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			PrintWriter out = response.getWriter();
			String firstname = request.getParameter("fname");
			 String regexfname = "^[A-Z]{1}[a-z]{2,}$";
		        Pattern patternfname = Pattern.compile(regexfname);
		        Matcher matchfname = patternfname.matcher(firstname);
		        boolean result = matchfname.matches();
		        if(result == true){
		        	System.out.println(result);
		        	out.println("VALID");
		        }else{
		        	out.println("INVALID");
		        }
		        
			String lastname = request.getParameter("lname");
			 String regexlname = "^[A-Z]{1}[a-z]{2,}$";
		        Pattern patternlname = Pattern.compile(regexlname);
		        Matcher matchlname = patternlname.matcher(lastname);
		        boolean result1 = matchlname.matches();
		        if(result1 == true){
		        	out.println("VALID");
		        }else{
		        	out.println("INVALID");
		        }
		        
			String username = request.getParameter("uname");
			 String regexuname = "^[A-Z]{1}[a-z]{2,}$";
		        Pattern patternuname = Pattern.compile(regexuname);
		        Matcher matchUser = patternuname.matcher(username);
		        boolean result2 = matchUser.matches();
		        if(result2 == true){
		        	out.println("VALID");
		        }else{
		        	out.println("INVALID");
		        }
		        
			String password = request.getParameter("pass");
			String regexPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&-+=()]).{8,}$";
	        Pattern pattern2 = Pattern.compile(regexPassword);
	        Matcher matchPassword = pattern2.matcher(password);
	        boolean result3 = matchPassword.matches();
	        if(result3 == true){
	        	out.println("VALID");
	        }else{
	        	out.println("INVALID");
	        }
	        if(result && result1 && result2 && result3 == true){
	        	Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "insert into login (fname,lname,uname,pass) values (?,?,?,?)";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","SGs1k@k@");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,firstname);
			st.setString(2,lastname);
			st.setString(3,username);
			st.setString(4,password);
			st.executeUpdate();
			System.out.println("you are registered");
			out.println("you are registered");
	        }else{
	        	out.println("OUT");
	        }
			
			response.sendRedirect("login.jsp");
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
