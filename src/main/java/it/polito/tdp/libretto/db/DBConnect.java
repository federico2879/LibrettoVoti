package it.polito.tdp.libretto.db;

import java.sql.*;

public class DBConnect {
	
	public static Connection getConnection() throws SQLException{
		
		String jbdcURL = "jdbc:mariadb://localhost/librettovoti?user=root&password=Armadio2005.";
		Connection conn =  DriverManager.getConnection(jbdcURL);
		return conn;
	}

}
