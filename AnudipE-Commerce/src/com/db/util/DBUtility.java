package com.db.util;

import java.sql.*;

public class DBUtility {

	public static Connection makeConnection() {
		
		Connection con = null;
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/anudip?user=root&password=0624");
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	/*
	public static void main(String[] args) {
		
		Connection con = DBUtility.makeConnection();
		if(con!=null) {
			
			System.out.println("Connection made successfully!!!");
		}
		else {
			
			System.out.println("Error!!!");
		}
	}
	*/
}
