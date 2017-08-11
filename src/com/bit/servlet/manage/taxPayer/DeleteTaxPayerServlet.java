package com.bit.servlet.manage.taxPayer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.base.ResponseResult;
import com.bit.dao.impl.TaxPayerDaoImpl;

import net.sf.json.JSONObject;

/**
 * 删除纳税人
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/deleteTaxPayer")
public class DeleteTaxPayerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		//获取要删除纳税人的id
		String id = req.getParameter("id");
		TaxPayerDaoImpl daoImpl = new TaxPayerDaoImpl();
		
		//调用删除方法
		boolean state = daoImpl.deleteById(Integer.parseInt(id));
		
		//删除成功返回true，删除失败返回false
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
