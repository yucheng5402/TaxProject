package com.bit.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bit.dao.BaseDao;
import com.bit.entity.TaxSource;
import com.bit.entity.union.TaxSourceManage;
import com.bit.util.BeanUtils;
import com.bit.util.DBUtil;

/**
 * 税源基础信息表 tb_tax_organ 的基本增删改查方法
 * @author hornlee
 *
 */

public class TaxSourceDaoImpl implements BaseDao<TaxSource>{

	@Override
	public List<TaxSource> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxSource getById(int id) {
		String sql = "select * from tb_tax_source where id=?";
		Object[] args = {id};
		List<Map<String, String>> list = DBUtil.query(sql,args);
		TaxSource taxSource = null;
		if (list != null && list.size() > 0) {
			taxSource = new TaxSource();
			try {
				BeanUtils.parse(list.get(0), taxSource);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return taxSource;
	}

	@Override
	public boolean deleteById(int id) {
		String sql = "delete from tb_tax_source where id=?";
		Object[] args = {id};
		boolean state =DBUtil.update(sql, args);
		return state;
	}

	@Override
	public boolean update(TaxSource t) {
		String sql = "update tb_tax_source set taskName=?,approverId=?,executeId=?,"
				+ "executeTime=?,taskState=?,idea=? where id=?";
		Object[] args = {t.getTaskName(),t.getApproverId(),t.getExecuteId(),
				t.getExecuteTime(),t.getTaskState(),t.getIdea(),t.getId()};
		boolean state = DBUtil.update(sql, args);
		return state;
	}

	@Override
	public boolean add(TaxSource t) {
		String sql = "insert into tb_tax_source "
				+ "(payerId,taskName,subOrganId,approverId,executeId,executeTime,"
				+ "riskLevel,recordTaskDate,recordUserId,taskState,idea) values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args = {t.getPayerId(),t.getTaskName(),t.getSubOrganId(),t.getApproverId(),
				t.getExecuteId(),t.getExecuteTime(),t.getRiskLevel(),t.getRecordTaskDate(),
				t.getRecordUserId(),t.getTaskState(),t.getIdea()};
		boolean state = DBUtil.update(sql, args);
		return state;
	}

	public int count(Map<String, Object> m) {
		int count = 0;
		//String sql = "select COUNT(*) c from tb_tax_source";
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) c FROM tb_tax_source sour, tb_tax_payer pay, "
				+ "tb_industry ind WHERE sour.payerId = pay.id AND pay.industryId = ind.id ");
		if(m!=null && m.size()>0){
			Set<String> set = m.keySet();
			for (String str : set) {
				if(str.equals("payerName")){
					sql.append(" and "+ str + " like '%"+ m.get(str)+ "%'");
				}
				else if(str.equals("startTime"))
				{
					sql.append( " and executeTime >='"+m.get(str)+"'");
				}
				else if(str.equals("endTime"))
				{
					sql.append( " and executeTime <= '"+m.get(str)+"'");
				}
				else{
				sql.append(" and "+ str + " ="+ m.get(str));
				}
			}
		}
		List<Map<String, String>> list = DBUtil.query(sql.toString());
		//List<Map<String, String>> list = DBUtil.query(sql);
		count = Integer.parseInt(list.get(0).get("c"));
		return count;
	}
	//获取查询任务结果的集合，并分页查询
	public Map<String, Object> selectTaxSourceListByPage(Integer pageNow, Integer pageSize,Map<String, Object> m) {
		List<TaxSourceManage> list = new ArrayList<TaxSourceManage>();
		StringBuilder sql = new StringBuilder("SELECT sour.*,pay.payerCode,pay.payerName,"
				+ "ind.industryName,pay.bizScope FROM tb_tax_source sour, tb_tax_payer pay, "
				+ "tb_industry ind WHERE sour.payerId = pay.id AND pay.industryId = ind.id ");
		if(m!=null && m.size()>0){
			Set<String> set = m.keySet();
			for (String str : set) {
				if(str.equals("payerName")){
					sql.append(" and "+ str + " like '%"+ m.get(str)+ "%'");
				}
				else if(str.equals("startTime"))
				{
					sql.append( " and executeTime >='"+m.get(str)+"'");
				}
				else if(str.equals("endTime"))
				{
					sql.append( " and executeTime <= '"+m.get(str)+"'");
				}
				else{
				sql.append(" and "+ str + " ="+ m.get(str));
				}
			}
		}
		sql.append(" ORDER BY pay.`id` ASC limit ?,? ");
		Object[] args = { (pageNow-1)*pageSize, pageSize};
		List<Map<String, String>> listMap = DBUtil.query(sql.toString(), args);
		for (Map<String, String> map : listMap) {
			TaxSourceManage taxSourceManage = new TaxSourceManage();
            try {
				BeanUtils.parse(map, taxSourceManage);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
            taxSourceManage.setOutTime(taxSourceManage.getRecordTaskDate(), taxSourceManage.getExecuteTime());;
            list.add(taxSourceManage);
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("total", count(m));
		map.put("rows", list);
		return map;
	}
}
