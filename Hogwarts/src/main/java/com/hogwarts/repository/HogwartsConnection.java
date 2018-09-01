package com.hogwarts.repository;

import java.sql.*;

public class HogwartsConnection {
	Connection connection;
	Statement statement;
	
	public void makeConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/hogwarts", "anujaggie", "Anuj@123");
			statement = connection.createStatement();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
