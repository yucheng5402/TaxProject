package com.bit.servlet.manage.taxOrgan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.impl.TaxOrganDaoImpl;
import com.bit.entity.TaxOrgan;

import net.sf.json.JSONArray;

/**
 * 获取税务机关
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/getOrganServlet.do")
public class GetOrganServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		
		//获取所有税务机关信息集合转换为json传入前台
		TaxOrganDaoImpl daoImpl = new TaxOrganDaoImpl();
		List<TaxOrgan> list = daoImpl.getAll();
		JSONArray jsonObject = JSONArray.fromObject(list);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(jsonObject);
		printWriter.flush();
		printWriter.close();
	}
}
