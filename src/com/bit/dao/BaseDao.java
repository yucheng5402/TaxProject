package com.bit.dao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 获取所有
	 * @return
	 */
	List<T> getAll();
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
    T getById(int id);
    
    /**
     * 删除操作
     * @param id
     * @return
     */
    boolean deleteById(int id);
    /**
     * 更新操作
     * @param t
     * @return
     */
    boolean update(T t);
    
    /**
     * 新增数据
     * @param t
     * @return
     */
    boolean add(T t);
}
