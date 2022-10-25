package com.extent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Constants {
	
	public static final String DB_UserName ="";
	public static final String DB_Password ="";
	public static final String DB_ServiceName ="";
	public static final String DB_Hostname ="";
	public static final String DB_PortNumber ="";

	String dbURL ="jdbc:oracle:thin:@//HostName:PortNumber/ServiceName";
	Connection con;
	ResultSet rs;
	Statement selectStmt =null;
	
	public Connection getOracleDBConnection() throws ClassNotFoundException, SQLException {
		dbURL =dbURL.replaceFirst("Hostname",DB_Hostname)
				.replaceFirst("PortNumber",DB_PortNumber)
				.replaceFirst("ServiceName",DB_ServiceName);
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con =DriverManager.getConnection(dbURL, DB_UserName, DB_Password);
	return con;

	}
	
	public ResultSet executeQuery(Connection con,String query) {
		try {
			Statement stmt =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(query);
		}
		catch(Exception e) {
			System.out.println("Exception Occured during query execution"+ e);
			
		}
		return rs;
					
		}
	public int getRow(ResultSet resultset) {
		int size=0;
		try {
			while(resultset.next()) {
				size++;
			}
			resultset.beforeFirst();
		}
		catch(Exception ex) {
			System.out.println("Exception"+ex.toString());
		}
		return  size;
	}
}
