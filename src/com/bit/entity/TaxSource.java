package com.bit.entity;
/**
 * 税源基础信息表tb_tax_source
 * @author hornlee
 *
 */


public class TaxSource {

	private int id;//任务编号 主键
	
	private int payerId; //纳税人id
	
	private String taskName;//任务名称
	
	
	private int approverId;//批准人
	
	private int executeId;//执行人员
	
	private int subOrganId;//下达部门
	
	private String executeTime;//执行时间
	
	private String taskFrom;//任务来源
	
	private String taskState;//任务执行情况
	
	private String idea;//调查结论或意见
	
	private int riskLevel;//风险等级 0无 1低 2中 3高 默认为0
	
	private String recordTaskDate;//录入日期
	
	private int recordUserId;//录入人员
	
	private int removeState;

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

	public int getSubOrganId() {
		return subOrganId;
	}

	public void setSubOrganId(int subOrganId) {
		this.subOrganId = subOrganId;
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

	public int getRemoveState() {
		return removeState;
	}

	public void setRemoveState(int removeState) {
		this.removeState = removeState;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
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

	
	public String getRecordTaskDate() {
		return recordTaskDate;
	}

	public void setRecordTaskDate(String recordTaskDate) {
		this.recordTaskDate = recordTaskDate;
	}

	public int getRecordUserId() {
		return recordUserId;
	}

	public void setRecordUserId(int recordUserId) {
		this.recordUserId = recordUserId;
	}
	
	
}
