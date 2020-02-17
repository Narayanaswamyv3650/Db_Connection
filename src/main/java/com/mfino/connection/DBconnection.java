package com.mfino.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBconnection {
	public static ResultSet data(String name, String dept) throws ClassNotFoundException, SQLException {

		// Accessing driver from the JAR file
		Class.forName("com.mysql.jdbc.Driver");

		// Creating a variable for the connection called "con"
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeportal", "root", "root");

		// after localhost:3306 is where you will put the name of the database
		// jdbc:mysql://localhost:3606/testdb ---> this is a database
		// root is a database user and password too

		// our query below
		PreparedStatement statement = con.prepareStatement("select name, dept from employeeinfo where age='27' ");

		// creating variable to execute query
		ResultSet result = statement.executeQuery();

		// store all the rows data into one variable
		ArrayList<String> sqlData = new ArrayList<String>();

		while (result.next()) {
			sqlData.add(name = result.getString("name"));
			sqlData.add(dept = result.getString("dept"));
			System.out.println("name is" + name + " --- dept is" + dept);
			break;
		}
		return result;
	}
}