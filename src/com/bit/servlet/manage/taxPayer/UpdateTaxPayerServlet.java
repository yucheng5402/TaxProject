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

import net.sf.json.JSONObject;
/**
 * 更新纳税人的基本信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/updateTaxPayer.do")
public class UpdateTaxPayerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应头信息
		resp.setContentType("application/json;charset=UTF-8");
		
		//获取更新后的纳税人信息转为实体类
		Map<String, String[]> map =  req.getParameterMap();
		TaxPayer payer = new TaxPayer();
		try {
			BeanUtils.populate(payer, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//调用dao层更新方法
		TaxPayerDaoImpl daoImpl = new TaxPayerDaoImpl();
		boolean state = daoImpl.update(payer);
		//更新成功返回true，失败则返回false
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
