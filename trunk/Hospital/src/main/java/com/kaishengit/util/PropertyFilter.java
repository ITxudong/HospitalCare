package com.kaishengit.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class PropertyFilter {

	private String propertyName;
	private Object value;
	private String type;
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public static List<PropertyFilter> builderPropertyFilter(HttpServletRequest request) {
		
		Enumeration<String> paramNames = request.getParameterNames();
		//q_S_EQ_name
		List<PropertyFilter> list = new ArrayList<PropertyFilter>();
		
		while(paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			
			if(paramName.startsWith("q_")) {
				String value = request.getParameter(paramName);
				String[] params = paramName.split("_");
				if(params.length == 4) {
					if(StringUtils.isNotEmpty(value)) {
						PropertyFilter filter = createPropertyFilter(value,params);
						list.add(filter);
					}
				}
						
			}
			
			
		}
		return list;
	}
	
	private static PropertyFilter createPropertyFilter(String value,
			String[] params) {
		PropertyFilter pf = new PropertyFilter();
		pf.setPropertyName(params[3]);
		pf.setType(params[2]);
		String dataType = params[1];
		if("S".equalsIgnoreCase(dataType)) {
			pf.setValue(value);
		} else if("I".equalsIgnoreCase(dataType)) {
			pf.setValue(Integer.valueOf(value));
		} else if("D".equalsIgnoreCase(dataType)) {
			pf.setValue(Double.valueOf(value));
		} else if("F".equalsIgnoreCase(dataType)) {
			pf.setValue(Float.valueOf(value));
		} else if("B".equalsIgnoreCase(dataType)) {
			pf.setValue(Boolean.valueOf(value));
		} else if("L".equalsIgnoreCase(dataType)) {
			pf.setValue(Long.valueOf(value));
		}
		return pf;
	}
	
}
