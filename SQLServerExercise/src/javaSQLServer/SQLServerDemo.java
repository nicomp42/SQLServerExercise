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
 * 
 */
package javaSQLServer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

public class SQLServerDemo {
	public static void demo() {
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String dbURL = "jdbc:sqlserver://sqlserver001;user=nicomp;password=Danger42!;database=IT2045LoginAttempts";
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
