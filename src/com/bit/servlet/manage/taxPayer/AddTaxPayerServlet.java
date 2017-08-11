package com.bit.servlet.manage.taxPayer;

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
import com.bit.dao.impl.TaxPayerDaoImpl;
import com.bit.entity.TaxPayer;
import com.bit.entity.User;

import net.sf.json.JSONObject;
/**
 * 添加纳税人信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/addTaxPayer")
public class AddTaxPayerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		//获取登录用户的id作为纳税人信息添加的录入人id
		int userId =  ((User) req.getSession().getAttribute("user")).getId();
		//获取需要添加的信息转换为实体类
		Map<String, String[]> map =  req.getParameterMap();
		TaxPayer payer = new TaxPayer();
		try {
			BeanUtils.populate(payer, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//将录入人id存入奶水人实体类中
		payer.setUserId(userId);
		
		//调用添加的方法进行数据库操作
        TaxPayerDaoImpl daoImpl = new TaxPayerDaoImpl();
        boolean state = daoImpl.add(payer);
        
        //添加成功返回true，添加失败返回false
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
