package com.bit.entity;
/**
 * 行业代码表  tb_industry
 * @author hornlee
 *
 */


public class Industry {

	private int id; //主键 行业编号 
	
	private String industryName; //行业名称 
	
	private String recordDate; // 录入日期 
	
	private int recordUserId; //录入人员 

	/**
	 * getter和setter方法
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
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
	
	
}
