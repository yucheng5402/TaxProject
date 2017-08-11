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
import com.bit.entity.Taxer;
import com.bit.util.BeanUtils;
import com.bit.util.DBUtil;
import com.bit.util.PageTools;

/**
 * 税务人员信息表 tb_taxer 的基本增删改查方法
 * @author hornlee
 *
 */


public class TaxerDaoImpl implements BaseDao<Taxer>{

	@Override
	public List<Taxer> getAll() {
		String sql ="select * from tb_taxer";
		List<Map<String, String>> list = DBUtil.query(sql);
		List<Taxer> lis = new ArrayList<Taxer>();
		Taxer taxer = null;
		for (Map<String, String> map : list) {
			try {
				taxer = new Taxer();
				BeanUtils.parse(map, taxer);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			lis.add(taxer);
		}
		
		return lis;
	}

	@Override
	public Taxer getById(int id) {
		String sql = "select tb_taxer.*,tb_tax_organ.organName from tb_taxer,tb_tax_organ where 1=1 "
				+ "and tb_taxer.organId = tb_tax_organ.id and tb_taxer.id=?";
		Object[] args ={id};
		List<Map<String, String>> list = DBUtil.query(sql,args);
		Taxer taxer = null;
		if(list!=null && list.size()>0){
			taxer = new Taxer();
			try {
				BeanUtils.parse(list.get(0), taxer);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return taxer;
	}

	@Override
	public boolean deleteById(int id) {
		
		String sql = "delete from tb_taxer where id=?";
		Object[] args = {id};
		boolean state = DBUtil.update(sql, args);
		return state;
	}

	@Override
	public boolean update(Taxer t) {
		String sql = "update tb_taxer set mobile=?,email=?,address=?,sex=?,birthday=?,organId=?  where taxerCode=?";
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(t.getBirthday());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Object[] args = {t.getMobile(),t.getEmail(),t.getAddress(),t.getSex(),new java.sql.Date(date.getTime()),t.getOrganId(),t.getTaxerCode()};
		boolean state = DBUtil.update(sql, args);
		
		return state;
	}

	@Override
	public boolean add(Taxer t) {
		String sql = "insert into tb_taxer (taxerCode,taxerName,mobile,address,sex,birthday,organId,email) values(?,?,?,?,?,?,?,?)";
		String bithday = t.getBirthday();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(bithday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] args = {t.getTaxerCode(),t.getTaxerName(),t.getMobile(),t.getAddress(),t.getSex(), new java.sql.Date(date.getTime()), t.getOrganId(),t.getEmail()};
		boolean state =DBUtil.update(sql, args);
		return state;
	}

	public int count() {
		int count = 0;
		String sql = "select COUNT(*) c from tb_taxer";
		List<Map<String, String>> list = DBUtil.query(sql);
		count = Integer.parseInt(list.get(0).get("c"));
		return count;
	}

	public PageTools<Taxer> selectTaxerListByPage(Integer pageNow, Integer pageSize,Map<String, Object> m) {
		PageTools<Taxer> page = new PageTools<Taxer>(pageSize, pageNow, count());
		List<Taxer> list = new ArrayList<Taxer>();
		StringBuilder sql = new StringBuilder("select tb_taxer.*,tb_tax_organ.organName from tb_taxer,tb_tax_organ where 1=1 "
				+ "and tb_taxer.organId = tb_tax_organ.id");
		if(m!=null && m.size()>0){
			Set<String> set = m.keySet();
			for (String str : set) {
				if(str.equals("taxerName")){
					sql.append(" and "+ str + " like '%"+ m.get(str)+ "%'");
				}
			}
		}
		sql.append(" limit ?,? ");
		Object[] args = { (page.getPageNow() - 1) * page.getPageSize(), page.getPageSize() };
		List<Map<String, String>> listMap = DBUtil.query(sql.toString(), args);
		for (Map<String, String> map : listMap) {
			Taxer taxer = new Taxer();
            try {
				BeanUtils.parse(map, taxer);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
            list.add(taxer);
		}
		page.setDate(list);
		return page;
	}
	public static void main(String[] args) {

		TaxerDaoImpl daoImpl = new TaxerDaoImpl();
		daoImpl.selectTaxerListByPage(1, 5,null);
	}
}
