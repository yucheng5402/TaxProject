package com.bit.servlet.manage.taxIndustry;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.impl.IndustryDaoImpl;
import com.bit.entity.Industry;

import net.sf.json.JSONArray;

/**
 * 获取所有行业信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/getIndustry.do")
public class GetIndustryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		//获取所有行业信息集合转换为json传入前台
		IndustryDaoImpl daoImpl = new IndustryDaoImpl();
		List<Industry> list = daoImpl.getAll();
		JSONArray jsonObject = JSONArray.fromObject(list);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(jsonObject);
		printWriter.flush();
		printWriter.close();
	}

	
}
