package com.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class StaticFreemarker {
	
	public void init(String ftl,String htmlName,Map map,String fileName) throws IOException, TemplateException
	{
		Configuration freemarkerCfg = new Configuration();
		freemarkerCfg.setServletContextForTemplateLoading(ServletActionContext.getServletContext(), "/"+fileName);
		freemarkerCfg.setEncoding(Locale.getDefault(), "gbk");
		Template template;
		
			template = freemarkerCfg.getTemplate(ftl);
			template.setEncoding("gbk");
			String path= ServletActionContext.getServletContext().getRealPath("/")+"html\\";
			BufferedWriter buff= new BufferedWriter(new FileWriter(path+htmlName));
			
			File htmlFile = new File(path+htmlName);
	
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(htmlFile), "gbk"));		
			template.process(map,out);
			buff.close();
			out.flush();
			out.close();
	}

}
