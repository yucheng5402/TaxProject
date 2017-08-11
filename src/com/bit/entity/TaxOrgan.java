package com.bit.entity;
/**
 * 税务机关表 tb_tax_organ
 * @author Administrator
 *
 */


public class TaxOrgan {

	private int id; //税务机关代码 主键
	
	private String organName; //税务机关名称 
	
	private int parentId; //上级税务机关代码 
	
	private String address; //税务机关地址 
	
	private String phone; //税务机关联系电话 
	
	private String faxPhone; //传真电话 
	
	private String email;//电子信箱
	
	private int leaderId; //负责人
	
	private String taxTypeCode;  //国地税类型代码国税1000210 地税 1000215
	
	private int state; //有效标志 1:有效 0:无效 默认0
	
	private String recordDate; //录入日期 
	
	private int recordUserId; //录入人员

	/**
	 * getter 和 setter 方法
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
