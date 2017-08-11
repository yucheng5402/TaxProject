package com.bit.servlet.manage.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.base.ResponseResult;
import com.bit.dao.impl.TaxSourceDaoImpl;

import net.sf.json.JSONObject;
/**
 * 删除任务的servlet
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/deleteTask.do")
public class DeleteTask extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置传出的数据格式为json
		resp.setContentType("application/json;charset=UTF-8");
		
		//获取要删除任务的id
		String id = req.getParameter("id");
		
		//调用TaxSourceDaoImpl中通过id删除的方法 deleteById
		TaxSourceDaoImpl daoImpl = new TaxSourceDaoImpl();
		boolean state = daoImpl.deleteById(Integer.parseInt(id));
		
		//删除成功返回true 失败返回false
		ResponseResult result = new ResponseResult();
		if(state){
			result.setSuccess(true);
		}
		else {
			result.setSuccess(false);
		}
		//将result转换为json传出
		PrintWriter printWriter = resp.getWriter();
		JSONObject jsonObject = JSONObject.fromObject(result);
		printWriter.print(jsonObject.toString());
		printWriter.flush();
		printWriter.close();
		
	

	}

}
