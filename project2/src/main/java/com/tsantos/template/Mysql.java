package com.tsantos.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql extends Database {
	
	private static String url = "jdbc:mysql://localhost:3306/DATABASE";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "USER";
	private static String password = "PWD";
	private static Connection con;
	
	public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }

	@Override
	public
	void openStream() {

		getConnection();

	}

	@Override
	void closeStream() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection closed!");
	}

}
