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
import com.bit.dao.impl.UserDaoImpl;
import com.bit.entity.Industry;
import com.bit.entity.TaxOrgan;
import com.bit.entity.TaxPayer;
import com.bit.entity.TaxSource;
import com.bit.entity.User;
/**
 * 在更新任务中获取一些展示的初始信息
 * @author hornlee
 *
 */
@SuppressWarnings("serial")
@WebServlet("/getTaskInfoToUpdate.do")
public class GetTaskInfoToUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取要更新展示的任务id
		int id = Integer.parseInt(req.getParameter("id"));
		
		//获取需要展示的信息，将这些信息作为初始数据在updateTask.jsp中展示
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
		req.getRequestDispatcher("/manage/updateTask.jsp").forward(req, resp);
	}

}
