package com.bit.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bit.dao.BaseDao;
import com.bit.entity.TaxPayer;
import com.bit.util.BeanUtils;
import com.bit.util.DBUtil;


/**
 * 行业代码表  tb_tax_payer 的基本增删改查方法
 * @author hornlee
 *
 */

public class TaxPayerDaoImpl implements BaseDao<TaxPayer> {

	@Override
	public List<TaxPayer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxPayer getById(int id) {
		String sql = "select * from tb_tax_payer where id=?";
		Object[] args = { id };
		TaxPayer payer = null;
		List<Map<String, String>> list = DBUtil.query(sql, args);
		if (list != null && list.size() > 0) {
			payer = new TaxPayer();
			try {
				BeanUtils.parse(list.get(0), payer);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return payer;
	}

	public TaxPayer getByPayCode(String payerCode) {
		String sql = "select * from tb_tax_payer where payerCode=?";
		Object[] args = { payerCode };
		TaxPayer payer = null;
		List<Map<String, String>> list = DBUtil.query(sql, args);
		if (list != null && list.size() > 0) {
			payer = new TaxPayer();
			try {
				BeanUtils.parse(list.get(0), payer);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return payer;
	}

	@Override
	public boolean deleteById(int id) {
		String sql = "delete from tb_tax_payer where id=?";
		Object[] args = { id };
		boolean state = DBUtil.update(sql, args);
		return state;
	}

	@Override
	public boolean update(TaxPayer t) {
		String sql = "update tb_tax_payer set bizAddress=?,taxOrganId=?,industryId=?,"
				+ "bizScope=?,invoiceType=?,legalPerson=?,legalIdCard=?,bizAddressPhone=?,"
				+ "recordDate=?,finaceName=?,finaceIdCard=?,taxerName=? where payerCode=?";
		Object[] args = { t.getBizAddress(), t.gettaxOrganId(), t.getIndustryId(), t.getBizScope(), t.getInvoiceType(),
				t.getLegalPerson(), t.getLegalIdCard(), t.getBizAddressPhone(), t.getRecordDate(), t.getFinaceName(),
				t.getFinaceIdCard(), t.getTaxerName(), t.getPayerCode() };
		boolean state = DBUtil.update(sql, args);

		return state;
	}

	@Override
	public boolean add(TaxPayer t) {
		String sql = "insert into tb_tax_payer " + "(payerCode, payerName, bizAddress,taxOrganId, "
				+ "industryId, bizScope, invoiceType, legalPerson,"
				+ " legalIdCard, finaceName, finaceIdCard, taxerName, " + "bizAddressPhone,recordDate,userId) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(t.getRecordDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Object[] args = { t.getPayerCode(), t.getPayerName(), t.getBizAddress(), t.gettaxOrganId(), t.getIndustryId(),
				t.getBizScope(), t.getInvoiceType(), t.getLegalPerson(), t.getLegalIdCard(), t.getFinaceName(),
				t.getFinaceIdCard(), t.getTaxerName(), t.getBizAddressPhone(), new java.sql.Date(date.getTime()),
				t.getUserId() };
		boolean state = DBUtil.update(sql, args);

		return state;
	}

	public int count() {
		int count = 0;
		String sql = "select COUNT(*) c from tb_tax_payer";
		List<Map<String, String>> list = DBUtil.query(sql);
		count = Integer.parseInt(list.get(0).get("c"));
		return count;
	}
	public int countWithoutTask() {
		return getIdsWithoutTask().size();
	}

	public List<Map<String, String>> selectTaxPayerListByPage(Integer pageNow, Integer pageSize,
			Map<String, Object> m) {

		StringBuilder sql = new StringBuilder("SELECT pay.id,pay.`payerCode`,pay.`payerName`,org.`organName` ,"
				+ "ind.`industryName`,pay.`legalPerson`,pay.`legalIdCard`, pay.`finaceIdCard`,pay.`finaceName`,"
				+ "pay.`taxerName`,pay.`recordDate`" + "FROM tb_tax_payer pay,tb_tax_organ org, tb_industry ind "
				+ "WHERE 1=1 AND pay.`taxOrganId`=org.`id` AND pay.industryId = ind.`id` ");
		if (m != null && m.size() > 0) {
			Set<String> set = m.keySet();
			for (String str : set) {
				if (str.equals("payerName")) {
					sql.append(" and " + str + " like '%" + m.get(str) + "%'");
				} else {
					sql.append(" and " + str + " =" + m.get(str));
				}
			}
		}
		sql.append(" ORDER BY pay.`id` ASC limit ?,? ");
		Object[] args = { (pageNow - 1) * pageSize, pageSize };
		List<Map<String, String>> list = DBUtil.query(sql.toString(), args);
		return list;
	}
    //获得有调查任务的纳税人的id
	public static List<Integer> getIdsWithTask() {
		List<Integer> list = new ArrayList<Integer>();
		String sql = " SELECT DISTINCT payerId FROM tb_tax_source";
		List<Map<String, String>> listmap = DBUtil.query(sql);
		if (listmap != null && listmap.size() > 0) {
			for (Map<String, String> map : listmap) {
				list.add(Integer.parseInt(map.get("payerId")));
			}
		}
		return list;
	}
	//获得所有纳税人的id
	public static List<Integer> getIds() {
		List<Integer> list = new ArrayList<Integer>();
		String sql = " SELECT DISTINCT id FROM tb_tax_payer";
		List<Map<String, String>> listmap = DBUtil.query(sql);
		if (listmap != null && listmap.size() > 0) {
			for (Map<String, String> map : listmap) {
				list.add(Integer.parseInt(map.get("id")));
			}
		}
		return list;
	}
	//获得没有有调查任务纳税人的id
	public static List<Integer> getIdsWithoutTask(){
		List<Integer> list1 = getIds();
		List<Integer> list2 = getIdsWithTask();
		List<Integer> list = new ArrayList<Integer>();
		list = list1;
		list.removeAll(list2);
		return list;
	}
	//查询没有任务的企业的集合
	public List<Map<String, String>> getTaxPayerWithoutTask(Integer pageNow, Integer pageSize,
			Map<String, Object> m) {

		StringBuilder sql = new StringBuilder("SELECT pay.id,pay.`payerCode`,pay.`payerName`,org.`organName` ,"
				+ "ind.`industryName`,pay.`legalPerson`,pay.`legalIdCard`, pay.`finaceIdCard`,pay.`finaceName`,"
				+ "pay.`taxerName`,pay.`recordDate`" + "FROM tb_tax_payer pay,tb_tax_organ org, tb_industry ind "
				+ "WHERE 1=1 AND pay.`taxOrganId`=org.`id` AND pay.industryId = ind.`id` ");
		if (m != null && m.size() > 0) {
			Set<String> set = m.keySet();
			for (String str : set) {
				if (str.equals("payerName")) {
					sql.append(" and " + str + " like '%" + m.get(str) + "%'");
				} else {
					sql.append(" and " + str + " =" + m.get(str));
				}
			}
		}
		List<Integer> list1 = getIdsWithoutTask();
		if(list1 != null && list1.size()>0){
			sql.append(" and pay.id IN (");
			for (int i = 0; i < list1.size(); i++) {
				if(i<list1.size()-1){
					sql.append(list1.get(i)+",");
				}
				else {
					sql.append(list1.get(i));
				}
			}
			sql.append(")");
		}
		
		sql.append(" ORDER BY pay.`id` ASC limit ?,? ");
		Object[] args = { (pageNow - 1) * pageSize, pageSize };
		List<Map<String, String>> list = DBUtil.query(sql.toString(), args);
		return list;
	}
}