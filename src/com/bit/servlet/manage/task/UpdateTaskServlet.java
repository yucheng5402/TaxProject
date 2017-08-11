package com.bit.servlet.manage.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.bit.base.ResponseResult;
import com.bit.dao.impl.TaxSourceDaoImpl;
import com.bit.entity.TaxSource;

import net.sf.json.JSONObject;
/**
 * 更新任务信息Servlet
 * 前后台交互
 * @author Administrator
 */
@SuppressWarnings("serial")
@WebServlet("/updateTask.do")
public class UpdateTaskServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		
		//获取前台更新信息 转为TaxSource实体类
		Map<String, String[]> map =  req.getParameterMap();
		TaxSource source = new TaxSource();
		try {
			BeanUtils.populate(source, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//通过调用TaxSourceDaoImpl的update方法进行数据库更新
		TaxSourceDaoImpl daoImpl = new TaxSourceDaoImpl();
		boolean state = daoImpl.update(source);
		
		//如果更新成功返回true，更新失败返回false
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
