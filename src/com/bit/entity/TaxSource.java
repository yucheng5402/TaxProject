package com.bit.entity;
/**
 * ˰Դ������Ϣ��tb_tax_source
 * @author hornlee
 *
 */


public class TaxSource {

	private int id;//������ ����
	
	private int payerId; //��˰��id
	
	private String taskName;//��������
	
	
	private int approverId;//��׼��
	
	private int executeId;//ִ����Ա
	
	private int subOrganId;//�´ﲿ��
	
	private String executeTime;//ִ��ʱ��
	
	private String taskFrom;//������Դ
	
	private String taskState;//����ִ�����
	
	private String idea;//������ۻ����
	
	private int riskLevel;//���յȼ� 0�� 1�� 2�� 3�� Ĭ��Ϊ0
	
	private String recordTaskDate;//¼������
	
	private int recordUserId;//¼����Ա
	
	private int removeState;

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
