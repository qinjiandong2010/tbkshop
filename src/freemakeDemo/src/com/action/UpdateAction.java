package com.action;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.WenhuaInfo;
import com.mysql.sqlbean;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.pept.transport.Connection;

public class UpdateAction extends ActionSupport {
	private WenhuaInfo wenhua;
	sqlbean sl = new sqlbean();

	public WenhuaInfo getWenhua() {
		return wenhua;
	}

	public void setWenhua(WenhuaInfo wenhua) {
		this.wenhua = wenhua;
	}

	public String execute() {
		String plate = wenhua.getPlate();

		int t = Integer.parseInt(plate);
		String table = "";
		switch (t) {
		case 3:
			table = "jdwh";
			break;
		case 5:
			table = "njzs";
			break;
		case 2:
			table = "pjzs";
			break;
		case 6:
			table = "jdbz";
			break;
		case 4:
			table = "jzzz";
			break;
		case 1:
			table = "sjmz";
			break;
		}
		String sql = "insert into " + table
				+ " (title,time,come,author,path,type,body) values('"
				+ wenhua.getTitle() + "','" + wenhua.getTime() + "','"
				+ wenhua.getCome() + "','" + wenhua.getAuthor() + "','"
				+ wenhua.getPath()+ "','" + wenhua.getType() + "','"
				+ wenhua.getBody() + "') ";
		java.sql.Connection conn;
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/zjbk?user=root&password=root");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.SUCCESS;
	}
}
