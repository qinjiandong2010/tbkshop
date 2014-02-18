package com.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.*;

public class Servlet extends HttpServlet {

	private Configuration cfg;

	public void init() {
		cfg = new Configuration();// 创建一个模板实例
		cfg.setServletContextForTemplateLoading(getServletContext(),
				"WEB-INf/templates");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map map = new HashMap();
		map.put("message", "Hello FreeMarker");

		Template t = cfg.getTemplate("test.ftl");

		resp.setContentType("text/html;charset=gbk");
		Writer out = resp.getWriter();
		  
		 
		try {
			t.process(map, out);
			
			
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

}
