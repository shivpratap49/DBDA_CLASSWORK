package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program01 {
	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/classwork_db";
		final String USERNAME = "root";
		final String PASSWORD = "root";

		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement statement = connection.prepareCall("SELECT empno,ename,sal FROM emp WHERE empno = ?");
			statement.setInt(1, 7839);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				int empno = result.getInt(1);
				String name = result.getString(2);
				double salary = result.getDouble(3);
				System.out.println(empno + "-" + name + "-" + salary);
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main1(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/classwork_db";
		final String USERNAME = "root";
		final String PASSWORD = "root";

		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT empno,ename,sal FROM emp WHERE empno = 7839 OR 1");
			while (result.next()) {
				int empno = result.getInt(1);
				String name = result.getString(2);
				double salary = result.getDouble(3);
				System.out.println(empno + "-" + name + "-" + salary);
			}
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
