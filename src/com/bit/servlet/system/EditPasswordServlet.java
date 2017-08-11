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
import com.bit.dao.impl.UserDaoImpl;
import com.bit.entity.User;
import com.bit.util.EncryptUtil;

import net.sf.json.JSONObject;

/**
 * 将修改密码成功与否的结果返回jsp中
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/editPasswordServlet")
public class EditPasswordServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		//获取页面中修改后密码
		String newPassword = req.getParameter("newPassword");
		
		//获取session中user将密码修改
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		String password = EncryptUtil.encryptMD5(newPassword);
		user.setPassword(password);
		
		//调用dao层的update方法对user进行更新
		UserDaoImpl daoImpl = new UserDaoImpl();
		boolean state = false;
		state = daoImpl.update(user);
		
		//更新成功返回true，失败返回false，并传入前台
		ResponseResult result = new ResponseResult();
		if(state){
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
