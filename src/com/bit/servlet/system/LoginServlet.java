package com.bit.servlet.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.impl.UserDaoImpl;
import com.bit.entity.User;
import com.google.code.kaptcha.Constants;

/**
 * 验证码验证
 * 登录用户名密码验证
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取输入验证码
		String captcha = req.getParameter("captcha");
		
		//获取session中的验证码
		HttpSession session = req.getSession();
		String kaptchaValue = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
	    PrintWriter writer = resp.getWriter();
	    
	    //比较验证码，如果相同返回true，不一样返回false执行后续操作
	    if(captcha.equalsIgnoreCase(kaptchaValue)){
	    	writer.print(true);
	    }else{
	    	writer.print(false);
	    }
	    writer.flush();
	    writer.close();
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取session
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//通过用户名密码检测是否存在该用户
		UserDaoImpl daoImpl = new UserDaoImpl();
		User user = daoImpl.validate(username, password);
		PrintWriter writer = resp.getWriter();
		
		//如果用户信息正确，将user存入session会话中，返回true
		if(user!=null){
		      session.setAttribute("user", user);
		      writer.print(true);
		}else{
			writer.print(false);
		}
	}

}
