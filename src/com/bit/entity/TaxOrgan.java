package com.bit.entity;
/**
 * ˰����ر� tb_tax_organ
 * @author Administrator
 *
 */


public class TaxOrgan {

	private int id; //˰����ش��� ����
	
	private String organName; //˰��������� 
	
	private int parentId; //�ϼ�˰����ش��� 
	
	private String address; //˰����ص�ַ 
	
	private String phone; //˰�������ϵ�绰 
	
	private String faxPhone; //����绰 
	
	private String email;//��������
	
	private int leaderId; //������
	
	private String taxTypeCode;  //����˰���ʹ����˰1000210 ��˰ 1000215
	
	private int state; //��Ч��־ 1:��Ч 0:��Ч Ĭ��0
	
	private String recordDate; //¼������ 
	
	private int recordUserId; //¼����Ա

	/**
	 * getter �� setter ����
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFaxPhone() {
		return faxPhone;
	}

	public void setFaxPhone(String faxPhone) {
		this.faxPhone = faxPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public String getTaxTypeCode() {
		return taxTypeCode;
	}

	public void setTaxTypeCode(String taxTypeCode) {
		this.taxTypeCode = taxTypeCode;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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

	public TaxOrgan() {
		super();
	}

	@Override
	public String toString() {
		return "TaxOrgan [id=" + id + ", organName=" + organName + ", parentId=" + parentId + ", address=" + address
				+ ", phone=" + phone + ", faxPhone=" + faxPhone + ", email=" + email + ", leaderId=" + leaderId
				+ ", taxTypeCode=" + taxTypeCode + ", state=" + state + ", recordDate=" + recordDate + ", recordUserId="
				+ recordUserId + "]";
	}
	
	
}
