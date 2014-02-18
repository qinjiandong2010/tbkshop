package com.mysql;


import java.sql.*;

import javax.servlet.http.HttpServletRequest;

public class sqlbean {
	String sDBDriver = "com.mysql.jdbc.Driver";
	String sConnStr = "jdbc:mysql://127.0.0.1:3306/zjbk?user=powerall&password=123456";
	Connection conn = null;
	ResultSet rs = null;
	private int Page_no;// Paramater of page;
	private int Page_size = 10;// records of every page;
	private int PageTotal = 0;// total pages
	public static int time = 1;
	private int CountTotal;
	private int startrow;

	public sqlbean() {
		try {
			Class.forName(sDBDriver);
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("DataBase();" + e.getMessage());
		}
	}

	// Ö´ÐÐ²éÑ¯Óï¾ä
	public ResultSet executeQuery(String sql) {
		rs = null;
		try {
			conn = DriverManager.getConnection(sConnStr);
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println("DataBase.executeQuery:" + ex.getMessage());
		}
		return rs;
	}
	
	
	public void executeInsert(String sql) {
		try {
			conn = DriverManager.getConnection(sConnStr);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			System.err.println("DataBase.executeUpdate" + ex.getMessage());
		}

	}

	// Ö´ÐÐÉ¾³ý²Ù×÷
	public void executeDelete(String sql) {
		try {
			conn = DriverManager.getConnection(sConnStr);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			System.err.println("DataBese.executeDelete:" + ex.getMessage());
		}
	}
}