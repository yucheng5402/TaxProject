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
import com.bit.dao.impl.UserDaoImpl;
import com.bit.entity.Industry;
import com.bit.entity.TaxOrgan;
import com.bit.entity.TaxPayer;
import com.bit.entity.User;
/**
 * 获取调查任务模块中，纳税人的信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/getTaxPayerInTask.do")
public class GetPayerInTaskServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取要查询纳税人的payerCode
		String payerCode = req.getParameter("payerCode");
		//通过TaxPayerDaoImpl 的 getByPayCode 方法 获取纳税人的一个实体
		TaxPayerDaoImpl daoImpl = new TaxPayerDaoImpl();
		TaxPayer payer = daoImpl.getByPayCode(payerCode);
		
		//如果查询结果不为空，将要展示的信息，通过request对象传到前台
		//如果为空，进入一个错误页面
		if(payer!=null)
		{
		TaxOrganDaoImpl daoImpl2 = new TaxOrganDaoImpl();
		TaxOrgan organ = daoImpl2.getById(payer.gettaxOrganId());
		IndustryDaoImpl daoImpl3 = new IndustryDaoImpl();
		Industry industry = daoImpl3.getById(payer.getIndustryId());
		UserDaoImpl daoImpl4 = new UserDaoImpl();
		User user1 = daoImpl4.getById(payer.getUserId());
		req.setAttribute("payer", payer);
		req.setAttribute("organ", organ);
		req.setAttribute("industry", industry);
		req.setAttribute("user1", user1);
		req.getRequestDispatcher("/manage/addTask.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/manage/error.jsp").forward(req, resp);
		}
	}

}
