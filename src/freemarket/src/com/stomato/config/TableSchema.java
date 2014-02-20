package com.stomato.config;

import java.util.ArrayList;
import java.util.List;

import util.StringUtil;

/**
 * 
 * @author Administrator
 * 
 */
public class TableSchema {

	private String domain;
	
	private String name;

	private String comment;
	
	private String authorName;

	private List<ColumnsSchema> columns = new ArrayList<ColumnsSchema>();
	
	public String getNameI(){
		return StringUtil.getCamelCase(name);
	}
	public String getName() {
		return StringUtil.initcap(StringUtil.getCamelCase(name));
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * 返回数据库名称
	 * @return
	 */
	public String getNameZ() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<ColumnsSchema> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnsSchema> columns) {
		this.columns = columns;
	}

	public static class ColumnsSchema {
		private String name;
		private boolean isNull;
		private String dataType;
		private int length;
		private boolean priKey;
		private String comment;

		public ColumnsSchema() {
		}
		public String getNameI(){
			return StringUtil.getCamelCase(name);
		}
		public String getName() {
			return StringUtil.initcap(StringUtil.getCamelCase(name));
		}
		public String getNameZ() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isNull() {
			return isNull;
		}

		public void setNull(boolean isNull) {
			this.isNull = isNull;
		}
		
		public String getDataType(){
			return getDataTypeName(dataType);
		}

		public String getDataTypeZ() {
			return dataType;
		}

		public void setDataType(String dataType) {
			this.dataType = dataType;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public boolean isPriKey() {
			return priKey;
		}

		public void setPriKey(boolean priKey) {
			this.priKey = priKey;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

	}
	public static String getDataTypeName(String dataType){
    	if(dataType.toLowerCase().equals("datetime")){
    		return "java.util.Date";
    	}else if(dataType.toLowerCase().equals("int")){
    		return "java.lang.Integer";
    	}else if(dataType.toLowerCase().equals("double")){
    		return "java.lang.Double";
    	}else if(dataType.toLowerCase().equals("float")){
    		return "java.lang.Float";
    	}else{
    		return "java.lang.String";
    	}
    }
}
