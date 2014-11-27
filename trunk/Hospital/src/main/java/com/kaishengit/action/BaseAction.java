package com.kaishengit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	public HttpServletRequest getHttpRequest() {
		
		return ServletActionContext.getRequest();
		
	}
	
	public HttpServletResponse getHttpResponse() {
		return ServletActionContext.getResponse();
	}
	
	public void upload() {
		
		
		
		
	}
	
	
}
