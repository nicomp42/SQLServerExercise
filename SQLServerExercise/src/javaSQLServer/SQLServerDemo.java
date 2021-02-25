/*
 * Bill Nicholson
 * 
 * nicholdw@ucmail.uc.edu
 * 
 * USE JDBC to connect to a SQL Server instance: https://www.codejava.net/java-se/jdbc/connect-to-microsoft-sql-server-via-jdbc
 * 
 * Convert a Java Project to Maven: https://crunchify.com/how-to-convert-existing-java-project-to-maven-in-eclipse/
 * 
 * JDBC Repository: https://mvnrepository.com/artifact/com.microsoft.sqlserver/mssql-jdbc 
 */
package javaSQLServer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class SQLServerDemo {
	/**
	 * Read an extensive list of English words from a database table.
	 * The UC VPN needs to be up and running in order to access the database.
	 * @return The ArrayList of words
	 */
	public static ArrayList<String> readWords() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String dbURL = "jdbc:sqlserver://IL-SERVER-002.uccc.uc.edu\\MSSQLSERVER2019;user=2045Login;password=RockWoodStoneMarble!!;database=2045Data";
			Connection conn = DriverManager.getConnection(dbURL);
/*			if (conn != null) {
			    System.out.println("Connected to database server...");
			} */
			Statement sql = conn.createStatement();
			String selectSql = "SELECT * FROM tWord"; 
			try (ResultSet resultSet = sql.executeQuery(selectSql)) {
			    // use resultSet here
				while (resultSet.next()) {
					String word;
					word = resultSet.getString("Word");
					words.add(word);
				}			
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
		}
		return words;
	}
	public static void demo() {
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String dbURL = "jdbc:sqlserver://sqlserver002.uccc.uc.edu;user=xxx;password=xxx!;database=2045Data";
			Connection conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
			    System.out.println("Connected to database server...");
			}
			
			Statement sql = conn.createStatement();
			String selectSql = "SELECT * FROM tLoginAttempt"; 
			try (ResultSet resultSet = sql.executeQuery(selectSql)) {
			    // use resultSet here
				while (resultSet.next()) {
					String login = resultSet.getString("LoginName");
					System.out.println(login);

					// The DateTimeStamp column in the table is a DateTime field but we can access it different ways using JDBC
					Date dateStamp = resultSet.getDate("DateTimeStamp");
					Time timeStamp = resultSet.getTime("DateTimeStamp");
					System.out.println(dateStamp + " : " + timeStamp);
					Boolean loginSucceeded = resultSet.getBoolean("LoginSucceeded");
					System.out.println("Login succeeded : " + loginSucceeded);
				}
				
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex.getLocalizedMessage());
		}
	}
}
