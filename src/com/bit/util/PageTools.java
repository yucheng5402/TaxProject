package com.bit.util;

import java.util.List;

/**
 * 分页工具类
 * @author Administrator
 *
 */
public class PageTools<T> {
	//每一页显示的数据条数
	private Integer pageSize; 
	//当前页数
	private Integer pageNow;
    //数据总条数
	private Integer totalRow;
	//总页数
	private Integer pageCount;
	//当前页数据集合
	private List<T> date;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(Integer pageNow) {
		if(pageNow<1){
			pageNow = 1;
		}
		else if(pageNow > pageCount){
			pageNow = pageCount;
		}
		this.pageNow = pageNow;
	}
	public Integer getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(Integer totalRow) {
		this.totalRow = totalRow;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer totalRow , Integer pageSize) {
		pageCount = (totalRow+ pageSize - 1)/pageSize;
	}
	public PageTools(Integer pageSize, Integer pageNow, Integer totalRow) {
		super();
		this.pageSize = pageSize;
		this.totalRow = totalRow;
		this.pageNow = pageNow;
		setPageCount(totalRow, pageSize);
		setPageNow(pageNow);
	}
	public List<T> getDate() {
		return date;
	}
	public void setDate(List<T> date) {
		this.date = date;
	}
	
	
}