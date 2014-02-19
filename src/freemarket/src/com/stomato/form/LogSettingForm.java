package com.stomato.form;
/**
 * 日志配置
 * 
 * @author Admin
 */
public class LogSettingForm {
	//
	@NotEmpty
	private java.lang.Integer id;
	//
	@NotEmpty
	private java.lang.String tableName;
	//
	@NotEmpty
	private java.lang.String businessName;
	//
	@NotEmpty
	private java.lang.Integer createUser;
	//
	@NotEmpty
	private java.util.Date createTime;
	//
	@NotEmpty
	private java.lang.Integer isDel;
	//
	@NotEmpty
	private java.lang.Integer status;

	public LogSetting() {
	}

	/*
	 *
	 */
	public java.lang.Integer getId() {
		return id;
	}
	/*
	 *
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	/*
	 *
	 */
	public java.lang.String getTableName() {
		return tableName;
	}
	/*
	 *
	 */
	public void setTableName(java.lang.String tableName) {
		this.tableName = tableName;
	}
	/*
	 *
	 */
	public java.lang.String getBusinessName() {
		return businessName;
	}
	/*
	 *
	 */
	public void setBusinessName(java.lang.String businessName) {
		this.businessName = businessName;
	}
	/*
	 *
	 */
	public java.lang.Integer getCreateUser() {
		return createUser;
	}
	/*
	 *
	 */
	public void setCreateUser(java.lang.Integer createUser) {
		this.createUser = createUser;
	}
	/*
	 *
	 */
	public java.util.Date getCreateTime() {
		return createTime;
	}
	/*
	 *
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	/*
	 *
	 */
	public java.lang.Integer getIsDel() {
		return isDel;
	}
	/*
	 *
	 */
	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}
	/*
	 *
	 */
	public java.lang.Integer getStatus() {
		return status;
	}
	/*
	 *
	 */
	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
}
