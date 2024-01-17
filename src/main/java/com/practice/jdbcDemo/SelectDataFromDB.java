package com.practice.jdbcDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDataFromDB {
	
		public static void main(String[] args) {
			 try {
				Connection conn = ConnectionProvider.getConnection();
				String query = "select * from  Persons";
				Statement stmt = conn.createStatement();
				ResultSet set = stmt.executeQuery(query);
				
				while (set.next()) {
				  int personid = set.getInt(1);
				  String name =	set.getString(2);
				  String city =	set.getString(3);
				  System.out.println(personid+"--"+name+"--"+city);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
