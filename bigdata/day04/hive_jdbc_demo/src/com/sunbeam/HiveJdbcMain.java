package com.sunbeam;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HiveJdbcMain {
	public static final String DB_DRIVER = "org.apache.hive.jdbc.HiveDriver";
	public static final String DB_URL = "jdbc:hive2://localhost:10000/edbda";
	public static final String DB_USER = "nilesh";
	public static final String DB_PASSWD = "";
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter job: ");
		String job = sc.nextLine();
		// load and register db driver
		Class.forName(DB_DRIVER);
		// create connection
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD)) {
			// create prepared statement
			String sql = "SELECT * FROM emp WHERE job=?";
			try(PreparedStatement stmt = con.prepareStatement(sql)) {
				// set params, execute query and process results
				stmt.setString(1, job);
				try(ResultSet rs = stmt.executeQuery()) {
					while(rs.next()) {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						Date hire = rs.getDate("hire");
						double sal = rs.getDouble("sal");
						Double comm = rs.getDouble("comm");
						System.out.println(empno + ", " + ename + ", " + hire + ", " + sal + ", " + comm);
					}
				} // close rs
			} // close stmt
		} // close con
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
