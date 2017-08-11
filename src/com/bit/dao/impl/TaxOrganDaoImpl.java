package com.bit.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bit.dao.BaseDao;
import com.bit.entity.TaxOrgan;
import com.bit.util.BeanUtils;
import com.bit.util.DBUtil;


/**
 * 税务机关表 tb_tax_organ 的基本增删改查方法
 * @author hornlee
 *
 */

public class TaxOrganDaoImpl implements BaseDao<TaxOrgan>{

	@Override
	public List<TaxOrgan> getAll() {
		
		String sql ="select * from tb_tax_organ";
		List<Map<String, String>> list = DBUtil.query(sql);
		List<TaxOrgan> lis = new ArrayList<TaxOrgan>();
		TaxOrgan organ = null;
		for (Map<String, String> map : list) {
			try {
				organ = new TaxOrgan();
				BeanUtils.parse(map, organ);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			lis.add(organ);
		}
		
		return lis;
	}

	@Override
	public  TaxOrgan getById(int id) {
		String sql = "select * from tb_tax_organ where id=?";
		Object[] args = {id};
		TaxOrgan organ = null;
		List<Map<String, String>> list = DBUtil.query(sql,args);
		if(list!=null&&list.size()>0){
			organ = new TaxOrgan();
			try {
				BeanUtils.parse(list.get(0), organ);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return organ;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TaxOrgan t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(TaxOrgan t) {
		// TODO Auto-generated method stub
		return false;
	}

}
