package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
//	String sql = "select * from login where uname = ? and pass = ?";
	String url = "jdbc:mysql://localhost:3306/users";
	String username="root";
	String password = "SGs1k@k@";
	public boolean checkDetails(String uname,String pass){
	String sql = "select * from login where uname = ? and pass = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2,pass);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
