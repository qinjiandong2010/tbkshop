package form;
/**
 * ��־����
 * 
 * @author Jiandong
 */
public class LogSettingForm {
	//��־ID
	private Integer id;
	//����
	@NotEmpty
	private String tableName;
	//ҵ������
	@NotEmpty
	private String businessName;
	//�����û�ID
	private Integer createUserId;
	//����ʱ��
	private Date createTime;

	public LogSetting() {
	}

	/*
	 *��־ID
	 */
	public Integer getId() {
		return id;
	}
	/*
	 *��־ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/*
	 *����
	 */
	public String getTableName() {
		return tableName;
	}
	/*
	 *����
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/*
	 *ҵ������
	 */
	public String getBusinessName() {
		return businessName;
	}
	/*
	 *ҵ������
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	/*
	 *�����û�ID
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}
	/*
	 *�����û�ID
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	/*
	 *����ʱ��
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/*
	 *����ʱ��
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
