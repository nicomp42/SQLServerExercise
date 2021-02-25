/*
 * Bill Nicholson
 * 
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

import java.util.ArrayList;
import analysis.Analyze;
import analysis.BoringAnalysis;
import analysis.InterestingAnalysis;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> words = SQLServerDemo.readWords();
		System.out.println(words.size() + " words read");
		performAnalysis(new BoringAnalysis(), words);
		performAnalysis(new InterestingAnalysis(), words);
		
		
	}
	/***
	 * Invoke the interface method 
	 * @param tool Any object from a class that implements the Analyze interface
	 * @param wordList A list of words to be processed
	 */
	public static void performAnalysis(Analyze tool, ArrayList<String> wordList) {
		tool.analyzeAndPrint(wordList);
	}

}
