package com.bit.entity;


/**
 * ˰����Ա��Ϣ�� tb_taxer
 * @author hornlee
 *
 */
public class Taxer {

	private int id; // ������ 
	
	private String taxerCode; //˰����Ա����
	
	private String taxerName; //˰����Ա����
	
	private String mobile; //˰����Ա�绰 
	
	private String address; //˰����Ա��ַ 
	
	private String sex; //˰����Ա�Ա�
	
	private String birthday; //�������� 
	
	private String email; //�����ʼ� 
	
	private int organId; //����˰����� 
	
	private String organName;//����
	
	private int state; //��Ч��־  1:��Ч 0:��Ч Ĭ��0
	
	private int mgr; //�ϼ��쵼  tb_taxer��˰������Ա
	
	private int admin; //ϵͳ����Ա��־ 1������ 0������ Ĭ��Ϊ0
	
	private String recordDate; // ¼������ 
	
	private int recordUserId; //¼����Ա 

	/**
	 * getter��setter����
	 * @return
	 */
	public int getId() {
		return id;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaxerCode() {
		return taxerCode;
	}

	public void setTaxerCode(String taxerCode) {
		this.taxerCode = taxerCode;
	}

	public String getTaxerName() {
		return taxerName;
	}

	public void setTaxerName(String taxerName) {
		this.taxerName = taxerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOrganId() {
		return organId;
	}

	public void setOrganId(int organId) {
		this.organId = organId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public int getRecordUserId() {
		return recordUserId;
	}

	public void setRecordUserId(int recordUserId) {
		this.recordUserId = recordUserId;
	}

	public Taxer() {
		super();
	}

	public Taxer(String taxerCode, String taxerName, String mobile, String address, String sex, String birthday,
			String email, int organId) {
		super();
		this.taxerCode = taxerCode;
		this.taxerName = taxerName;
		this.mobile = mobile;
		this.address = address;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
		this.organId = organId;
	}
	
	
	
}
