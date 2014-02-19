package com.stomato.config;

import java.util.ArrayList;
import java.util.List;

/**
 * ģ��class
 * 
 * @author Administrator
 * 
 */
public class FtlConfig {

	private String className;

	private String businessName;

	private String domain;

	private String authorName;

	private FtlMetaData metaData;

	private List<FtlAttribute> attributes = new ArrayList<FtlAttribute>();

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<FtlAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<FtlAttribute> attributes) {
		this.attributes = attributes;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public FtlMetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(FtlMetaData metaData) {
		this.metaData = metaData;
	}

	public static class FtlMetaData {
		private String name;

		private String type;

		private String description;
		
		public FtlMetaData(){}
		
		public FtlMetaData(String name,String type,String description){
			this.name = name;
			this.type = type;
			this.description = description;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}

	public static class FtlAttribute {

		private String name;

		private String dataType;

		private String description;

		private Boolean isNull = true;

		private FtlMetaData metaData;

		public FtlAttribute() {
		}

		public FtlAttribute(String name, String dataType, String description,
				boolean isNull) {
			this.name = name;
			this.dataType = dataType;
			this.description = description;
			this.isNull = isNull;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getInitcapName() {
			return util.StringUtil.initcap(name);
		}

		public String getDataType() {
			return dataType;
		}

		public void setDataType(String dataType) {
			this.dataType = dataType;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Boolean getIsNull() {
			return isNull;
		}

		public void setIsNull(Boolean isNull) {
			this.isNull = isNull;
		}

		public FtlMetaData getMetaData() {
			return metaData;
		}

		public void setMetaData(FtlMetaData metaData) {
			this.metaData = metaData;
		}
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
}
