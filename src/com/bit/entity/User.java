package com.bit.entity;
/**
 * 
 * 对应数据库用户表tb_user
 * @author hornlee
 *
 */
public class User {
    
	private int id; //表主键
	
	private String username; //用户名  要求用户名6-16位

	private String password; //用户密码  要求密码6-20位，至少需要包含数字和字母，md5加密

	private int taxerId; //员工编号 该用户对应的税务工作人员的id
	
	private String salt; //用户盐值 md5加密时的盐值
	
	private int permissionId;//用户权限 1.超级管理员。2.普通管理员。3.普通员工

	private int state;//用户状态  1表示正常使用 0 表示禁用 -1表示离职 -2表示退休 -3表示休假
	
	private String email; //用户工作邮箱 用户工作邮箱必须唯一

	
	
	/**
	 * getter 和setter方法
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
