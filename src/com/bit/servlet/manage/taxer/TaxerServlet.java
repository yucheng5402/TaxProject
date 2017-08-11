package com.bit.servlet.manage.taxer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.impl.TaxerDaoImpl;
import com.bit.entity.Taxer;
import com.bit.util.PageTools;

import net.sf.json.JSONObject;
/**
 * 通过分页机制获取税务人员信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/TaxerServlet.action")
public class TaxerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		TaxerDaoImpl listImpl = new TaxerDaoImpl();
		//获取分页 的页数page，和需要展示的条数rows
		String pageNow = req.getParameter("page");
		String pageSize = req.getParameter("rows");
		//获取查询条件
		String taxerName = req.getParameter("taxerName");
		Map<String, Object> m = new HashMap<String, Object>();
		if(taxerName!=null && !"".equals(taxerName)){
			m.put("taxerName", taxerName);
		}
		
		//获取税务人员信息，转为json传入前台
		PageTools<Taxer> page = listImpl.selectTaxerListByPage(Integer.parseInt(pageNow), Integer.parseInt(pageSize),m);
		int rows = listImpl.count();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", rows);
		map.put("rows", page.getDate());
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
