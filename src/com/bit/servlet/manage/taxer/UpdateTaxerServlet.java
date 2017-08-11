package com.bit.servlet.manage.taxer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.base.ResponseResult;
import com.bit.dao.impl.TaxerDaoImpl;
import com.bit.entity.Taxer;

import net.sf.json.JSONObject;
/**
 * 更新税务人员信息
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/updateTaxer")
public class UpdateTaxerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		//获取需要更新的税务人员的更新后信息
		String taxerCode = req.getParameter("taxerCode");
		String taxerName = req.getParameter("taxerName");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String sex = req.getParameter("sex");
		String birthday = req.getParameter("birthday");
		int taxOrganId = Integer.parseInt(req.getParameter("taxOrganId"));
		Taxer taxer = new Taxer(taxerCode, taxerName, mobile, address, sex, birthday, email, taxOrganId);
		
		//调用dao层的update方法进行数据库操作
		TaxerDaoImpl daoImpl = new TaxerDaoImpl();
		boolean state = daoImpl.update(taxer);
		
		//更新成功返回true，更新失败返回false
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
