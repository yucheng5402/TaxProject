package com.bit.servlet.system;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理登录成功跳转
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/UserManageServlet")
public class UserManageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//登录成功转到index界面
		resp.sendRedirect(req.getContextPath()+"/manage/index.jsp");
	}

  
}
