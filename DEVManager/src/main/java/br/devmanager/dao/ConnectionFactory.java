package br.devmanager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_star"
					,"root",
					"");
		} catch (SQLException e) {
			System.out.println("trolei aqui");
			e.printStackTrace();
		}
		return null;	
	}
}
