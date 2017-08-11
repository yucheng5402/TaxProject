package com.bit.servlet.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.base.ResponseResult;
import com.bit.entity.User;
import com.bit.util.EncryptUtil;

import net.sf.json.JSONObject;
/**
 * 确认修改密码时，输入的原密码与数据库中密码一样
 * @author hornlee
 *
 */
@SuppressWarnings("serial")
@WebServlet("/confirmPasswordServlet")
public class ConfirmPasswordServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		
		//获取输入的密码
		String Password = req.getParameter("password");
		//与session中的用户密码进行对比
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		String password1 = user.getPassword();
		String password2 = EncryptUtil.encryptMD5(Password);
		
		//如果一致返回true，进行后续操作
		//不一致返回false
		ResponseResult result = new ResponseResult();
			if(password1.equals(password2)){
				result.setSuccess(true);
			}
			else {
				result.setSuccess(false);
			}
			PrintWriter printWriter = resp.getWriter();
			JSONObject jsonObject = JSONObject.fromObject(result);
			printWriter.print(jsonObject.toString());
			printWriter.flush();
			printWriter.close();
	}

	
}
