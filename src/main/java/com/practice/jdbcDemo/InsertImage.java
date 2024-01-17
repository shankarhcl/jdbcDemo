package com.practice.jdbcDemo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImage {

	public static void main(String[] args) {
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			String query = "insert into IMAGES (pic) values (?)";
			PreparedStatement pstmt = conn.prepareStatement(query); 
			FileInputStream fis = new FileInputStream("C:\\Users\\Shank\\Downloads\\PDData\\Documents\\photo.png");
					 pstmt.setBinaryStream(1,fis, fis.available());  
					 pstmt.executeUpdate(); 
					 System.out.println("Image inserted");
			         conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
