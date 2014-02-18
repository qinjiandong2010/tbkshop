package com.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Person;
import com.entity.UserInfo;
import com.entity.WenhuaInfo;
import com.mysql.sqlbean;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.*;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private WenhuaInfo wenhua;

	private String msg;

	private ArrayList userList = new ArrayList();

	public ArrayList getUserList() {
		return userList;
	}

	public String getMsg() {
		return msg;
	}

	public WenhuaInfo getWenhua() {
		return wenhua;
	}

	public void setWenhua(WenhuaInfo wenhua) {
		this.wenhua = wenhua;
	}

	@Override
	public String execute() {

		StaticFreemarker sf = new StaticFreemarker();

		List<WenhuaInfo> wenhuaList = new ArrayList<WenhuaInfo>();

		WenhuaInfo wh = new WenhuaInfo();
		wh.setTime(wenhua.getTime());
		wh.setTitle(wenhua.getTitle());
		wh.setBody(wenhua.getBody());
		wh.setCome(wenhua.getCome());
		wh.setAuthor(wenhua.getAuthor());
		wenhuaList.add(wh);
		Map map = new HashMap();

		map.put("list", wenhuaList);
		
		String plate = wenhua.getPlate();
		
		int t=Integer.parseInt(plate);
		String ftl="";
		switch(t) {
		case 3:
			ftl = "jdwh.ftl";
			break;
		case 5:
			ftl = "njzs.ftl";
			break;
		case 2:
			ftl = "pjzs.ftl";
			break;
		case 6:
			ftl = "jdbz.ftl";
			break;
		case 4:
			ftl = "jzzz.ftl";
			break;
		case 1:
			ftl = "sjmz.ftl";
			break;
		}
		String html = ftl.substring(0, 4);
		String htmlfile = html+"\\"+wenhua.getPath();
		try {
			sf.init(ftl, htmlfile, map, "index");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.msg = htmlfile;

		return this.SUCCESS;
	}

}
