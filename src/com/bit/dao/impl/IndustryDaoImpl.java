package com.bit.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bit.dao.BaseDao;
import com.bit.entity.Industry;
import com.bit.util.BeanUtils;
import com.bit.util.DBUtil;

/**
 * 行业代码表  tb_industry 的基本增删改查方法
 * @author hornlee
 *
 */

public class IndustryDaoImpl implements BaseDao<Industry>{

	@Override
	public List<Industry> getAll() {
		String sql = "select * from tb_industry";
		List<Map<String, String>> list = DBUtil.query(sql);
		List<Industry> lis = new ArrayList<Industry>();
		Industry industry = null;
		for (Map<String, String> map : list) {
			industry = new Industry();
			try {
				BeanUtils.parse(map, industry);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			lis.add(industry);
		}
		return lis;
	}

	@Override
	public Industry getById(int id) {
		String sql = "select * from tb_industry where id=?";
		Object[] args = {id};
		Industry industry = null;
		List<Map<String, String>> list = DBUtil.query(sql,args);
		if(list!=null&&list.size()>0){
			industry = new Industry();
			try {
				BeanUtils.parse(list.get(0), industry);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return industry;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Industry t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Industry t) {
		// TODO Auto-generated method stub
		return false;
	}

}
