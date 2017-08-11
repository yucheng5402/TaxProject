package com.bit.servlet.manage.taxer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bit.dao.impl.TaxerDaoImpl;
import com.bit.entity.Taxer;

import net.sf.json.JSONArray;
/**
 * 获取税务人员信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/getTaxer.do")
public class GetTaxerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		//获取所有税务人员的信息，方便前台select标枪下拉框的使用
		TaxerDaoImpl daoImpl = new TaxerDaoImpl();
		List<Taxer> list = daoImpl.getAll();
		JSONArray jsonObject = JSONArray.fromObject(list);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(jsonObject);
		printWriter.flush();
		printWriter.close();
	}

	
}
