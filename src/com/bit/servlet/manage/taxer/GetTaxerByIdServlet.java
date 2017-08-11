package com.bit.servlet.manage.taxer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.impl.TaxerDaoImpl;
import com.bit.entity.Taxer;

/**
 * 通过id获取税务人员
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/getTaxerById")
public class GetTaxerByIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取要查询税务人员信息的id
		int id = Integer.parseInt(req.getParameter("id"));
		//调用方法返回税务人员实体类
		TaxerDaoImpl daoImpl = new TaxerDaoImpl();
		Taxer taxer = daoImpl.getById(id);
		req.setAttribute("taxer", taxer);
		//转发到jsp进行信息展示
		req.getRequestDispatcher("/manage/updateTaxer.jsp").forward(req, resp);
		
	}

	
}
