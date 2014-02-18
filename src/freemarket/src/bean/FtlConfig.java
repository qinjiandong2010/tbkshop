package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Ä£°åclass
 * 
 * @author Administrator
 * 
 */
public class FtlConfig {

	private String className;

	private String businessName;
	
	private String packagePath;

	private String authorName;

	private List<FtlAttribute> attributes = new ArrayList<FtlAttribute>();

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
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

	public static class FtlAttribute {

		private String name;

		private String dataType;

		private String description;
		
		private Boolean isNull = true;
		
		public FtlAttribute() {
		}

		public FtlAttribute(String name, String dataType, String description,boolean isNull) {
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
	}


	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
}
