package com.practice.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			if(conn ==null) {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/myDB";
		String username = "postgres";
		String password = "root";
		conn = DriverManager.getConnection(url, username, password);
			} 
		}catch (Exception e) {
		e.printStackTrace();
	}
		return conn;
	}
}
