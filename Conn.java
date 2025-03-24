package com.hotelmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	Connection conn;
	Statement stmt;

	public Conn() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "root");
		stmt = conn.createStatement();
		
	}

}
