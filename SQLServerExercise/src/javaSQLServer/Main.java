/*
 * Bill Nicholson
 * nicholdw@ucmail.uc.edu
 * SQL Server example using JDBC
 * 
Sample POM file with the JDBC dependency added.

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>SQLServerExercise</groupId>
  <artifactId>SQLServerExercise</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>JavaSQLServerProjectName</name>
    <dependencies>
		<!-- https://mvnrepository.com/artifact/com.microsoft.sqlserver/mssql-jdbc -->
		<dependency>
		    <groupId>com.microsoft.sqlserver</groupId>
		    <artifactId>mssql-jdbc</artifactId>
		        <version>8.4.1.jre14</version>
		</dependency>
    </dependencies>
  <build>
    <sourceDirectory>src</sourceDirectory>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <release>14</release>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>

 * 
 * 
 * 
 */

package javaSQLServer;

public class Main {

	public static void main(String[] args) {
		SQLServerDemo.demo();

	}

}
