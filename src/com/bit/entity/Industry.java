package com.bit.entity;
/**
 * ��ҵ�����  tb_industry
 * @author hornlee
 *
 */


public class Industry {

	private int id; //���� ��ҵ��� 
	
	private String industryName; //��ҵ���� 
	
	private String recordDate; // ¼������ 
	
	private int recordUserId; //¼����Ա 

	/**
	 * getter��setter����
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
