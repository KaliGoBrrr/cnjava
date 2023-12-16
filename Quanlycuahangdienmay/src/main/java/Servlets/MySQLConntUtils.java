package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConntUtils {

	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException { 
		String hostname="localhost"; 
		String dbName="quanlycuahangdienmay";
		String Username="root";
		String PassWord="";
		return getMySQLConnection(hostname,dbName,Username, PassWord);
	}
	
	private static Connection getMySQLConnection(String hostname, String dbName, String Username, String PassWord)
			throws ClassNotFoundException, SQLException { 
		Class.forName("com.mysql.jdbc.Driver");
	String connectionURL="jdbc:mysql://"+hostname+":3306/"+dbName; 
	Connection conn=DriverManager.getConnection(connectionURL, Username, PassWord);
	
	return conn;
	}
}