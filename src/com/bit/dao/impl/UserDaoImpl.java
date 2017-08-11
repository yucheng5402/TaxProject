package com.bit.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.bit.dao.BaseDao;
import com.bit.entity.User;
import com.bit.util.BeanUtils;
import com.bit.util.DBUtil;
import com.bit.util.EncryptUtil;

/**
 * 用户表 tb_user 的基本增删改查方法
 * @author hornlee
 *
 */
public class UserDaoImpl implements BaseDao<User>{
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int id) {
		String sql = "select * from tb_user where id=?";
		Object[] args = {id};
		User user = null;
		List<Map<String, String>> list = DBUtil.query(sql,args);
		if(list!=null&&list.size()>0){
			user = new User();
			try {
				BeanUtils.parse(list.get(0), user);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User t) {
		boolean state = false;
		String sql = "update tb_user set password=? where username = ?";
		Object[] args= {t.getPassword(),t.getUsername()};
		state = DBUtil.update(sql,args);
		return state;
	}

	@Override
	public boolean add(User t) {
		// TODO Auto-generated method stub
		return false;
	}
	public User validate(String username ,String pwd){
		String password = EncryptUtil.encryptMD5(pwd);
		String sql = "select * from tb_user where username=? and password=?";
		Object[] args = {username,password};
		User user = null;
		List<Map<String, String>> list = DBUtil.query(sql, args);
		if(list!=null&&list.size()>0){
		     Map<String, String> map = list.get(0);
		     user = new User();
		     try {
				BeanUtils.parse(map, user);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

}
