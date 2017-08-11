package com.bit.servlet.manage.taxPayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.impl.TaxPayerDaoImpl;

import net.sf.json.JSONObject;

/**
 * 通过分页机制获取纳税人信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/TaxPayerServlet.action")
public class TaxPayerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		TaxPayerDaoImpl listImpl = new TaxPayerDaoImpl();
		
		//获取当前页数page 和   单页显示条数rows
		String pageNow = req.getParameter("page");
		String pageSize = req.getParameter("rows");
		
		//获取查询条件存入map集合中
		String payerCode = req.getParameter("payerCode");
		String payerName = req.getParameter("payerName");
		Map<String, Object> m = new HashMap<String, Object>();
		if(payerCode!=null && !"".equals(payerCode)){
			m.put("payerCode", payerCode);
		}
		if(payerName!=null && !"".equals(payerName)){
			m.put("payerName", payerName);
		}
		
		//将查询出的数据的集合转为json格式传入前台jsp中
		List<Map<String, String>> list = listImpl.selectTaxPayerListByPage(Integer.parseInt(pageNow), Integer.parseInt(pageSize),m);
		int rows = listImpl.count();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", rows);
		map.put("rows", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(jsonObject.toString());
		printWriter.flush();
		printWriter.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
  
}

