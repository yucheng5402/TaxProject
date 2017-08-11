package com.bit.servlet.manage.task;

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
 * 获取没有调查任务的纳税人并分页展示
 * @author hornlee
 *
 */
@SuppressWarnings("serial")
@WebServlet("/getTaxPayerWithoutTask.do")
public class GetTaxPayerWithoutTaskServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		TaxPayerDaoImpl listImpl = new TaxPayerDaoImpl();
		
		//获取分页查询的当前第几页page 和 一页展示的行数rows
		String pageNow = req.getParameter("page");
		String pageSize = req.getParameter("rows");
		
		//获取查询条件		
		String payerCode = req.getParameter("payerCode");
		String payerName = req.getParameter("payerName");
		
		//将查询条件放入map集合中，方便后续操作
		//如果有则放入map，否则不放入
		Map<String, Object> m = new HashMap<String, Object>();
		if(payerCode!=null && !"".equals(payerCode)){
			m.put("payerCode", payerCode.trim());
		}
		if(payerName!=null && !"".equals(payerName)){
			m.put("payerName", payerName.trim());
		}
		//获取所有没有被调查的企业信息（纳税人信息）
		List<Map<String, String>> list = listImpl.getTaxPayerWithoutTask(Integer.parseInt(pageNow), Integer.parseInt(pageSize),m);
		int rows = listImpl.countWithoutTask();
		
		//将集合转为json输出至前台
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", rows);
		map.put("rows", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(jsonObject.toString());
		printWriter.flush();
		printWriter.close();
		
	}

}
