package com.bit.servlet.manage.taxPayer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.impl.TaxPayerDaoImpl;
import com.bit.entity.TaxPayer;

/**
 * 通过id获取纳税人信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/getTaxPayerById.do")
public class GetTaxPayerByIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取纳税人id调用方法将纳税人信息转发至jsp
		int id = Integer.parseInt(req.getParameter("id"));
		TaxPayerDaoImpl daoImpl = new TaxPayerDaoImpl();
		TaxPayer payer = daoImpl.getById(id);
		req.setAttribute("payer", payer);
		req.getRequestDispatcher("/manage/updateTaxpayer.jsp").forward(req, resp);
	}

}
