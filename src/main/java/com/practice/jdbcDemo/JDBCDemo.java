package com.practice.jdbcDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/myDB";
			String username = "postgres";
			String password = "root";
			Connection conn = DriverManager.getConnection(url, username, password);

			if (conn.isClosed()) {
				System.out.println("connection is closed");
			} else {
				System.out.println("connection is open");
			}
			 
			//create table
			/*
			 * String
			 * query="CREATE TABLE Persons(PersonID SERIAL  primary key, Name varchar(255) not null, City varchar(255))"
			 * ; Statement stmt = conn.createStatement(); stmt.executeUpdate(query);
			 * //stmt.executeQuery(query); System.out.println("Table created");
			 */
			 //Insert hardcoded data
			        String query = "insert into Persons (Name, City) values (?,?)";
				    PreparedStatement pstmt = conn.prepareStatement(query); 
					/*
					 * pstmt.setString(1,"Nick"); // setFloat, setDouble pstmt.setString(2,
					 * "London"); pstmt.executeUpdate(); System.out.println("Table data inserted");
					 */
			        
			  //Insert data with dynamic Input
			        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			        System.out.println("Enter name: ");
			        String name =  br.readLine();
			        System.out.println("Enter city: ");
			        String city =  br.readLine();
			        pstmt.setString(1,name);
			        pstmt.setString(2,city);
			        pstmt.executeUpdate();
			        System.out.println("Dynamic Table data inserted");
			        conn.close();

			        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
