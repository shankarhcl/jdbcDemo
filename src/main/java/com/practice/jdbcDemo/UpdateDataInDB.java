package com.practice.jdbcDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDataInDB {
	
	public static void main(String[] args) {
		try {
			Connection conn =ConnectionProvider.getConnection();	
			String query = "update persons set name = ?, city = ? where personid = ?";	
			BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name: ");
			String name = br.readLine();		
			System.out.println("Enter city: ");
			String city = br.readLine();
			System.out.println("Enter id: ");
			int id = Integer.parseInt(br.readLine());
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
			System.out.println("data updated");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
