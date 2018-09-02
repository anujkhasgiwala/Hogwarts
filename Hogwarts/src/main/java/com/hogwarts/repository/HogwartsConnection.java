package com.hogwarts.repository;

import java.sql.*;

public abstract class HogwartsConnection {
	Connection connection;
	
	public void makeConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/hogwarts", "anujaggie", "Anuj@123");;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
