package com.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.entity.WenhuaInfo;
import com.mysql.sqlbean;

import freemarker.template.*;

public class ModuleAction extends ActionSupport {
	private Connection conn;
	private String msg;
	WenhuaInfo wenhua = new WenhuaInfo();
	public String getMsg() {
		return msg;
	}
	
	public WenhuaInfo getWenhua() {
		return wenhua;
	}

	public void setWenhua(WenhuaInfo wenhua) {
		this.wenhua = wenhua;
	}
	public String execute() {
		Map map = new HashMap();
		List list = new ArrayList();
		List list1 = new ArrayList();
	
		sqlbean sl = new sqlbean();
		StaticFreemarker sf = new StaticFreemarker();

		String plate = wenhua.getPlate();

		int t = Integer.parseInt(plate);
		String table = "";
		switch (t) {
		case 3:
			table = "jdwh.ftl";
			break;
		case 5:
			table = "njzs.ftl";
			break;
		case 2:
			table = "pjzs.ftl";
			break;
		case 6:
			table = "jdbz.ftl";
			break;
		case 4:
			table = "jzzz.ftl";
			break;
		case 1:
			table = "sjmz.ftl";
			break;
		}

		String table1 = table.substring(0, 4);
		try {
			String sql = "select * from " + table1 + " ";
			conn = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/zjbk?user=root&password=root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			Map map2 = new HashMap();
			Map map1 = new HashMap();
			while (rs.next()) {
				String title = rs.getString("title");
				String path = rs.getString("path");
				String time = rs.getString("time");
				if (title.length() > 14) {
					title = title.substring(0, 12) + "..";
				} else {
					title = rs.getString("title");
				}
				String totle = time + path;
				map1.put(totle, title);
			}
			list.add(map1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.put("list", list);

		String htmlfile = table1 + "\\" + "index.html";
		String ftl = table1 + "\\" + table;
		try {
			sf.init(ftl, htmlfile, map, "html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.msg = table1;
		return this.SUCCESS;
		
	}

}