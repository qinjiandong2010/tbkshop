package form;
/**
 * 日志配置
 * 
 * @author Jiandong
 */
public class LogSettingForm {
	//日志ID
	private Integer id;
	//表名
	@NotEmpty
	private String tableName;
	//业务名称
	@NotEmpty
	private String businessName;
	//创建用户ID
	private Integer createUserId;
	//创建时间
	private Date createTime;

	public LogSetting() {
	}

	/*
	 *日志ID
	 */
	public Integer getId() {
		return id;
	}
	/*
	 *日志ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/*
	 *表名
	 */
	public String getTableName() {
		return tableName;
	}
	/*
	 *表名
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/*
	 *业务名称
	 */
	public String getBusinessName() {
		return businessName;
	}
	/*
	 *业务名称
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	/*
	 *创建用户ID
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}
	/*
	 *创建用户ID
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	/*
	 *创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/*
	 *创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
