package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program03 {

	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/classwork_db";
		final String USERNAME = "root";
		final String PASSWORD = "root";

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "UPDATE emp SET sal= ? WHERE empno = ?";
			try (PreparedStatement statement = connection.prepareCall(sql)) {
				int empno = 8000;
				double salary = 4000;
				statement.setDouble(1, salary);
				statement.setInt(2, empno);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
