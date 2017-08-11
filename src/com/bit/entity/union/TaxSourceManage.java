package com.bit.entity.union;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaxSourceManage {

    private int id;//任务编号 主键
	
	private int payerId; //纳税人id
	
	private String taskName;//任务名称
	
	private int taxOrganId;//下达部门
	
	private int approverId;//批准人
	
	private int executeId;//执行人员
	
	private String executeTime;//执行时间
	
	private String taskFrom;//任务来源
	
	private String taskState;//任务执行情况
	
	private String idea;//调查结论或意见
	
	private int riskLevel;//风险等级 0无 1低 2中 3高 默认为0
	
	private String recordTaskDate;//录入日期
	
	private int recordUserId;//录入人员
	
	private int removeState;

	private int payerCode;//纳税人识别号
	
	private String payerName;//纳税人名称
	
	private String industryName;//行业
	
	private String bizScope;//范围
	
	private int outTime;//超时时间

	public int getOutTime() {
		return outTime;
	}

	@SuppressWarnings("deprecation")
	public void setOutTime(String recordTaskDate,String  executeTime) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int outTime = 0;
		try {
			Date date1 = sdf.parse(recordTaskDate);
			Date date2 = sdf.parse(executeTime);
			outTime = date1.getDate() - date2.getDate();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		this.outTime = outTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPayerId() {
		return payerId;
	}

	public void setPayerId(int payerId) {
		this.payerId = payerId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getTaxOrganId() {
		return taxOrganId;
	}

	public void setTaxOrganId(int taxOrganId) {
		this.taxOrganId = taxOrganId;
	}

	public int getApproverId() {
		return approverId;
	}

	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}

	public int getExecuteId() {
		return executeId;
	}

	public void setExecuteId(int executeId) {
		this.executeId = executeId;
	}

	public String getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(String executeTime) {
		this.executeTime = executeTime;
	}

	public String getTaskFrom() {
		return taskFrom;
	}

	public void setTaskFrom(String taskFrom) {
		this.taskFrom = taskFrom;
	}

	public String getTaskState() {
		return taskState;
	}

	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public int getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(int riskLevel) {
		this.riskLevel = riskLevel;
	}


	public int getRecordUserId() {
		return recordUserId;
	}

	public void setRecordUserId(int recordUserId) {
		this.recordUserId = recordUserId;
	}

	public int getRemoveState() {
		return removeState;
	}

	public void setRemoveState(int removeState) {
		this.removeState = removeState;
	}

	public int getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(int payerCode) {
		this.payerCode = payerCode;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getBizScope() {
		return bizScope;
	}

	public void setBizScope(String bizScope) {
		this.bizScope = bizScope;
	}

	public String getRecordTaskDate() {
		return recordTaskDate;
	}

	public void setRecordTaskDate(String recordTaskDate) {
		this.recordTaskDate = recordTaskDate;
	}

	@Override
	public String toString() {
		return "TaxSourceManage [id=" + id + ", payerId=" + payerId + ", taskName=" + taskName + ", taxOrganId="
				+ taxOrganId + ", approverId=" + approverId + ", executeId=" + executeId + ", executeTime="
				+ executeTime + ", taskFrom=" + taskFrom + ", taskState=" + taskState + ", idea=" + idea
				+ ", riskLevel=" + riskLevel + ", recordTaskDate=" + recordTaskDate + ", recordUserId=" + recordUserId
				+ ", removeState=" + removeState + ", payerCode=" + payerCode + ", payerName=" + payerName
				+ ", industryName=" + industryName + ", bizScope=" + bizScope + ", outTime=" + outTime + "]";
	}

	 
}
