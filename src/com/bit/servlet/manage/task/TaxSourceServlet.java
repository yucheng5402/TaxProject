package com.bit.servlet.manage.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.impl.TaxSourceDaoImpl;

import net.sf.json.JSONObject;
/**
 * 通过分页机制获取税源信息调查
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
@WebServlet("/TaxSourceServlet.action")
public class TaxSourceServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		
		//获取查询条件 存入map集合中
		Map<String, Object> map = new HashMap<String,Object>();
		String payerCode = req.getParameter("payerCode");
		if(payerCode!= null && !"".equals(payerCode.trim())){
			map.put("payerCode", payerCode.trim());
		}
		String payerName = req.getParameter("payerName");
		if(payerName!= null && !"".equals(payerName.trim())){
			map.put("payerName", payerName.trim());
		}
		String OrganId = req.getParameter("subOrganId");
		if(OrganId!=null){
			if(!OrganId.equals("-1")){
			int subOrganId = Integer.parseInt(OrganId);
			map.put("subOrganId", subOrganId);
			}
		}
		String industry = req.getParameter("industryId");
		if(industry!=null){
			if(!industry.equals("-1")){
			int industryId = Integer.parseInt(industry);
			map.put("industryId", industryId);
			}
		} 
		String startTime = req.getParameter("startTime");
		if(startTime!= null && !"".equals(startTime.trim())){
			map.put("startTime", startTime);
		}
		String endTime = req.getParameter("endTime");
		if(endTime!= null && !"".equals(endTime.trim())){
			map.put("endTime", endTime);
		}
		
		//调用查询方法实现分页
		TaxSourceDaoImpl listImpl = new TaxSourceDaoImpl();
		     //page 为当前是第几页， rows 为一页显示多少行
		String pageNow = req.getParameter("page");
		String pageSize = req.getParameter("rows");
		Map<String, Object> map1 = listImpl.selectTaxSourceListByPage(Integer.parseInt(pageNow), Integer.parseInt(pageSize), map);
		//转为json数据传入前台
		JSONObject jsonObject = JSONObject.fromObject(map1);
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(jsonObject.toString());
		printWriter.flush();
		printWriter.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
  
}

