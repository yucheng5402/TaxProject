package com.bit.entity;
/**
 * 
 * ��Ӧ���ݿ��û���tb_user
 * @author hornlee
 *
 */
public class User {
    
	private int id; //������
	
	private String username; //�û���  Ҫ���û���6-16λ

	private String password; //�û�����  Ҫ������6-20λ��������Ҫ�������ֺ���ĸ��md5����

	private int taxerId; //Ա����� ���û���Ӧ��˰������Ա��id
	
	private String salt; //�û���ֵ md5����ʱ����ֵ
	
	private int permissionId;//�û�Ȩ�� 1.��������Ա��2.��ͨ����Ա��3.��ͨԱ��

	private int state;//�û�״̬  1��ʾ����ʹ�� 0 ��ʾ���� -1��ʾ��ְ -2��ʾ���� -3��ʾ�ݼ�
	
	private String email; //�û��������� �û������������Ψһ

	
	
	/**
	 * getter ��setter����
	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTaxerId() {
		return taxerId;
	}

	public void setTaxerId(int taxerId) {
		this.taxerId = taxerId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", taxerId=" + taxerId
				+ ", salt=" + salt + ", permissionId=" + permissionId + ", state=" + state + ", email=" + email + "]";
	}

}
