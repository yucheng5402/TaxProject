package com.bit.util;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;


/**
 * Map转化为实体类
 * @author DELL
 *
 */
public class BeanUtils {

	public static void parse(Map<String, String> map, Object obj) throws IllegalAccessException, InvocationTargetException {
		ConvertUtils.register(new Converter() {
			
			@SuppressWarnings("unchecked")
			@Override
			public Object convert(@SuppressWarnings("rawtypes") Class type, Object value) {
				 
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return simpleDateFormat.parse(value.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
			}
		}, Date.class);
		org.apache.commons.beanutils.BeanUtils.populate(obj, map);
	}

}
