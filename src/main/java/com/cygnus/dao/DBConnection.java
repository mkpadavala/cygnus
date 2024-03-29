package com.cygnus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {


	private static final String MYSQL_CON_STR = "jdbc:mysql://localhost/finance?user=root&password=krishna";

	public static Connection getConnection() throws Exception{
		
		Connection connection = null;
		try { // DriverManager.registerDriver(new OracleDriver());

			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
			connection = DriverManager.getConnection(MYSQL_CON_STR);
		} catch (Exception e) {
			throw e;
		}
		return connection;
	}

	public static void main(String[] a) {

		try {
			Connection conn = getConnection();
			Statement statement = null;
			if (conn != null) {
				System.out.println("Connection established");
				try {
					statement = conn.createStatement();
					ResultSet r = statement
							.executeQuery("Select sysdate() from dual");
					while (r.next())
						System.out.println(r.getDate(1));
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			}

			if (statement != null) {
				statement.close();
			}
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}