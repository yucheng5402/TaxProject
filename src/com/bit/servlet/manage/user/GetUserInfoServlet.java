package com.bit.servlet.manage.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.impl.TaxerDaoImpl;
import com.bit.entity.Taxer;
import com.bit.entity.User;

/**
 * 获取用户信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/userServlet")
public class GetUserInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取登录时设置session的用户user信息
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//通过用户id获取对应税务人员的信息
		TaxerDaoImpl daoImpl = new TaxerDaoImpl();
		Taxer taxer = daoImpl.getById(user.getTaxerId());
		req.setAttribute("taxer", taxer);
		//通过request的转发到前台jsp进行展示
		req.getRequestDispatcher("/manage/showPersonInfo.jsp").forward(req, resp);
		
	}
	
	

}
