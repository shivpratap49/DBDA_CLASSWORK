package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program04 {

	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/classwork_db";
		final String USERNAME = "root";
		final String PASSWORD = "root";

		try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			String sql = "DELETE FROM emp WHERE empno = ?";
			try (PreparedStatement statement = connection.prepareCall(sql)) {
				int empno = 8000;
				statement.setInt(1, empno);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
