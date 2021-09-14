package com.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

	private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/j2ee_jayesh?autoReconnect=true&useSSL=false";
	private static final String JDBC_USERNAME="root";
	private static final String JDBC_PASSWORD="admin";  
	
	public static Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName(JDBC_DRIVER);
			 connection=DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
