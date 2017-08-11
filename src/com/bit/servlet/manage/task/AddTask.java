package com.bit.servlet.manage.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.bit.entity.User;

import net.sf.json.JSONObject;
/**
 * 新增任务的servlet
 * @author hornlee
 *
 */
@SuppressWarnings("serial")
@WebServlet("/addTask.do")
public class AddTask extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置传出的数据格式为json
		resp.setContentType("application/json;charset=UTF-8");
		//获取要添加字段的值 存入map集合
		Map<String, String[]> map = req.getParameterMap();
		TaxSource taxSource = new TaxSource();
		//将map集合转换为实体类，map集合的key对应与实体类的属性
		try {
			BeanUtils.populate(taxSource, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//将session中的用户ID存入实体中
		User user = (User) req.getSession().getAttribute("user");
		taxSource.setRecordUserId(user.getId());
		
		
	    taxSource.setRecordTaskDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
	    //调用添加方法实现数据库存入
	    TaxSourceDaoImpl daoImpl = new TaxSourceDaoImpl();
		boolean state = daoImpl.add(taxSource);
        
		//反馈给前台，true表示插入成功，反之失败
		ResponseResult result = new ResponseResult();
		if(state){
			result.setSuccess(true);
		}
		else {
			result.setSuccess(false);
		}
		
		//将result转为json数据传到前端
		PrintWriter printWriter = resp.getWriter();
		JSONObject jsonObject = JSONObject.fromObject(result);
		printWriter.print(jsonObject.toString());
		printWriter.flush();
		printWriter.close();
		
	}

}
