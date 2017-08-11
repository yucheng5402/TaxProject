package com.bit.servlet.manage.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.impl.IndustryDaoImpl;
import com.bit.dao.impl.TaxOrganDaoImpl;
import com.bit.dao.impl.TaxPayerDaoImpl;
import com.bit.dao.impl.TaxSourceDaoImpl;
import com.bit.dao.impl.TaxerDaoImpl;
import com.bit.dao.impl.UserDaoImpl;
import com.bit.entity.Industry;
import com.bit.entity.TaxOrgan;
import com.bit.entity.TaxPayer;
import com.bit.entity.TaxSource;
import com.bit.entity.Taxer;
import com.bit.entity.User;
/**
 * 获取单条任务信息
 * @author Administrator
 *
 */
@WebServlet("/getTaskInfo.do")
@SuppressWarnings("serial")
public class GetTaskInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数id   任务信息表的id
		int id = Integer.parseInt(req.getParameter("id"));
		
		//将一些需要展示的信息已对象的形式传入前台，通过el表达式输出
		TaxSourceDaoImpl daoImpl = new TaxSourceDaoImpl();
		TaxSource source= daoImpl.getById(id);
		req.setAttribute("source", source);
		TaxPayerDaoImpl daoImpl2 = new TaxPayerDaoImpl();
		TaxPayer payer = daoImpl2.getById(source.getPayerId());
		req.setAttribute("payer", payer);
		TaxOrganDaoImpl daoImpl3 = new TaxOrganDaoImpl();
		TaxOrgan organ = daoImpl3.getById(payer.gettaxOrganId());
		req.setAttribute("organ", organ);
		IndustryDaoImpl daoImpl4 = new IndustryDaoImpl();
		Industry industry = daoImpl4.getById(payer.getIndustryId());
		req.setAttribute("industry", industry);
		UserDaoImpl daoImpl5 = new UserDaoImpl();
		User user1 = daoImpl5.getById(payer.getUserId());
		req.setAttribute("user1", user1);
		TaxerDaoImpl daoImpl6 = new TaxerDaoImpl();
		Taxer taxer1 = daoImpl6.getById(source.getApproverId());
		req.setAttribute("taxer1", taxer1);
		Taxer taxer2 = daoImpl6.getById(source.getExecuteId());
		req.setAttribute("taxer2", taxer2);
		req.getRequestDispatcher("/manage/showTaskInfo.jsp").forward(req, resp);
	}

	
}
